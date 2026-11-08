package com.streambridge.user_service.dto

import com.streambridge.user_service.model.UserProfile
import java.time.Instant

data class UserProfileResponse(
    val id: String?,
    val userId: String,
    val name: String,
    val avatar: String?,
    val bio: String?,
    val createdAt: Instant?,
    val updatedAt: Instant?
) {
    companion object {
        fun fromModel(model: UserProfile): UserProfileResponse {
            return UserProfileResponse(
                id = model.id,
                userId = model.userId,
                name = model.name,
                avatar = model.avatar,
                bio = model.bio,
                createdAt = model.createdAt ?: Instant.now(),
                updatedAt = model.updatedAt ?: Instant.now()
            )
        }
    }
}