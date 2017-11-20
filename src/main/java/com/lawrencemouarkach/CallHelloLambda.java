package com.lawrencemouarkach;

import com.amazonaws.services.lambda.AWSLambdaClientBuilder;
import com.amazonaws.services.lambda.invoke.LambdaInvokerFactory;

public class CallHelloLambda {

    private static final HelloLambdaService HELLO_LAMBDA_SERVICE = LambdaInvokerFactory.builder()
            .lambdaClient(AWSLambdaClientBuilder.standard().withRegion("eu-west-2").build())
            .build(HelloLambdaService.class);

    private static String retriveHelloName() {
        return HELLO_LAMBDA_SERVICE.requestHello("Fabio");
    }

    public static void main(String[] args) {
        System.out.println(retriveHelloName());
    }
}
