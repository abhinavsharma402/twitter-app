package com.twitter;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class is used to perform various operations on the tweets of hastag.
 */
public class TwitterOperationImpl implements TwitterOperation {
    /**
     * getLatestTweets method used to get latest to older tweet with limit.
     *
     * @param twitter receive twitter instance.
     * @param hashTag hashtag of query.
     * @return list of status.
     * @throws TwitterException throws twitter exception.
     */
    public List<Status> getLatestTweets(Twitter twitter, Query hashTag) throws TwitterException {
        QueryResult query = twitter.search(hashTag);
        return query.getTweets().stream()
                .limit(5).collect(Collectors.toList());
    }

    /**
     * getOldToLatestTweets method used to get older to latest tweet with limit.
     *
     * @param twitter receive twitter instance.
     * @param hashTag hashtag of query.
     * @return list of status.
     * @throws TwitterException throws twitter exception.
     */

    public List<Status> getOldToLatestTweets(Twitter twitter, Query hashTag) throws TwitterException {
        QueryResult query = twitter.search(hashTag);
        return query.getTweets().stream().limit(5)
                .sorted(Comparator.comparing(Status::getCreatedAt)
                        .reversed()).collect(Collectors.toList());
    }

    /**
     * getReTweetsHigherToLower method used to get higher to lower reTweet on tweet.
     *
     * @param twitter receive twitter instance.
     * @param hashTag hashtag of query.
     * @return list of status.
     * @throws TwitterException throws twitter exception.
     */

    public List<Status> getReTweetsHigherToLower(Twitter twitter, Query hashTag) throws TwitterException {
        QueryResult query = twitter.search(hashTag);
        return query.getTweets().stream()
                .sorted(Comparator.comparing(Status::getRetweetCount).reversed())
                .collect(Collectors.toList());
    }

    /**
     * getLikesHigherToLower method used to get higher to lower likes on tweet.
     *
     * @param twitter receive twitter instance.
     * @param hashTag hashtag of query.
     * @return list of status.
     * @throws TwitterException throws twitter exception.
     */
    public List<Status> getLikesHigherToLower(Twitter twitter, Query hashTag) throws TwitterException {
        QueryResult query = twitter.search(hashTag);
        return query.getTweets().stream()
                .sorted(Comparator.comparing(Status::getFavoriteCount).reversed())
                .collect(Collectors.toList());
    }

    /**
     * getTweetsOnParticularDate method used to get tweet on particular date.
     *
     * @param twitter receive twitter instance.
     * @param hashTag hashtag of query.
     * @return list of status.
     * @throws TwitterException throws twitter exception.
     */
    public List<Status> getTweetsOnParticularDate(Twitter twitter, Query hashTag) throws TwitterException {
        hashTag.setSince("2020-03-07");
        hashTag.setUntil("2020-03-08");
        QueryResult query = twitter.search(hashTag);
        return query.getTweets();
    }

    /**
     * getLikesBetweenInterval method used to get likes of tweet between interval.
     *
     * @param twitter receive twitter instance.
     * @param hashTag hashtag of query.
     * @return list of status.
     * @throws TwitterException throws twitter exception.
     */
    public List<Status> getLikesBetweenInterval(Twitter twitter, Query hashTag) throws TwitterException {
        LocalDateTime current = LocalDateTime.now();
        LocalDateTime timeBefore = current.minusHours(15);
        QueryResult query = twitter.search(hashTag);
        return query.getTweets().stream()
                .filter(tweet -> tweet.getCreatedAt()
                        .toInstant().atZone(ZoneId.of("Asia/Kolkata")).toLocalDateTime().isBefore(current)
                        && tweet.getCreatedAt()
                        .toInstant().atZone(ZoneId.of("Asia/Kolkata")).toLocalDateTime().isAfter(timeBefore))
                .collect(Collectors.toList());

    }

}

