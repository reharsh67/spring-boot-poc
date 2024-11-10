package com.boot.poc.APIGateway.filter.validator;


import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.*;
import java.util.function.Predicate;

@Component
public class RouteValidator {

    public static final List<String> openEndpoints = List.of(
            "/auth/token",
            "/auth/register",
            "/auth/validate"
    );

    public Predicate<ServerHttpRequest> isSecured = request ->
            openEndpoints.stream().noneMatch(uri ->
                    request.getURI().getPath().contains(uri));
}
