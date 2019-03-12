package com.codepath.apps.restclienttemplate.models;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface TweetDao {
    @Query("SELECT * FROM Tweet where id = :id")
    public Tweet getById(int id);

    @Query("SELECT * FROM Tweet ORDER BY ID DESC LIMIT 300")
    List<Tweet> recentItems();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public Long[] insertTweet(Tweet... tweets);

    @Delete
    public void deleteTweet(Tweet tweet);
}
