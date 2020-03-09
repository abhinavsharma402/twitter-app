package com.twitter;

import twitter4j.Query;
import twitter4j.Twitter;

/**
 * This class is used to get query of hashtag.
 */

public class TwitterQueryImpl implements TwitterQuery {
    /**
     * getQuery method used to get query on the basis of hashtag
     * @param twitter receive twitter instance.
     * @return hashtag of query.
     */
    @Override
    public Query getQuery(Twitter twitter) {
        Query hashTag = new Query("#ram");
        return hashTag;
    }
}
