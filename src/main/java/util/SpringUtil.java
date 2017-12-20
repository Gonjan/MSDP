/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Locale;

/**
 *
 * @author Gonjan
 * @version $Id: SpringUtil.java, v 0.1 2017年11月24日 10:08 Gonjan Exp $
 */
public class SpringUtil {

    private static String springXml = "spring/spring-*.xml";

    public static ApplicationContext initSpringContainer() {
        ApplicationContext context = new ClassPathXmlApplicationContext(springXml);
        if(context == null) {
            System.err.println("Spring容器初始化失败");
        } else {
            System.out.println("Spring容器初始化成功，加载的bean:");
            String[] beanNames = context.getBeanDefinitionNames();
            //for(String beanName : beanNames) {
            //    System.out.println(beanName);
            //}
        }
        return context;
    }

    public static <T> T getBean(ApplicationContext context, Class<T> clazz) {
        String beanName = clazz.getSimpleName();
        beanName = beanName.substring(0,1).toLowerCase(Locale.ENGLISH) + beanName.substring(1);
        T t = context.getBean(beanName, clazz);
        return t;
    }

    public static void main(String[] args) {
        //打印classpath
        String classpath = SpringUtil.class.getClassLoader().getResource("").getPath();
        System.out.println(classpath);
        initSpringContainer();
    }
}