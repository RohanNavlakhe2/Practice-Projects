package com.example.designpatterns;

public class SingletonJava {

    private static SingletonJava instance;

    private SingletonJava(){}

    public static SingletonJava getInstance(){
        if(instance == null)
            instance = new SingletonJava();
        return instance;
    }

    public void doSomething(){}

}
