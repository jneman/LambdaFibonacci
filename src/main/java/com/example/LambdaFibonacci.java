package com.example;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.HashMap;
import java.util.Map;

public class LambdaFibonacci implements RequestHandler<Map<String, Object>, String> {

    @Override
    public String handleRequest(Map<String, Object> input, Context context) {
        int n = 10; // default value
        if(input != null && input.containsKey("n")) {
            n = (Integer) input.get("n");
        }
        
        if (n < 1 || n >= 48) {
        	return("Your input must be a positive number less than 48.");
        }
        StringBuilder result = new StringBuilder();

        int a = 0, b = 1;
        for(int i = 0; i < n; i++) {
            result.append(a).append(" ");
            int temp = a + b;
            a = b;
            b = temp;
        }
        return result.toString().trim();
    }
    
    // ---- Main method for local testing ----
    public static void main(String[] args) {
        LambdaFibonacci lambda = new LambdaFibonacci();
        // Simulate JSON input
        Map<String, Object>map = new HashMap<>();
        map.put("n", 47);
        String output = lambda.handleRequest(map, null);
        System.out.println("Fibonacci sequence: " + output);
    }
}