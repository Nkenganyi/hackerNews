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
public class Comment {

    private String by;
    private int id;
    private int parent;
    private int[] kids;
    private String text;
    private int time;

    public Comment() {
    }

    public Comment(String by, int id, int parent, int[] kids, String text, int time) {
        this.by = by;
        this.id = id;
        this.parent = parent;
        this.kids = kids;
        this.text = text;
        this.time = time;
    }
    

    public String getBy() {
        return by;
    }

    public void setBy(String by) {
        this.by = by;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public int[] getKids() {
        return kids;
    }

    public void setKids(int[] kids) {
        this.kids = kids;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Comment{" + "by=" + by + ", id=" + id + ", parent=" + parent +
                ", kids=" + kids + ", text=" + text + ", time=" + time + '}';
    }
    
    

}
