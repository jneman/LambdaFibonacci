package com.example;

import java.util.HashMap;
import java.util.Map;

public class TestLambdaFibonacci {
    public static void main(String[] args) {
        LambdaFibonacci lambda = new LambdaFibonacci();
        Map<String, Object>map = new HashMap<>();
        map.put("n", 11);
        System.out.println(lambda.handleRequest(map, null));
    }
}