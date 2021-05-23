package com.mishi.springcloud;

import com.mishi.model.Order;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@SpringBootApplication
public class SpringCloudDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudDemoApplication.class, args);
    }

    /**
     * This is an example for a get endpoint with pathparam
     * This bean endpoint can be be invoked by
     * http://localhost:8080/hello/{inputString}
     *
     * Checkout the alternative way by creating class by implementing
     * functional interface in com.mishi.controller.Helloo.java
     * http://localhost:8080/helloo/{inputString}
     *
     * @return
     */
    @Bean
    public Function<String,String> hello(){
        return (input) -> input;
    }

    /**
     * This is an example for a get endpoint with path param
     * String input and Json Order data as response
     * http://localhost:8080/getorder/{orderId}
     * @return
     */
    @Bean
    public Function<String, Order> getorder(){
        return (orderId) -> new Order(orderId);
    }

    /**
     * accept input ,no response
     * @return
     */
    @Bean
    public Consumer<String> sendmessage(){
        return (msg) -> {
            //Do something here with the input data
            System.out.println(msg);
        };
    }

    /**
     * http://localhost:8080/orders
     * No input , This endpoint will provide list of orders json response
     * @return
     */
    @Bean
    public Supplier< List<Order> > orders(){
        return ()-> {
            List<Order> orders = new ArrayList<Order>();
            orders.add(new Order("111"));
            orders.add(new Order("222"));
            return orders;
        };
    }
}
