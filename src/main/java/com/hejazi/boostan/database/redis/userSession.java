package com.hejazi.boostan.database.redis;

import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("userSession")
public class userSession implements Serializable{
    private String id;

    public userSession(String id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
