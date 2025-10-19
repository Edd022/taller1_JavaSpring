package com.acmspring.co.punto2;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class ProductService {

    //Carro compartido
    private final ShoppingCart carritoCompartido;

    //Carro individual con ObjectProvider
    private final ObjectProvider<ShoppingCart> proveedorDeCarritos;
    //Mapa para mantener los carritos por usuario
    private final Map<String, ShoppingCart> carritosUsuarios = new HashMap<>();

    //Constructor
    public ProductService(ShoppingCart carritoCompartido, 
                        ObjectProvider<ShoppingCart> proveedorDeCarritos) {
        this.carritoCompartido = carritoCompartido;
        this.proveedorDeCarritos = proveedorDeCarritos;
    }

    //Problema a resolver
    public void comprarConCarritoCompartido(String usuario, String producto) {
        carritoCompartido.setUsuario(usuario);
        carritoCompartido.agregarProducto(producto);
        System.out.println(carritoCompartido);
    }

    //Solución con persistencia usando Map
    public void comprarConCarritoIndividual(String usuario, String producto) {
        ShoppingCart carritoUsuario = carritosUsuarios.computeIfAbsent(usuario, k -> {
            ShoppingCart nuevoCarrito = proveedorDeCarritos.getObject();
            nuevoCarrito.setUsuario(usuario);
            return nuevoCarrito;
        });
        
        carritoUsuario.agregarProducto(producto);
        System.out.println(carritoUsuario);
    }
}