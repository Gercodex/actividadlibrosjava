package com.cursoalura.actividadlibros.principal;

import com.cursoalura.actividadlibros.modulos.*;
import org.springframework.boot.CommandLineRunner;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Principal implements CommandLineRunner {

    private ConectionApi conectar = new ConectionApi();
    private String consultaJson;
    Scanner scanner = new Scanner(System.in);
    private String entrada;
    @Override
    public void run(String... args){
        System.out.println("Escribe el título del libro o autor");
        entrada = scanner.nextLine();
        try {
            consultaJson = conectar.consultar("https://gutendex.com/books/?search="+entrada.replace(" ", "+"));
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        Conversor conversor = new Conversor();
        System.out.println(consultaJson);
        Consulta consulta = conversor.convertir(consultaJson, Consulta.class);
        List<Resultados> resultados = consulta.resultados().stream()
                .filter(r -> r.descargas() > 1000)
                .distinct()
                .limit(10).collect(Collectors.toList());
        System.out.println("Lista de libros reelevantes por autor o información del título "+entrada+" es: ");
        resultados.forEach(System.out::println);

        DoubleSummaryStatistics est =  resultados.stream().collect(Collectors.summarizingDouble(Resultados::descargas));

        System.out.println("Libros reelevantes; promedio descargas: "+ est.getAverage() +" Más baja: " + est.getMin() +" Más alta: " + est.getMax());

        System.out.println("Lista de Títulos: ");
        List<String> titulos = resultados.stream().map(e -> e.titulo() + "\n").collect(Collectors.toList());
        System.out.println(titulos);

    }
}
