package com.formiga.java8;

import rx.Observable;

import java.util.ArrayList;
import java.util.List;

public class RxApp {
    private List<Integer> lista1;
    private List<Integer> lista2;

    public RxApp() {
        lista1 = new ArrayList<>();
        lista2 = new ArrayList<>();

        this.preencherListas();
    }

    private void preencherListas() {
        for (int i =0; i < 10 ; i++){
            lista1.add(i);
            lista2.add(i);
        }
    }

    private void buscar(){
        Observable<Integer> observable1 = Observable.from(lista1);
        Observable<Integer> observable2 = Observable.from(lista2);

        /*Observable.merge(observable1,observable2).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer numero) {
                if(numero ==1){
                    System.out.println(numero);
                }
            }
        });*/

        Observable.merge(observable1,observable2).filter(x->x==1).subscribe(System.out::println);
        Observable.merge(observable1,observable2).subscribe(numero -> {
            if(numero ==1){
                System.out.println("obs "+numero);
            }
        });
    }

    public static void main(String[] args) {
        /*ArrayList<String> lista = new ArrayList<>();
        lista.add("Arya");
        lista.add("John");
        lista.add("Hodor");

        Observable<String> observable = Observable.from(lista);
        observable.subscribe(new Action1<String>(){

            @Override
            public void call(String s) {
                System.out.println(s);
            }
        });*/

        RxApp rxApp = new RxApp();
        rxApp.buscar();


    }
}
