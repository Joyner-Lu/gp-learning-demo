package com.joyner.gp_learning.rocket_mq.base.consumer;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;

import java.util.List;

/**
 * <pre>
 *
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
public class ClusterBalancedModelConsumer {

    public static void main(String[] args) throws Exception {
        DefaultMQPushConsumer defaultMQPushConsumer = new DefaultMQPushConsumer("group1");
        defaultMQPushConsumer.setNamesrvAddr("localhost:9876");
        defaultMQPushConsumer.subscribe("TopicTest", "TagA");

        defaultMQPushConsumer.setMessageModel(MessageModel.CLUSTERING);
        defaultMQPushConsumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                /*System.out.printf("%s Receive New Messages: %s %n",
                        Thread.currentThread().getName(), msgs);*/
                for (int i = 0; i < msgs.size(); i++) {
                    MessageExt messageExt = msgs.get(i);
                    System.out.println("消息：" + new String(messageExt.getBody()));
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });

        defaultMQPushConsumer.start();
        System.out.println("consumer started...");

    }
}
