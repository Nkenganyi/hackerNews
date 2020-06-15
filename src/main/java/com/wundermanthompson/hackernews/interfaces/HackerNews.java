/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wundermanthompson.hackernews.interfaces;

import com.wundermanthompson.hackernews.models.Comment;
import com.wundermanthompson.hackernews.models.Story;
import java.util.List;
import java.util.SortedSet;

/**
 *
 * @author nkeng
 */
public interface HackerNews {
    
    
    List<Story>getTopStories();
    
    SortedSet<Comment>getCommentsById(int storyId);
    
}
