package com.example.service

import com.example.database.DatabaseManager
import java.io.ByteArrayOutputStream
import java.io.FileOutputStream
import java.util.*
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ConcurrentMap


class DiskImageStore(_imageFolder: String) : UploadStore {
    private val imageFolder: String
    private val data: ConcurrentMap<String, ImageMeta>

    init {
        imageFolder = _imageFolder
        data = ConcurrentHashMap(0)
    }

    override fun Save(userID: String, imageType: String, imageData: String): String {
        val dbManager = DatabaseManager();
        val imageID : String = UUID.randomUUID().toString()
        val imagePath : String = String.format("%s/%s.%s", imageFolder, imageID, imageType)

        val imageBytes = Base64.getDecoder().decode(imageData)
        val fileOutputStream = FileOutputStream(imagePath)
        fileOutputStream.write(imageBytes)
        fileOutputStream.close();

        val imageMeta = ImageMeta(userID, imageType, imagePath)
        data[imageID] = imageMeta;
        dbManager.insert(userID, imagePath);

        return imageID;
    }
}