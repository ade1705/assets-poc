package com.example.service

class ImageMeta(_userID: String, _type: String, _path: String) {
    private val userID: String

    private val type: String

    private val path: String

    init {
        userID = _userID
        type = _type
        path = _path
    }

    fun getUserID(): String {
        return userID;
    }

    fun getType(): String {
        return type;
    }

    fun getPath(): String {
        return path;
    }
}
