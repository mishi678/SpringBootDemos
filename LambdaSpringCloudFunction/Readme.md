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

Don't forget to add plugin to build light weight jar for lambda

    <plugin>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-maven-plugin</artifactId>
        <dependencies>
            <dependency>
                <groupId>org.springframework.boot.experimental</groupId>
                <artifactId>spring-boot-thin-layout</artifactId>
                <version>1.0.10.RELEASE</version>
            </dependency>
        </dependencies>
    </plugin>
    <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-shade-plugin</artifactId>
        <configuration>
            <createDependencyReducedPom>false</createDependencyReducedPom>
            <shadedArtifactAttached>false</shadedArtifactAttached>
            <shadedClassifierName>aws</shadedClassifierName>
        </configuration>
    </plugin>
