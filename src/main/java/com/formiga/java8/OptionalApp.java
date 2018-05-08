package com.formiga.java8;

import java.util.Optional;

public class OptionalApp {

    private void provar(String valor) {
        try {
            Optional op = Optional.empty();
            op.get();
        }catch (Exception e){
            System.out.println("Não tem elemento");
        }
    }

    private void orElse(String valor) {
        Optional<String> op = Optional.ofNullable(valor);
        String x = op.orElse("Valor default");
        System.out.println(x);
    }

    private void orElseThrow(String valor) {
        Optional<String> op = Optional.ofNullable(valor);
        op.orElseThrow(NumberFormatException::new);
    }

    private void isPresent(String valor) {
        Optional<String> op = Optional.ofNullable(valor);
        System.out.println(op.isPresent());
    }

    public static void main(String[] args) {
        OptionalApp optionalApp = new OptionalApp();
        optionalApp.provar(null);
//        optionalApp.orElse("Tyrion");
//        optionalApp.orElseThrow("Tyrion");
//        optionalApp.isPresent("Tyrion");
    }

}
