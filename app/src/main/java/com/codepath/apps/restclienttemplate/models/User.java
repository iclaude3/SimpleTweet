package com.codepath.apps.restclienttemplate.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

@Entity
@Parcel
public class User {

    @PrimaryKey(autoGenerate = true)
    Long id;

    @ColumnInfo
    public String name;
    @ColumnInfo
    public long uid;
    @ColumnInfo
    public String screenName;
    @ColumnInfo
    public String profileImageUrl;

    // empty constructor needed by the Parceler library
    public User() {

    }

    public static User fromJson(JSONObject jsonObject) throws JSONException {
        User user = new User();
        user.name = jsonObject.getString("name");
        user.uid = jsonObject.getLong("id");
        user.screenName = jsonObject.getString("screen_name");
        user.profileImageUrl = jsonObject.getString("profile_image_url");
        Log.d("image", user.profileImageUrl);

        return user;
    }
}
