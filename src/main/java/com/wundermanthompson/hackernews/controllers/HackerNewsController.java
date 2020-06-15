/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wundermanthompson.hackernews.controllers;

import com.wundermanthompson.hackernews.models.Story;
import com.wundermanthompson.hackernews.models.TopComment;
import com.wundermanthompson.hackernews.services.HackerNewsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author nkeng
 */
 @CrossOrigin
@RestController
public class HackerNewsController {
    @Autowired
    private HackerNewsService service;
    
   
    @GetMapping("/top-stories")
    public List<Story>getTopStories(){
        List<Story>topStories = service.getTopStories();
    
    return topStories;
    }
    
   
    @GetMapping("/new-stories")
    public List<Story>getNewStories(){
        List<Story>newStories = service.getNewStories();
        
    return newStories;
    }
    
    @GetMapping("/ask-stories")
    public List<Story>getAskStories(){
        List<Story>askStories = service.getAskStories();
    return askStories;
    }
    @GetMapping("/show-stories")
    public List<Story>getShowStories(){
        List<Story>showStories = service.getShowStories();
    return showStories;
    }
    
    @GetMapping("/job-stories")
    public List<Story>getJobStories(){
        List<Story>jobStories = service.getJobStories();
    return jobStories;
    }
   
   
    @GetMapping("/comments")
    public List<TopComment> getComments(){
        List<TopComment> comments = service.getComments();
        
        return comments;
    }
   
    
}
