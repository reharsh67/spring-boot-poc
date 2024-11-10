package com.boot.poc.APIGateway.filter;

import com.boot.poc.APIGateway.filter.validator.RouteValidator;
import com.boot.poc.APIGateway.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AuthFilter extends AbstractGatewayFilterFactory<AuthFilter.Config> {

    public AuthFilter(){
        super(Config.class);
    }

    @Autowired
    private RouteValidator validator;
    @Autowired
    private JwtUtil util;

    @Override
    public GatewayFilter apply(Config config){
        return ((exchange,chain) ->
        {

            if(validator.isSecured.test(exchange.getRequest())){
                if(!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)){
                    throw new RuntimeException("Missing authorization header");
                }

                String header  = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).toString();
                if(header != null && header.startsWith("Bearer")){
                    header  = header.substring(7);
                }
                try{
                   util.validateToken(header);
                }catch(Exception e){
                    throw new RuntimeException("Cannot validate");
                }
            }


            return chain.filter(exchange);
        });
    }

    public static class Config{

    }
}

