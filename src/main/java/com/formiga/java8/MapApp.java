package com.formiga.java8;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MapApp {
    private Map<Integer, String> map;

    private MapApp() {
        map = new HashMap<>();
        map.put(1, "John");
        map.put(2, "Snow");
        map.put(3, "Stark");
    }

    private void imprimirJava7() {
        for (Map.Entry<Integer, String> elemento : map.entrySet()) {
            System.out.println("Chave: " + elemento.getKey() + " Valor: " + elemento.getValue());
        }
    }

    private void imprimirJava8() {
//        map.forEach((k,v) -> System.out.println("Chave: "+ k+" Valor: "+v));
        map.entrySet().stream().forEach(System.out::println);
    }

    private void inserirSeAusente() {
        map.putIfAbsent(2, "Lannister");
//        map.putIfAbsent(4,"Targerian");
    }

    private void operarSePresente() {
        map.computeIfPresent(3, (k, v) -> "Chave: " + k + " Valor: " + v);
    }

    private void getOrDefault() {
        System.out.println(map.getOrDefault(5, "5 valor default"));
    }

    private void recoletar(){
        Map<Integer, String> mapRecoletado =
                map.entrySet().stream().filter(e -> e.getValue().contains("Sus"))
                .collect(Collectors.toMap(p-> p.getKey(), p->p.getValue()));
        mapRecoletado.forEach((k, v) -> System.out.println("Chave: " + k + " Valor: " + v));
    }

    public static void main(String[] args) {
        MapApp mapApp = new MapApp();
//        mapApp.imprimirJava7();
//        mapApp.inserirSeAusente();
//        mapApp.operarSePresente();
        mapApp.getOrDefault();
        mapApp.imprimirJava8();
    }

}
