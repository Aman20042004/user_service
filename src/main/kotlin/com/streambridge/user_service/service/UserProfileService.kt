package com.streambridge.user_service.service

import com.streambridge.user_service.dto.CreateUserProfileRequest
import com.streambridge.user_service.dto.UpdateUserProfileRequest
import com.streambridge.user_service.dto.UserProfileResponse
import com.streambridge.user_service.exception.DuplicateUserProfileException
import com.streambridge.user_service.exception.UserProfileNotFoundException
import com.streambridge.user_service.model.UserProfile
import com.streambridge.user_service.repository.UserProfileRepository
import org.springframework.stereotype.Service
import java.time.Instant

@Service
class UserProfileService(private val repository: UserProfileRepository) {

    fun createProfile(request: CreateUserProfileRequest): UserProfileResponse {
        if (repository.existsByUserId(request.userId)) {
            throw DuplicateUserProfileException(request.userId)
        }

        val profile = UserProfile(
            userId = request.userId,
            name = request.name,
            avatar = request.avatar,
            bio = request.bio
        )

        val savedProfile = repository.save(profile)
        return UserProfileResponse.fromModel(savedProfile)
    }

    fun getProfileByUserId(userId: String): UserProfileResponse {
        val profile = repository.findByUserId(userId)
            ?: throw UserProfileNotFoundException(userId)
        return UserProfileResponse.fromModel(profile)
    }

    fun updateProfile(userId: String, request: UpdateUserProfileRequest): UserProfileResponse {
        val existingProfile = repository.findByUserId(userId)
            ?: throw UserProfileNotFoundException(userId)

        val updatedProfile = existingProfile.copy(
            name = request.name,
            avatar = request.avatar,
            bio = request.bio,
            updatedAt = Instant.now()
        )

        val savedProfile = repository.save(updatedProfile)
        return UserProfileResponse.fromModel(savedProfile)
    }
}