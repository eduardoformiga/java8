package com.formiga.java8;

import java.util.ArrayList;
import java.util.List;

public class StreamApp {

    private List<String> lista;
    private List<String> numeros;

    private StreamApp() {
        lista = new ArrayList<>();
        lista.add("John Snow");
        lista.add("Arya");
        lista.add("Tyrion");
        lista.add("Cersei");

        numeros = new ArrayList<>();
        numeros.add("1");
        numeros.add("2");
        numeros.add("3");
    }

    private void filtrar() {
        lista.stream().filter(x -> x.startsWith("A")).forEach(System.out::println);
    }

    private void ordenar() {
        lista.stream().sorted().forEach(System.out::println);
//        lista.stream().sorted((x,y) -> y.compareToIgnoreCase(x)).forEach(System.out::println);
    }

    private void transformar() {
//        lista.stream().map(String::toUpperCase).forEach(System.out::println);
        numeros.stream().map(x -> Integer.parseInt(x) + 1).forEach(System.out::println);
    }

    private void limitar() {
        lista.stream().limit(2).forEach(System.out::println);
    }

    private void contar() {
        System.out.println(lista.stream().count());
    }


    public static void main(String[] args) {
        StreamApp streamApp = new StreamApp();
        streamApp.filtrar();
        streamApp.ordenar();
        streamApp.transformar();
        streamApp.limitar();
        streamApp.contar();
    }
}

