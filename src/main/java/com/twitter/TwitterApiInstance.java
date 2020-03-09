package com.twitter;

import twitter4j.Twitter;

import java.io.FileNotFoundException;
import java.io.IOException;

interface TwitterApiInstance {
    public Twitter getTwitterInstance() throws IOException;
}
