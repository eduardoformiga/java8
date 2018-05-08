package com.formiga.java8;

import com.formiga.java8.inteface.IOperacao;
import com.formiga.java8.inteface.IPessoa;
import com.formiga.java8.model.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class LambdaApp {

    public static void main(String[] args) {
        LambdaApp lambdaApp = new LambdaApp();

        //ordena lista com nomes e imprime
        lambdaApp.ordenar();

        // testa operacao de media e operador default e imprime
        lambdaApp.testeOperacao();

        // cria pessoa e imprime
        lambdaApp.criarPessoa();
    }

    private void criarPessoa() {
        //tradicional
        /*IPessoa iPessoa = new IPessoa() {
            @Override
            public Pessoa criar(Long id, String nome) {
                return new Pessoa(id, nome);
            }
        };*/

        // java 1.8 lambda
        // IPessoa iPessoa = (id, nome) -> new Pessoa(id, nome);

        // referencia de metodo
        IPessoa iPessoa = Pessoa::new;

        Pessoa pessoa = iPessoa.criar(1L,"Eduardo");

        // impressao
        System.out.println(pessoa);

    }

    private void ordenar(){
        List<String> lista = new ArrayList<String>();
        lista.add("Cersei");
        lista.add("Arya");
        lista.add("John");

        // tradicional
        /* Collections.sort(lista, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o1.compareToIgnoreCase(o2);
            }
        }); */

        // Java 1.8 - utilizando lambda
        // Collections.sort(lista, (String p1, String p2) -> p1.compareToIgnoreCase(p2));

        // referencia de metodo
        lista.sort(String::compareToIgnoreCase);

        // impressao da lista
        //tradicional
        /*for (String elemento : lista) {
            System.out.println(elemento);
        }*/

        // java 1.8 lambda
//        lista.forEach(x -> System.out.println(x));

        // method reference
        lista.forEach(System.out::println);

    }

    private void testeOperacao(){
        // tradicional
//        IOperacao iOperacao = new IOperacao() {
//            @Override
//            public double media(double n1, double n2) {
//                return (n1+n2)/2;
//            }
//        };

        // java 1.8 lambda
        IOperacao iOperacao = (n1, n2) -> (n1+n2)/2;

        // impressao da media
        System.out.println(iOperacao.media(2,3));

        // teste default na interface (implementacao na interface)
        iOperacao.testeDefault();
    }

}
