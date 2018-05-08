package com.formiga.java8;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.FileReader;

public class NashApp {

    private ScriptEngineManager m;
    private ScriptEngine e;
    private Invocable invocador;

    private NashApp() {
        m = new ScriptEngineManager();
        e = m.getEngineByName("nashorn");
        invocador = (Invocable) e;
    }

    private void chamarFuncoes() throws Exception {
//        e.eval("print('JS via Java')");
        e.eval(new FileReader("src/main/java/com/formiga/java8/nashorn/arquivo.js"));

        String resposta = (String) invocador.invokeFunction("calcular", "2", "3");
        System.out.println(resposta);

        double resposta2 = (double) invocador.invokeFunction("calcular", 2, 3);
        System.out.println(resposta2);
    }

    private void implementarInterface() throws Exception {
        e.eval(new FileReader("src/main/java/com/formiga/java8/nashorn/arquivo.js"));
        Object implementacao = e.get("hiloImpl");
        Runnable r = invocador.getInterface(implementacao, Runnable.class);

        Thread thread1 = new Thread(r);
        thread1.start();

        Thread thread2 = new Thread(r);
        thread2.start();
    }

    public static void main(String[] args) {
        NashApp nashApp = new NashApp();
        try {
//            nashApp.chamarFuncoes();
            nashApp.implementarInterface();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}



