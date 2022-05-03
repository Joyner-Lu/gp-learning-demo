package com.joyner.gp_learning.rocket_mq.base.producer;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

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
public class OnewayProducer {

    public static void main(String[] args) throws Exception {
        DefaultMQProducer mqProducer = null;
        try {
            mqProducer = new DefaultMQProducer("please_rename_unique_group_name");
            mqProducer.setNamesrvAddr("localhost:9876");
            mqProducer.start();
            mqProducer.setSendMsgTimeout(10000);
            for (int i = 0; i < 5; i++) {
                Message message = new Message("TopicTest", "TagA", ("one way msg" + i).getBytes(RemotingHelper.DEFAULT_CHARSET));

                mqProducer.sendOneway(message);
                Thread.sleep(100);
            }

        } finally {
            mqProducer.shutdown();
        }

    }
}
