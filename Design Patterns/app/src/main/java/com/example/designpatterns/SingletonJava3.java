package com.example.designpatterns;

public final class SingletonJava3 {

    public static final SingletonJava3 INSTANCE;

    private SingletonJava3(){}

    static {
        INSTANCE = new SingletonJava3();
    }

    public void doSomething(){}


}
