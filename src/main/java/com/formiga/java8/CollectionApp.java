package com.formiga.java8;

import java.util.ArrayList;
import java.util.List;

public class CollectionApp {

    private List<String> lista;

    private void preencheLista() {
        lista = new ArrayList<>();
        lista.add("John Snow");
        lista.add("Arya");
        lista.add("Tyrion");
        lista.add("removido");
        lista.add("Cersei");
    }


    private void usarForEach() {
        // tradicional
        /*for (String elemento : lista) {
            System.out.println(elemento);
        }*/

        //lambda
//        lista.forEach(elemento -> System.out.println(elemento));

        //method reference
        lista.forEach(System.out::println);

    }

    private void usarRemoveIf() {
        // tradicional
//        Iterator<String> it = lista.iterator();
//        while (it.hasNext()) {
//            if (it.next().equalsIgnoreCase("Arya")) {
//                it.remove();
//            }
//        }

        // lambda
        lista.removeIf(s -> s.equalsIgnoreCase("removido"));
    }

    private void usarSort(){
        // tradicional
        /* Collections.sort(lista, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o1.compareToIgnoreCase(o2);
            }
        }); */

        // lambda
        // Collections.sort(lista, (String p1, String p2) -> p1.compareToIgnoreCase(p2));

        // referencia de metodo
        lista.sort(String::compareToIgnoreCase);
    }

    public static void main(String[] args) {
        CollectionApp app = new CollectionApp();
        app.preencheLista();
        app.usarSort();
        app.usarRemoveIf();
        app.usarForEach();
    }
}
