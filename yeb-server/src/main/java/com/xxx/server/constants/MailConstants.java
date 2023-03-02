package com.xxx.server.constants;

/**
 * @BelongsProject: yeb
 * @BelongsPackage: com.xxx.server.constants
 * @Author: zuoyu
 * @CreateTime: 2023-03-02  18:38
 * @Description: TODO
 * @Version: 1.0
 *
 * 消息状态
 * 生产端可靠性投递,保障生产端消息成功发送，并且不重复
 * 1.当生产端首次发送消息到MQ中时，将消息持久化到Redis中
 */
public class MailConstants {
    // 消息投递中
    public static final Integer DELIVERING = 0;

    // 消息投递成功
    public static final Integer SUCCESS = 1;

    // 消息投递失败
    public static final Integer FAILURE = 2;

    // 最大重试次数
    public static final Integer MAX_TRY_COUNT = 3;

    // 消息超时时间
    public static final Integer MSG_TIMEOUT = 1;

    //队列
    public static final String MAIL_QUEUE_NAME="mail.queue";

    // 交换机
    public static final String MAIL_EXCHANGE_NAME = "mail.exchange";

    // 路由key
    public static final String MAIL_ROUTING_KEY_NAME = "mail.routing.key";
}
