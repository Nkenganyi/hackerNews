/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wundermanthompson.hackernews.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.wundermanthompson.hackernews.models.Comment;
import com.wundermanthompson.hackernews.models.Story;
import com.wundermanthompson.hackernews.models.TopComment;
import com.wundermanthompson.hackernews.models.User;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import java.util.List;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

/**
 *
 * @author nkeng
 */
@Service
public class HackerNewsService {

    private static ObjectMapper objectMapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    public static ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    public List<Story> getTopStories() {
        List<Integer> storyIds = topStoryIds();
        List<Story> topStoriesList = new ArrayList<>();

        for (int i = 0; i < storyIds.size(); i++) {
            Story story = getStory(storyIds.get(i));
            topStoriesList.add(story);
        }

        return topStoriesList;

    }
    
    
    public List<Story> getNewStories(){
        List<Integer>newStoryIds = newStoryIds();
        List<Story> newStoriesList = new ArrayList<>();
        for (Integer newStoryId : newStoryIds) {
            Story newStory = getStory(newStoryId);
            newStoriesList.add(newStory);
        }
            
         return newStoriesList;
    
    }
    
    public List<Story> getAskStories(){
        List<Integer>askStoryIds = askStories();
        List<Story> askStoriesList = new ArrayList<>();
        for (Integer newStoryId : askStoryIds) {
            Story newStory = getStory(newStoryId);
            askStoriesList.add(newStory);
        }
            
         return askStoriesList;
    
    }
    
    public List<Story> getShowStories(){
        List<Integer>showStoryIds = showStories();
        List<Story> showStoriesList = new ArrayList<>();
        for (Integer newStoryId : showStoryIds) {
            Story newStory = getStory(newStoryId);
            showStoriesList.add(newStory);
        }
            
         return showStoriesList;
    
    }
    
    public List<Story> getJobStories(){
        List<Integer>jobStoryIds = jobStories();
        List<Story> jobStoriesList = new ArrayList<>();
        for (Integer newStoryId : jobStoryIds) {
            Story newStory = getStory(newStoryId);
            jobStoriesList.add(newStory);
        }
            
         return jobStoriesList;
    
    }
    
    

    public List<TopComment> getComments() {
        List<TopComment> topCommentSet = new ArrayList<>();
        List<Story> stories = getTopStories();
        for (Story s : stories) {
            Story story = s;
            if (story != null) {

                int[] comments = story.getKids();
                if (comments != null) {
                    for (int commentId : comments) {

                        Comment comment = getComment(commentId);
                        if (comment != null) {

                            int commentCount = 1 + getCommentCount(comment);

                            TopComment topComment = new TopComment(story.getTitle(), comment.getText(), comment.getBy(),
                                    getUserAgeByName(comment.getBy()), commentCount);

                            topCommentSet.add(topComment);
                        }
                    }
                }

            }
        }
        topCommentSet = topCommentSet.stream().limit(20).collect(Collectors.toList());
        return topCommentSet;
    }

    private Story getStory(int storyId) {
        Story story = null;

        try {
            story = objectMapper.readValue(new URL("https://hacker-news.firebaseio.com/v0/item/"
                    + storyId + ".json"), Story.class);
        } catch (IOException ex) {
            Logger.getLogger(HackerNewsService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return story;
    }

    private Comment getComment(int commentId) {
        Comment comment = null;

        try {
            comment = objectMapper.readValue(new URL("https://hacker-news.firebaseio.com/v0/item/"
                    + commentId + ".json"), Comment.class);

        } catch (IOException ex) {
            Logger.getLogger(HackerNewsService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return comment;
    }

    private int getCommentCount(Comment comment) {
        if (comment == null) {
            return 0;
        }
        int count = 0;

        if (comment.getKids() != null) {

            count += comment.getKids().length;

            for (int commentId : comment.getKids()) {

                Comment kidComment = null;
                try {
                    kidComment = objectMapper.readValue(new URL("https://hacker-news.firebaseio.com/v0/item/" + commentId + ".json"), Comment.class);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(HackerNewsService.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(HackerNewsService.class.getName()).log(Level.SEVERE, null, ex);
                }
                count += getCommentCount(kidComment);

            }

        }
        return count;
    }

    private int getUserAgeByName(String name) {
        User user = null;

        try {
            user = objectMapper.readValue(new URL("https://hacker-news.firebaseio.com/v0/user" + name + ".json"), User.class);
        } catch (MalformedURLException ex) {
            Logger.getLogger(HackerNewsService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HackerNewsService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    private List<Integer> topStoryIds() {
        List<Integer> topStoryIds = null;
        URL url;

        try {
            url = new URL("https://hacker-news.firebaseio.com/v0/topstories.json");
            topStoryIds = objectMapper.readValue(url, new TypeReference<List<Integer>>() {
            });
            topStoryIds = topStoryIds.stream().limit(10).collect(Collectors.toList());
        } catch (MalformedURLException ex) {
            Logger.getLogger(HackerNewsService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HackerNewsService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return topStoryIds;
    }

    private List<Integer> newStoryIds() {
        List<Integer> newStoryIds = null;
        URL url;

        try {
            url = new URL("https://hacker-news.firebaseio.com/v0/newstories.json");
            newStoryIds = objectMapper.readValue(url, new TypeReference<List<Integer>>() {
            });
            newStoryIds = newStoryIds.stream().limit(10).collect(Collectors.toList());
        } catch (MalformedURLException ex) {
            Logger.getLogger(HackerNewsService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HackerNewsService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return newStoryIds;
    }
    
    private List<Integer>askStories(){
     List<Integer> askStoryIds = null;
        URL url;

        try {
            url = new URL("https://hacker-news.firebaseio.com/v0/askstories.json");
            askStoryIds = objectMapper.readValue(url, new TypeReference<List<Integer>>() {
            });
            askStoryIds = askStoryIds.stream().limit(10).collect(Collectors.toList());
        } catch (MalformedURLException ex) {
            Logger.getLogger(HackerNewsService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HackerNewsService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return askStoryIds;
    
    }
    
    private List<Integer>jobStories(){
        List<Integer> jobStoryIds = null;
        URL url;

        try {
            url = new URL("https://hacker-news.firebaseio.com/v0/jobstories.json");
            jobStoryIds = objectMapper.readValue(url, new TypeReference<List<Integer>>() {
            });
            jobStoryIds = jobStoryIds.stream().limit(10).collect(Collectors.toList());
        } catch (MalformedURLException ex) {
            Logger.getLogger(HackerNewsService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HackerNewsService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return jobStoryIds;
    }
    
    private List<Integer> showStories(){
    List<Integer> showStoryIds = null;
        URL url;

        try {
            url = new URL("https://hacker-news.firebaseio.com/v0/showstories.json");
            showStoryIds = objectMapper.readValue(url, new TypeReference<List<Integer>>() {
            });
            showStoryIds = showStoryIds.stream().limit(10).collect(Collectors.toList());
        } catch (MalformedURLException ex) {
            Logger.getLogger(HackerNewsService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HackerNewsService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return showStoryIds;
    
    }
    
//    public List<Story>getPastStories(){
//        
//    
//    }
}
