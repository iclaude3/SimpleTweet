package com.codepath.apps.restclienttemplate.models;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM User where id = :id")
    public User getById(int id);

    @Query("SELECT * FROM User ORDER BY ID DESC LIMIT 300")
    List<User> recentItems();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public Long[] insertUser(User... users);

    @Delete
    public void deleteUser(User user);
}
