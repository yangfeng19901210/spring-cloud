package com.yf.generatecode.utils;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import java.util.ArrayList;
import java.util.List;

public class MpGenerator {

    public static void main(String[] args) throws InterruptedException {

        //用来获取Mybatis-Plus.properties文件的配置信息
        //final ResourceBundle rb = ResourceBundle.getBundle("mybatisplus");


        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setUrl(
            "jdbc:mysql://47.93.43.154:6033/ih_chronic?useUnicode=true&characterEncoding=utf8&useSSL=false");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("SXYX@2021!");
        dsc.setTypeConvert(new MySqlTypeConvertCustom());
        mpg.setDataSource(dsc);
        //代码生成位置设置
        CodePath codePath = CodePath.builder().projectRootPath("D:/springCloud/spring-generate-code")
            .basePackage("cn.shanxincd.ih.chronic").build();
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(codePath.getProjectRootPath()+"/src/main/java");  //修改成自己的项目路径一直到java
        gc.setFileOverride(true);//覆盖已有文件
        gc.setOpen(false);
        gc.setBaseResultMap(true);
        gc.setBaseColumnList(true);
        gc.setAuthor("yf");
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper.xml");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setControllerName("%sController");
        gc.setDateType(DateType.ONLY_DATE);
        mpg.setGlobalConfig(gc);


        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent(codePath.getBasePackage());
        //pc.setController("controller");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        pc.setEntity("entity");
        pc.setMapper("dao");
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板 引擎是 velocity
        //String templatePath = "/templates/mapper.xml.vm";
        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                String mapperXmlPath = codePath.getProjectRootPath()+"/src/main/resources/mapper/";
                return mapperXmlPath  + tableInfo
                    .getEntityName() + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
        mpg.setTemplate(new TemplateConfig().setXml(null));

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);

        //建立不包含哪些表
        //strategy.setExclude(new String[]{rb.getString("tableName")});

        //建立包含哪些表空 为所有表
        strategy.setInclude("chronic_medication_plan","chronic_medication_plan_drug");
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }
}