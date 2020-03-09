package com.twitter;

import twitter4j.Query;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

import java.io.IOException;
import java.util.List;

public class Driver {
    public static void main(String[] args) throws TwitterException, IOException {
        TwitterApiInstance twitterApiInstance = new TwitterApiInstanceImpl();
        Twitter twitter = twitterApiInstance.getTwitterInstance();
        TwitterQuery twitterQuery = new TwitterQueryImpl();
        Query hashtag = twitterQuery.getQuery(twitter);
        TwitterOperationImpl twitterOperations = new TwitterOperationImpl();
        System.out.println("------------1-----------------");
        List<Status> latestTweetList = twitterOperations.getLatestTweets(twitter, hashtag);
        latestTweetList.forEach(System.out::println);
        System.out.println("------------2-----------------");
        List<Status> oldTweetList = twitterOperations.getOldToLatestTweets(twitter, hashtag);
        oldTweetList.forEach(System.out::println);
        System.out.println("------------3-----------------");
        List<Status> reTweetOnTweetList = twitterOperations.getReTweetsHigherToLower(twitter, hashtag);
        reTweetOnTweetList.forEach(tweet -> System.out.println(tweet.getId() + " " + tweet.getRetweetCount()));
        System.out.println("------------4-----------------");
        List<Status> likesOnTweetList = twitterOperations.getLikesHigherToLower(twitter, hashtag);
        likesOnTweetList.forEach(tweet -> System.out.println(tweet.getId() + " " + tweet.getFavoriteCount()));
        System.out.println("------------5-----------------");
        List<Status> tweetsOnParticularDateList = twitterOperations.getTweetsOnParticularDate(twitter, hashtag);
        tweetsOnParticularDateList.forEach(tweet -> System.out.println(tweet.getId() + " " + tweet.getCreatedAt()));
        System.out.println("------------6-----------------");
        List<Status> likesBetweenInterval = twitterOperations.getLikesBetweenInterval(twitter, hashtag);
        likesBetweenInterval.forEach(tweet -> System.out.println(tweet.getId() + " " + tweet.getFavoriteCount()));
    }
}
