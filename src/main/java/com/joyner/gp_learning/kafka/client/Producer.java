package com.joyner.gp_learning.kafka.client;

import com.joyner.gp_learning.kafka.dto.Company;
import com.joyner.gp_learning.kafka.interceptor.ProducerInterceptorPrefix;
import com.joyner.gp_learning.kafka.serializer.CompanySerializer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.internals.RecordAccumulator;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 陆清云 luqy@xiaopeng.com
 * @version 1.00.00
 *
 * <pre>
 * 修改记录
 * 修改后版本: 修改人： 修改日期: 修改内容:
 * </pre>
 */
public class Producer {

    public static Properties initConfig() {
        Properties props = new Properties();
        props.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.setProperty(ProducerConfig.CLIENT_ID_CONFIG, "producer.client.id.demo");
        props.setProperty(ProducerConfig.INTERCEPTOR_CLASSES_CONFIG, ProducerInterceptorPrefix.class.getName());
        return props;
    }

    public static void main(String[] args) {
        Properties props = initConfig();
        KafkaProducer<String, String> producer = new KafkaProducer<>(props);
        producer.send(new ProducerRecord<>("quickstart-events", "company"));
        producer.close();

    }

    public static void customSend() {
        Properties props = initConfig();
        KafkaProducer<String, Company> producer = new KafkaProducer<>(props);
        Company company = new Company();
        company.setName("test company");
        company.setAddress("beijing");
        producer.send(new ProducerRecord<>("quickstart-events", company));
        producer.close();
    }
}
