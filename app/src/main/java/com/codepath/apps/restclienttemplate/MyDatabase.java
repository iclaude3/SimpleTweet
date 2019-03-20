package com.codepath.apps.restclienttemplate;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.codepath.apps.restclienttemplate.models.Tweet;
import com.codepath.apps.restclienttemplate.models.User;

@Database(entities={User.class, Tweet.class}, version=1)
public abstract class MyDatabase extends RoomDatabase {
//    // Declare data access object as abstract
//    public abstract UserDao userDao();
//    public abstract TweetDao tweetDao();
//
//    // Database name to be used
//    public static final String NAME = "TweetDataBase";
}
