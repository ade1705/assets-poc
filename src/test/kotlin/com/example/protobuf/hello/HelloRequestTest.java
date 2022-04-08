package com.example.protobuf.hello;

import junit.framework.TestCase;

public class HelloRequestTest extends TestCase {

    public void tryTest() {
        HelloReply.Builder builder = HelloReply.newBuilder();
        HelloReply reply = builder.setMessage("sdjksd").build();

        assertEquals(reply.getMessage(), "sdjksd");
    }
}