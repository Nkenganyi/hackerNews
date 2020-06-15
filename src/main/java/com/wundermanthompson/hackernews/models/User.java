/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wundermanthompson.hackernews.models;

/**
 *
 * @author nkeng
 */

public class User {
    
    private String id;
    private int delay;
    private int created;
    private int karma;
    private String about;
    private int [] submitted;
    
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public int getCreated() {
        return created;
    }

    public void setCreated(int created) {
        this.created = created;
    }

    public int getKarma() {
        return karma;
    }

    public void setKarma(int karma) {
        this.karma = karma;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public int[] getSubmitted() {
        return submitted;
    }

    public void setSubmitted(int[] submitted) {
        this.submitted = submitted;
    }
    
    
    
    
}
