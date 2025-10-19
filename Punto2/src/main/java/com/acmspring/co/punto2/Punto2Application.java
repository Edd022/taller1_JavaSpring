package com.acmspring.co.punto2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Punto2Application implements CommandLineRunner {

    private final ProductService tienda;

    public Punto2Application(ProductService tienda) {
        this.tienda = tienda;
    }

    public static void main(String[] args) {
        SpringApplication.run(Punto2Application.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("\n=== PROBLEMA: Carrito Compartido ===");
        tienda.comprarConCarritoCompartido("Juan", "Laptop");
        System.out.println(">>> Juan agregó una laptop");
        tienda.comprarConCarritoCompartido("María", "Teléfono");
        System.out.println(">>> María agregó un teléfono");
        tienda.comprarConCarritoCompartido("Juan", "Limosina");
        System.out.println(">>> Juan agregó una limosina");
        
        System.out.println("\n=== SOLUCIÓN: Carritos Individuales ===");
        tienda.comprarConCarritoIndividual("Juan", "Laptop");
        System.out.println(">>> Juan agregó una laptop");
        //Aquí también es un carro aparte
        tienda.comprarConCarritoIndividual("Juan", "Limosina");
        System.out.println(">>> Juan agregó una limosina");
        tienda.comprarConCarritoIndividual("María", "Teléfono");
        System.out.println(">>> María agregó un teléfono");
    }
}