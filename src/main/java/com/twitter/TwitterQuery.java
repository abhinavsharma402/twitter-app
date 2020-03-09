package com.twitter;

import twitter4j.Query;
import twitter4j.Twitter;

public interface TwitterQuery {
    Query getQuery(Twitter twitter);
}

