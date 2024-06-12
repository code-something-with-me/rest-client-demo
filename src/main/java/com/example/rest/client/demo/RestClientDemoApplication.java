package com.example.rest.client.demo;

import com.example.rest.client.demo.user.UserHttpClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpClientAdapter;
import org.springframework.web.service.invoker.HttpExchangeAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@SpringBootApplication
public class RestClientDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestClientDemoApplication.class, args);
    }

    @Bean
    public UserHttpClient userHttpClient() {
        RestClient client = RestClient.builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .defaultHeader("Accept", "application/json")
                .defaultHeader("Content-Type", "application/json")
                .build();
        var fac = HttpServiceProxyFactory.builderFor(RestClientAdapter.create(client))
                .build();
        return fac.createClient(UserHttpClient.class);
    }

}
