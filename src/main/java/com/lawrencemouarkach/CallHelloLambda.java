package com.lawrencemouarkach;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.lambda.AWSLambdaClientBuilder;
import com.amazonaws.services.lambda.invoke.LambdaInvokerFactory;

public class CallHelloLambda {

    private static final String NAME = "Fabio";
    private static final int AGE = 26;

    private static final HelloLambdaService HELLO_LAMBDA_SERVICE = LambdaInvokerFactory.builder()
            .lambdaClient(AWSLambdaClientBuilder.standard()
                    .withRegion("eu-west-2")
                    .withCredentials(new ProfileCredentialsProvider("adminuser"))
                    .build())
            .build(HelloLambdaService.class);

    private static String retriveHelloName() {
        return HELLO_LAMBDA_SERVICE.requestHello(NAME);
    }

    private static HelloResponse retrievePersonalResponse() {
        return HELLO_LAMBDA_SERVICE.requestHelloResponse(new HelloRequest(NAME, AGE));
    }

    public static void main(String[] args) {
        System.out.println(retriveHelloName());
        System.out.println("................");
        System.out.println(retrievePersonalResponse());
    }
}
