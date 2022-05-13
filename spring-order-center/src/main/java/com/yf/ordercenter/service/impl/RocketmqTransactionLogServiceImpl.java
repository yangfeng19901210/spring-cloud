package com.yf.ordercenter.service.impl;

import com.yf.ordercenter.model.RocketmqTransactionLog;
import com.yf.ordercenter.dao.RocketmqTransactionLogMapper;
import com.yf.ordercenter.service.RocketmqTransactionLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yf
 * @since 2022-05-13
 */
@Service
public class RocketmqTransactionLogServiceImpl extends ServiceImpl<RocketmqTransactionLogMapper, RocketmqTransactionLog> implements RocketmqTransactionLogService {

}
