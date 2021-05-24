This Project uses Spring Cloud Function + Lambda dependencies 
------------------------------------------------------------------

Create a handler class  (aws lambda has option to specify class::method if not added)

    public class LamdaEventHandler extends SpringBootRequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    }

also implement same Request and response type in the Function implemetation class


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

