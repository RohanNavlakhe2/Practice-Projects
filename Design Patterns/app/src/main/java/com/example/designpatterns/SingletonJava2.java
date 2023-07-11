package com.example.designpatterns;

public class SingletonJava2 {

    private static final SingletonJava2 INSTANCE = new SingletonJava2();

    private SingletonJava2(){}

    public static SingletonJava2 getInstance(){
        return INSTANCE;
    }

    public void doSomething(){}
}
