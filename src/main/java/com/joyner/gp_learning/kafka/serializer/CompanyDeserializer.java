package com.joyner.gp_learning.kafka.serializer;

import com.joyner.gp_learning.kafka.dto.Company;
import org.apache.kafka.common.serialization.Deserializer;

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
public class CompanyDeserializer implements Deserializer<Company> {

    @Override
    public Company deserialize(String topic, byte[] data) {
        if (data == null || data.length == 0) {
            return null;
        }
        String string = new String(data);
        String[] split = string.split("-");
        String name = split[0];
        String address = split[1];
        Company company = new Company();
        company.setName("null".equals(name) ? null : name);
        company.setAddress("null".equals(address) ? null : address);
        return company;
    }
}
