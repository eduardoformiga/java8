package com.formiga.java8;

import java.util.ArrayList;
import java.util.List;

public class ParallelStreamApp{

    private List<Integer> numeros;

    private ParallelStreamApp() {
        this.numeros = new ArrayList<>();
        for (int i = 0; i < 10 ; i++) {
            numeros.add(i);
        }
    }

    private void provarStream() {
        numeros.stream().forEach(System.out::println);
    }

    private void provarParallelStream() {
        numeros.parallelStream().forEach(System.out::println);
    }


    public static void main(String[] args) {
        ParallelStreamApp parallelStreamApp = new ParallelStreamApp();
//        parallelStreamApp.provarStream();
        parallelStreamApp.provarParallelStream();
    }


}
