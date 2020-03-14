package com.joyner.gp_learning.spring_related.spring_ioc;

import com.joyner.gp_learning.spring_related.mvcframework.demo.service.impl.DemoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
@Configuration
public class BeanConfiguration {

    @Bean
    public DemoService getDemoService() {
        return new DemoService();
    }
}
