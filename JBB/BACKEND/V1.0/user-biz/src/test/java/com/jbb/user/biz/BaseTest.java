/**
 * Copyright (C) 2015 Baidu, Inc. All Rights Reserved.
 */
package com.jbb.user.biz;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * BaseTest
 * 
 * @author yangxiangqian
 *classpath:config/spring/appcontext-dao.xml
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/config/spring/appcontext-dao.xml","/config/spring/spring-mybatis.xml" })
public abstract class BaseTest {

}
