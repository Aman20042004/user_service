package com.streambridge.user_service.model

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import java.time.Instant

@Document(collection = "user_profiles")
data class UserProfile(
    @Id
    val id: String? = null,

    @Indexed(unique = true)
    val userId: String, // Reference to Auth Service identity

    val name: String,
    val avatar: String? = null,
    val bio: String? = null,

    @CreatedDate
    val createdAt: Instant = Instant.now(),

    @LastModifiedDate
    val updatedAt: Instant = Instant.now()
)