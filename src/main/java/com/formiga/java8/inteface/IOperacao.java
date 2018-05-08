package com.formiga.java8.inteface;

public interface IOperacao {

    double  media(double n1, double n2);

    default void testeDefault(){
        System.out.println("Implementação dentro da interface");
    }
}
