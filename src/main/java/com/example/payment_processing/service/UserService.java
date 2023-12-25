package com.example.payment_processing.service;


import com.example.payment_processing.entity.User;

import java.io.UnsupportedEncodingException;

public interface UserService {

    User registerUser(int user_id, String user_name, String address, Double latitude, Double longitude) throws UnsupportedEncodingException;

    void enrollForOfflinePayment(int user_id);
        String generateUserSecret();
    public User approveUser(int user_id);
}

