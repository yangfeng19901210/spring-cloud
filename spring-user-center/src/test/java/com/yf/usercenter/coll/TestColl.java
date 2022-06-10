package com.yf.usercenter.coll;

import java.util.LinkedList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author yangfeng
 * @version 1.0
 * @date 2022-05-30 9:32
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class TestColl {
  /***
   * LinkedList 底层是通过双向链表实现的，除了可以当做链表来操作外，它还可以当做栈、队列和双端队列来使用
   * LinkedList同样是非线程安全的，只在单线程下适合使用
   * LinkedList实现了Serializable接口，因此它支持序列化，能够通过序列化传输，实现了Cloneable接口，能被克隆
   * 缺点：随机访问的速度比较慢
   * 优点：删除、插入操作比较快
   */
  private LinkedList<String> list = new LinkedList<String>();
  @Before
  public void init(){
    list.add("张三");
    list.add("李四");
    list.add("王五");
  }
  @Test
  public void testLinkOperation(){
    list.push("张小云");
    list.push("何中华");
    list.offer("陈云");
    System.out.println(list);
  }


}
