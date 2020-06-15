/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wundermanthompson.hackernews.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author nkeng
 */
public class TopComment {
    
    private String title;
    private String text;
    private String by;
    private int age;
    @JsonIgnore
    private int totalComments;
    

    public TopComment() {
       
    }

    public TopComment(String title, String text, String by, int age, int totalComments) {
        this.title = title;
        this.text = text;
        this.by = by;
        this.age = age;
        this.totalComments = totalComments;
    }

    
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getBy() {
        return by;
    }

    public void setBy(String by) {
        this.by = by;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getTotalComments() {
        return totalComments;
    }

    public void setTotalComments(int totalComments) {
        this.totalComments = totalComments;
    }

    @Override
    public String toString() {
        return "TopComment{" + "title=" + title + ", text=" + text + ", by=" + by + ", age=" + age + ", totalComments=" + totalComments + '}';
    }

    
}
