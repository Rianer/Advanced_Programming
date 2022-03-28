package com.company;

public class WrongFileNameException extends Exception{ //Exception for wrong file naming
    public WrongFileNameException(String str){
        super(str);
    }
}
