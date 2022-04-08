package com.example.service

import java.io.ByteArrayOutputStream
import java.io.IOException

public interface UploadStore {
    @kotlin.jvm.Throws(IOException::class)
    fun Save(userID: String, imageType: String, imageData: String): String
}