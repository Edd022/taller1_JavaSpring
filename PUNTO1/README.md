Punto 2 del Taller:
OBJETIVO: 
Experimento educativo para comprender el ciclo de vida, creación y configuración de beans en Spring Framework.
Proposito
Comparar y contrastar diferentes métodos de creación de beans, analizando su ciclo de vida y comportamiento con la anotación @Lazy.

Patrones de Comportamiento:
@Component: Spring controla completamente la creación de este tipo

@Bean: El desarrollador tiene control total sobre la instanciación

@Lazy: Posterga la creación hasta el primer uso, usado para gestionar mejor los recursos.


Aspecto	        @Component	        @Bean
Control	        Spring	            Desarrollador
Flexibilidad	Limitada	        Máxima
Casos de uso	Clases propias	    Clases de terceros, configuración compleja

Usos:

Usar @Component para clases propias, no se necesitan especificaciones adicionales.

Usar @Bean para integración con librerías externas

Implementar @Lazy para optimización de recursos. @Lazy hace que la optimizacion de los recursos sea efectiva ya que este tipo de recursos solo se traeran cuando sean solicitados. Por motivos de rapidez de carga y ahorro de recursos van a utilizarse de este modo.

BEAN AUTOMÁTICO:
@Component
Spring lo crea automáticamente
Se detecta con @Component

BEAN MANUAL:
@Bean
Se define con @Bean en @Configuration
RESUMEN:

Automático = @Component → Spring crea

Manual = @Bean → Developer lo crea

📋 RESUMEN DE TODOS LOS CASOS
Caso	Bean Manual	 Bean Automático	Comportamiento
    1	@Lazy ✅	    @Lazy ✅	        Ninguno al inicio, ambos al usar
    2	@Lazy ❌	    @Lazy ❌	        Ambos al inicio
    3	@Lazy ✅	    @Lazy ❌	        Solo automático al inicio
    4	@Lazy ❌	    @Lazy ✅	        Solo manual al inicio
