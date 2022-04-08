package com.example

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.example.plugins.*
import com.example.protobuf.hello.GreeterGrpcKt
import com.example.protobuf.hello.HelloRequest
import com.example.protobuf.hello.helloReply
import com.example.service.AssetService
import com.example.service.DiskImageStore
import io.grpc.netty.NettyServerBuilder

class HelloWorldServer(val port: Int) {
    val server = NettyServerBuilder
        .forPort(port)
        .addService(HelloWorldService())
        .addService(AssetService(DiskImageStore("img")))
        .build()

    fun start() {
        server.start()
        println("Server started, listening on $port")
        Runtime.getRuntime().addShutdownHook(
            Thread {
                println("*** shutting down gRPC server since JVM is shutting down")
                stop()
                println("*** server shut down")
            }
        )
    }

    private fun stop() {
        server.shutdown()
    }

    fun blockUntilShutdown() {
        server.awaitTermination()
    }

    private class HelloWorldService : GreeterGrpcKt.GreeterCoroutineImplBase() {
        override suspend fun sayHello(request: HelloRequest) = helloReply {
            message = "Hello ${request.name}"
        }
    }
}

fun main() {
    val port = System.getenv("PORT")?.toInt() ?: 50051
    val server = HelloWorldServer(port)
    server.start()
    server.blockUntilShutdown()
}
