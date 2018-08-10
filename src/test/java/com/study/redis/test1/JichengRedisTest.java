/**
 * <p>Title: JichengRedisTest.java</p>   
 * <p>Description: </p>  
 * <p>Copyright: Copyright (c) 2018</p>   
 * @author 林猛 
 * @date 2018年8月9日  
 * @version 1.0   
*/  
package com.study.redis.test1;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author linmeng
 *
 */
public class JichengRedisTest {
	@Resource
	private RedisTemplate<String, Object>redisTemplate;
	public static void main(String[] args) {
		
	}
}
