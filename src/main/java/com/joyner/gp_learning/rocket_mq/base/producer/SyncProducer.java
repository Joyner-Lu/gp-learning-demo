package com.joyner.gp_learning.rocket_mq.base.producer;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.io.UnsupportedEncodingException;

/**
 * <pre>
 * 发送同步消息
 * </pre>
 *
 * @author 陆清云 luqingyun@foresee.cn
 * @version 1.00.00
 *
 * <pre>
 * 修改记录
 * 修改后版本: 修改人： 修改日期: 修改内容:
 * </pre>
 */
public class SyncProducer {
    public static void main(String[] args) throws Exception {
        DefaultMQProducer defaultMQProducer = null;
        try {
            /**
             * 1.创建消息生产者producer，并制定生产者组名
             * 2.指定Nameserver地址
             * 3.启动producer
             * 4.创建消息对象，指定主题Topic、Tag和消息体
             * 5.发送消息
             * 6.关闭生产者producer
             */
            defaultMQProducer = new DefaultMQProducer("please_rename_unique_group_name");
            defaultMQProducer.setNamesrvAddr("localhost:9876");
            defaultMQProducer.start();

            for (int i = 0; i < 10; i++) {
                Message message = new Message("TopicTest", "TagA", ("Hello RocketMQ" + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
                SendResult send = defaultMQProducer.send(message, 10000);
                System.out.println(send);
                Thread.sleep(100);

            }
            System.in.read();

        }finally {
            defaultMQProducer.shutdown();
        }

    }

}
