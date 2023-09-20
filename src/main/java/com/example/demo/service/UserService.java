package com.example.demo.service;

import com.example.demo.entities.UserEntity;

import java.util.List;

public interface UserService {

    /**
     * Get all user data
     *
     * @return UserEntity
     */
    List<UserEntity> getAllUser();

    /**
     * Get user by id
     *
     * @param id user id
     * @return UserEntity
     */
    UserEntity getUserById(Long id);

    /**
     * Create new user
     *
     * @param userEntity UserEntity
     */
    void saveUser(UserEntity userEntity);

    /**
     * Delete user by id
     *
     * @param id user id
     */
    void deleteUser(Long id);
}
