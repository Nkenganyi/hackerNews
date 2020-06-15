/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wundermanthompson.hackernews.services;

import com.wundermanthompson.hackernews.interfaces.CacheService;
//import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * @author nkeng
 */
@Service
public class CacheServiceImplementation implements CacheService {

   
	//RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
        
    
    @Override
    public void set(String key, String value) {
        //redisTemplate.opsForValue().set(key, value, 10, TimeUnit.MINUTES);
    }

    @Override
    public Object get(String key) {
       try {
			//return redisTemplate.opsForValue().get(key);
		} catch (Exception e) {
			
		}
		return null;
	}
    }
    
    
    

