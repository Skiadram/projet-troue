package com.example.demo.exception;

public class RessourceNotFoundException extends Exception{
    public RessourceNotFoundException(){
        super();
    }

    public RessourceNotFoundException(String s){
        super(s);
    }
}
