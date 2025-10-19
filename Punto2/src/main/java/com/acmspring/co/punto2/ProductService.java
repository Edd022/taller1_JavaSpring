package com.acmspring.co.punto2;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    //Carro compartido
    private final ShoppingCart carritoCompartido;

    //Carro individual con ObjectProvider
    private final ObjectProvider<ShoppingCart> proveedorDeCarritos;

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

    //Solución, proveedor de carritos ya es implementado con un ObjectProvider
    public void comprarConCarritoIndividual(String usuario, String producto) {
        ShoppingCart carritoNuevo = proveedorDeCarritos.getObject();
        carritoNuevo.setUsuario(usuario);
        carritoNuevo.agregarProducto(producto);
        System.out.println(carritoNuevo);
    }
}