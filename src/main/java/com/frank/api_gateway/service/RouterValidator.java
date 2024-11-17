package com.frank.api_gateway.service;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;

@Service
public class RouterValidator {
    static final List<String> openEndpoints = List.of(
            "/v1/auth"
    );

    public Predicate<ServerHttpRequest> isSecure = serverHttpRequest -> 
            openEndpoints.stream().noneMatch(uri -> serverHttpRequest.getURI().getPath().contains((uri)));
}