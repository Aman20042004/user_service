package com.streambridge.user_service.controller

import com.streambridge.user_service.dto.CreateUserProfileRequest
import com.streambridge.user_service.dto.UpdateUserProfileRequest
import com.streambridge.user_service.dto.UserProfileResponse
import com.streambridge.user_service.service.UserProfileService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/users")
class UserProfileController(private val userProfileService: UserProfileService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createProfile(@Valid @RequestBody request: CreateUserProfileRequest): UserProfileResponse {
        return userProfileService.createProfile(request)
    }

    @GetMapping("/{userId}")
    fun getProfile(@PathVariable userId: String): UserProfileResponse {
        return userProfileService.getProfileByUserId(userId)
    }

    @PutMapping("/{userId}")
    fun updateProfile(
        @PathVariable userId: String,
        @Valid @RequestBody request: UpdateUserProfileRequest
    ): UserProfileResponse {
        return userProfileService.updateProfile(userId, request)
    }

  /*  @GetMapping("/health")
    fun healthCheck(): Map<String, String> {
        return mapOf("status" to "UP", "service" to "user-service")
    }*/
  @GetMapping("/health")
  fun healthCheck(): Map<String, String> {
      println("🔥 USER HEALTH REQUEST RECEIVED")

      return mapOf(
          "status" to "UP",
          "service" to "user-service"
      )
  }
}