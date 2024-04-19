package com.test.technicaltest.controller;

import com.test.technicaltest.model.Fibonacci;
import com.test.technicaltest.model.NonPalindrome;
import com.test.technicaltest.response.ResponseHandler;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {

    @PostMapping("/api/fibonacci")
    public ResponseEntity<Object> getSumFibonacci(@Valid @RequestBody Fibonacci Input, Errors errors) {
        Map<String, Object> response = new HashMap<>();

        if (errors.hasErrors()){
            for(ObjectError error : errors.getAllErrors()){
                if((error.getCode()).equals("Digits")){
                    response.put("n","Nilai tidak boleh desimal");
                }else {
                    response.put("n",error.getDefaultMessage());
                }

            }
            return ResponseHandler.response("Error",HttpStatus.BAD_REQUEST,response);
        }

        response.put("Hasil",fibonacci(Input.getN()));

        return ResponseHandler.response("Success",HttpStatus.OK,response);
    }

    private int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        int a = 0;
        int b = 1;
        int c = 0;

        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }

        return c;
    }

    @PostMapping("/api/non-palindrome")
    public ResponseEntity<Object> longestNonPalindrome(@Valid @RequestBody NonPalindrome s, Errors errors) {
        Map<String, Object> response = new HashMap<>();
        if (errors.hasErrors()){
            for(ObjectError error : errors.getAllErrors()){
                response.put(error.getCode(),error.getDefaultMessage());
            }
            return ResponseHandler.response("Error",HttpStatus.BAD_REQUEST,response);
        }

        response.put("Hasil",longestNonPalindromeSubstring(s));
        return ResponseHandler.response("Success",HttpStatus.OK,response);
    }

    private String longestNonPalindromeSubstring(NonPalindrome input) {
        String s = input.getS();
        int n = s.length();
        String nonPalindrome = "";

        for (int length = n; length > 0; length--) {
            for (int start = 0; start + length <= n; start++) {
                String tempString = s.substring(start, start + length);
                if (!isPalindrome(tempString)) {
                    if (tempString.length() > nonPalindrome.length()) {
                        nonPalindrome = tempString;
                    }
                }
            }
        }
        return nonPalindrome;
    }

    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
