package com.acmspring.co.punto2;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private final List<String> items;
    private String usuario;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public void agregarProducto(String producto) {
        items.add(producto);
    }

    public List<String> getItems() {
        return items;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Carrito de " + usuario + ": " + items;
    }
}