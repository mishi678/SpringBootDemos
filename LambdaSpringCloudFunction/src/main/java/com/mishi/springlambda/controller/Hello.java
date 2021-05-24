package com.mishi.springlambda.controller;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import org.springframework.stereotype.Component;

import java.util.function.Function;
@Component
public class Hello implements Function<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {
    @Override
    public APIGatewayProxyResponseEvent apply(APIGatewayProxyRequestEvent request)
    {
        APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent();
        response.setBody("Hello "+request.getBody());
        response.setStatusCode(200);
        return response;
    }
}
