package com.formiga.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class HighApp {

    private Function<String, String> converterMaiusculas = x -> x.toUpperCase();
    private Function<String, String> converterMinusculas = x -> x.toLowerCase();

    private void imprimir(Function<String, String> function, String valor) {
        System.out.println(function.apply(valor));
    }

    private Function<String, String> mostrar(String mensagem) {
        return (String x) -> mensagem + x;
    }

    private void filtrar(List<String> lista, Consumer<String> consumidor, int longitude, String stringFiltro) {
//        lista.stream().filter(estabelecerLogicaFiltro(longitude)).forEach(consumidor);
        lista.stream().filter(estabelecerLogicaFiltro(stringFiltro)).forEach(consumidor);
    }

    private Predicate<String> estabelecerLogicaFiltro(int longitude) {
        return texto -> texto.length() < longitude;
    }

    private Predicate<String> estabelecerLogicaFiltro(String stringFiltro) {
        return texto -> texto.contains(stringFiltro);
    }

    public static void main(String[] args) {
        HighApp highApp = new HighApp();
        highApp.imprimir(highApp.converterMaiusculas, "arya stark");
        highApp.imprimir(highApp.converterMinusculas, "ARYA STARK");

        String resposta = highApp.mostrar("Olá, ").apply("John Snow");
        System.out.println("resposta = " + resposta);

        ArrayList<String> lista = new ArrayList<>();
        lista.add("Arya");
        lista.add("John");
        lista.add("Cersei");

//        highApp.filtrar(lista, System.out::println, 5, null);
        highApp.filtrar(lista, System.out::println, 0, "John");
    }
}
