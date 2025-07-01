package com.compasssecurity;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

public class Main {
    public static void main(String[] args) {

        String myJWT = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJuYW1lIjoiaGFja2VyIiwicm9sZSI6InVzZXIiLCJpYXQiOjE3NTEzNzQ1ODF9.7SkOXvjN4OMWbC6gwTs7_lOpTXcW7B2yM1RYgBO-O3E";
        DecodedJWT decodedJWT;

        try {
            Algorithm algorithm = Algorithm.HMAC256("secret");
            JWTVerifier verifier = JWT.require(algorithm)
                    // reusable verifier instance
                    .build();

            decodedJWT = verifier.verify(myJWT);
            System.out.println("Token verified successfully!");
        } catch (JWTVerificationException exception){
            System.out.println("Something went wrong: " + exception.getMessage());
        }
    }
}