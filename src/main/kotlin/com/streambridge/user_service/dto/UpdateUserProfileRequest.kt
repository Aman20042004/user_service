package com.streambridge.user_service.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class UpdateUserProfileRequest(
    @field:NotBlank(message = "name is required")
    @field:Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    val name: String,

    val avatar: String? = null,

    @field:Size(max = 500, message = "Bio cannot exceed 500 characters")
    val bio: String? = null
)