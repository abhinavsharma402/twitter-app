package com.twitter;

import twitter4j.Query;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

import java.util.List;

public interface TwitterOperation {
    List<Status> getLatestTweets(Twitter twitter, Query hashTag) throws TwitterException;

    List<Status> getOldToLatestTweets(Twitter twitter, Query hashTag) throws TwitterException;

    List<Status> getReTweetsHigherToLower(Twitter twitter, Query hashTag) throws TwitterException;

    List<Status> getLikesHigherToLower(Twitter twitter, Query hashTag) throws TwitterException;

    List<Status> getTweetsOnParticularDate(Twitter twitter, Query hashTag) throws TwitterException;

    List<Status> getLikesBetweenInterval(Twitter twitter, Query hashTag) throws TwitterException;
}
