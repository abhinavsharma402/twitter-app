package com.twitter;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import java.io.IOException;

/**
 * This class is used to create twitter instance.
 */
public class TwitterApiInstanceImpl implements TwitterApiInstance {
    /**
     * getTwitterInstance method create intstance of twitter.
     *
     * @return twitter instance.
     */
    @Override
    public Twitter getTwitterInstance() throws IOException {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        Config config = ConfigFactory.load();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(config.getString("oauth.consumerKey"))
                .setOAuthConsumerSecret(config.getString("oauth.consumerSecret"))
                .setOAuthAccessToken(config.getString("oauth.accessToken"))
                .setOAuthAccessTokenSecret(config.getString("oauth.accessTokenSecret"));
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();
        return twitter;
    }
}
