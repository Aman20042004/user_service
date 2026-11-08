package com.streambridge.user_service.exception

class DuplicateUserProfileException(userId: String) :
    RuntimeException("Profile for userId $userId already exists")

class UserProfileNotFoundException(userId: String) :
    RuntimeException("Profile not found for userId: $userId")