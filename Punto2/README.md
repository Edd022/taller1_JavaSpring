# Punto 2
En este documento se responderá el punto número 2 del taller de Java Spring de ACM.

## Problema
El problema consiste en que hay un solo carrito para todos los usuarios. Cuando un usuario x ingresa un producto x1, y luego un usuario y ingresa un producto y1, ambos usuarios verán los dos productos, aunque cada uno solo haya agregado uno. Es decir, verán un carrito con 2 productos, x1 y y1.

En el enunciado del taller nos piden solucionar el problema con diferentes opciones:
1. **ObjectProvider**
2. **Inyectando el ApplicationContext** desde el **singleton** y con **applicationContext.getBean()** o **@Lookup**

En la solución presentada, se resolvió utilizando un **ObjectProvider** implementado en el ProductService:

```java
//Carrito problema
private final ShoppingCart carritoCompartido;    

//Carro individual con ObjectProvider
private final ObjectProvider<ShoppingCart> proveedorDeCarritos;
```

## Implementación y Resultados
Para mantener los productos de cada usuario, implementamos un Map que almacena los carritos:

```java
private final Map<String, ShoppingCart> carritosUsuarios = new HashMap<>();
```

Al ejecutar el código con el carrito sin ObjectProvider, este es el resultado:

```shell
=== PROBLEMA: Carrito Compartido ===
Carrito de Juan: [Laptop]
>>> Juan agregó una laptop
Carrito de María: [Laptop, Teléfono]
>>> María agregó un teléfono
Carrito de Juan: [Laptop, Teléfono, Limosina]
>>> Juan agregó una limosina
```

Como se observa, en el carrito de __María__ aparece la _Laptop_ de __Juan__, y en el carrito de __Juan__ aparece el _Teléfono_ de __María__.

Al utilizar el carrito con ObjectProvider y el Map, obtenemos el siguiente resultado:

```shell
=== SOLUCIÓN: Carritos Individuales ===
Carrito de Juan: [Laptop]
>>> Juan agregó una laptop
Carrito de Juan: [Laptop, Limosina]
>>> Juan agregó una limosina
Carrito de María: [Teléfono]
>>> María agregó un teléfono
```

De esta manera, el carrito de __Juan__ mantiene sus dos artículos juntos, y __María__ tiene su propio carrito independiente.

## Configuración del Bean
Todo lo anterior funciona gracias al _SCOPE_PROTOTYPE_ configurado en AppConfig:

```java
@Configuration
public class AppConfig {
    @Bean
    @Scope(SCOPE_PROTOTYPE)
    public ShoppingCart shoppingCart() {
        return new ShoppingCart();
    }
}
```

Sin embargo, si cambiamos a _SCOPE_SINGLETON_:

```java
@Configuration
public class AppConfig {
    @Bean
    @Scope(SCOPE_SINGLETON)
    public ShoppingCart shoppingCart() {
        return new ShoppingCart();
    }
}
```

El resultado vuelve a ser problemático:

```shell
=== PROBLEMA: Carrito Compartido ===
Carrito de Juan: [Laptop]
>>> Juan agregó una laptop
Carrito de María: [Laptop, Teléfono]
>>> María agregó un teléfono
Carrito de Juan: [Laptop, Teléfono, Limosina]
>>> Juan agregó una limosina

=== SOLUCIÓN: Carritos Individuales ===
Carrito de Juan: [Laptop, Teléfono, Limosina, Laptop]
>>> Juan agregó una laptop
Carrito de Juan: [Laptop, Teléfono, Limosina, Laptop, Limosina]
>>> Juan agregó una limosina
Carrito de María: [Laptop, Teléfono, Limosina, Laptop, Limosina, Teléfono]
>>> María agregó un teléfono
```

## Por qué ocurre esto
Con __SCOPE_SINGLETON__, Spring crea una única instancia del objeto y la reutiliza siempre, por eso vemos que el carrito acumula todos los productos. Cuando llamamos a `proveedorDeCarritos.getObject()`, en lugar de darnos un carrito nuevo, nos devuelve la misma instancia.

Por esta razón es necesario usar __SCOPE_PROTOTYPE__, ya que cada llamada a `getObject()` crea una nueva instancia de `ShoppingCart`, permitiendo que cada usuario tenga su propio carrito independiente y que sus productos persistan correctamente.
## Conclusión
El ejercicio demuestra la importancia del manejo adecuado del scope en Spring. Utilizar `SCOPE_PROTOTYPE` junto con `ObjectProvider` nos permite crear una solución donde cada usuario tiene su propio carrito de compras, manteniendo la independencia de datos entre usuarios.
