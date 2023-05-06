package com.yupi.yupao.constant;

/**
 * rabbitMQ常量
 * @author LYC
 */
public class MqConstants {
    /**
     * 交换机器
     */
    private static final String USER_EXCHANGE="user.topic";
    /**
     * 监听新增和修改的队列
     */
    private static final String USER_INSERT_QUEUE="user.insert.queue";
    /**
     *监听和删除队列
     */
    private static final String USER_DELETE_QUEUE="user.delete.queue";
    /**
     *新增或者修改RoutingKey
     */
    private static final String USER_INSERT_KEY="user.insert";
    /**
     * 删除的RoutingKey
     */
    private static final String USER_DElETE_KEY="user.delete";
}
