# Punto 2
En este md se responderá el punto número 2 del taller de Java Spring de ACM.
## Problema
El problema es que hay un solo carrito para todos los usuarios, entonces, si un usuario x, ingresa un producto x1, y si un usuario y ingresa un producto y1, pues 'x' y 'y' verán los dos productos, aunque el uno no agregó el otro, es decir, verán un carrito con 2 procutos, x1 y y1.

En el enunciado del taller nos piden solucionar el problema con diferentes opciones, las cuales son 
1. **ObjectProvider**
2. **Inyectando el
ApplicationContext** desde el **singleton** y con **applicationContext.getBean()** o
**@Lookup.**

En la solución presentada, se resolvió con un **ObjectProvider** implementado en el ProductService.
´´´
    Epa
´´´
