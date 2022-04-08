package com.example.service

import com.example.protobuf.hello.AssetServiceGrpcKt
import com.example.protobuf.hello.UploadImageRequest
import com.example.protobuf.hello.UploadImageResponse
import java.io.IOException
import java.util.logging.Logger

class AssetService(_imageStore: DiskImageStore) : AssetServiceGrpcKt.AssetServiceCoroutineImplBase() {

    private val logger: Logger = Logger.getLogger(AssetService::class.java.name)

    private val imageStore: DiskImageStore;

    init {
        imageStore = _imageStore
    }

    override suspend fun uploadImage(request: UploadImageRequest): UploadImageResponse {
        logger.info("got a create-laptop request with ID: $request");
        try {
            val id = imageStore.Save(request.userId, request.imageType, request.file);
        } catch (e: IOException) {
            logger.info("got a create-laptop request with ID: " + e.message);
        }
        return UploadImageResponse.newBuilder().setId(request.userId).setSize(34565).build();
    }
}