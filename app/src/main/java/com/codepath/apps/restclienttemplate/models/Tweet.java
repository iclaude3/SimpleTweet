package com.codepath.apps.restclienttemplate.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import com.codepath.apps.restclienttemplate.TimeFormatter;

import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

@Entity(foreignKeys = @ForeignKey(entity=User.class, parentColumns="id", childColumns="userID"))
@Parcel
public class Tweet {
    @PrimaryKey(autoGenerate = true)
    Long id;

    @ColumnInfo
    public String body;
    @ColumnInfo
    public long uid;
    @ColumnInfo
    public String createdAt;
    @ColumnInfo(index = true)
    public Long userID;
    @Ignore
    public User user;

    // empty constructor needed by the Parceler library
    public Tweet() {

    }

    public static Tweet fromJson(JSONObject jsonObject) throws JSONException {
        Tweet tweet = new Tweet();
        tweet.body = jsonObject.getString("text");
        tweet.uid = jsonObject.getLong("id");
        tweet.createdAt = jsonObject.getString("created_at");
        tweet.user = User.fromJson(jsonObject.getJSONObject("user"));
        tweet.userID = tweet.user.id;

        return tweet;
    }

    public String getFormattedTimestamp() {
        return TimeFormatter.getTimeDifference(createdAt);
    }
}
