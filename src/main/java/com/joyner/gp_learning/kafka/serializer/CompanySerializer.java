package com.joyner.gp_learning.kafka.serializer;

import com.joyner.gp_learning.kafka.dto.Company;
import org.apache.kafka.common.serialization.Serializer;

import java.nio.charset.StandardCharsets;

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
public class CompanySerializer implements Serializer<Company> {

    @Override
    public byte[] serialize(String topic, Company data) {
        byte[] empty = new byte[0];
        if (data == null) {
            return empty;
        }
        String name = data.getName();
        String address = data.getAddress();
        String finalData = name + "-" + address;
        return finalData.getBytes(StandardCharsets.UTF_8);
    }


    public static void main(String[] args) {
        CompanySerializer companySerializer = new CompanySerializer();
        Company company = new Company();
        byte[] tests = companySerializer.serialize("test", company);
        String s = new String(tests);
        String[] split = s.split("-");
        System.out.println();
    }
}
