/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wundermanthompson.hackernews.interfaces;

/**
 *
 * @author nkeng
 */
public interface CacheService {
    void set(String key, String value);
    Object get(String key);
}
