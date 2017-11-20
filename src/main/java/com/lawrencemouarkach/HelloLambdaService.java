package com.lawrencemouarkach;

import com.amazonaws.services.lambda.invoke.LambdaFunction;

public interface HelloLambdaService {

    @LambdaFunction(functionName = "Hello")
    String requestHello(String request);

    @LambdaFunction(functionName = "HelloResponse")
    HelloResponse requestHelloResponse(HelloRequest request);
}
