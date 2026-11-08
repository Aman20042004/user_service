package com.streambridge.user_service.repository

import com.streambridge.user_service.model.UserProfile
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface UserProfileRepository : MongoRepository<UserProfile, String> {
    fun findByUserId(userId: String): UserProfile?
    fun existsByUserId(userId: String): Boolean
}