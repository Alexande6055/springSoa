# API REST con Spring Boot

Este proyecto es una API REST creada con Spring Boot, diseñada como una herramienta de aprendizaje para trabajar con entidades, DTOs (Data Transfer Objects) y consultas personalizadas utilizando Query con INNER JOIN.

## Características principales

1. **Entidades**:

   - Cliente
   - DetalleVenta
   - Producto
   - Venta

2. **Uso de DTOs**:

   - Los DTOs se utilizan para estructurar y simplificar los datos que se envían o reciben de las consultas.

3. **Consultas personalizadas**:

   - Las consultas SQL personalizadas con INNER JOIN se implementan para obtener datos complejos que mapean directamente a los DTOs.

4. **Lombok**:

   - Se utiliza Lombok para generar automáticamente los métodos por defecto, como getters, setters, constructores y métodos adicionales como `toString` y `equals`.

5. **ORM**:

   - Se usa JPA/Hibernate como ORM para mapear las entidades a la base de datos de manera eficiente.

## Tecnologías utilizadas

- **Java**
- **Spring Boot** (framework principal)
- **JPA/Hibernate** (mapeo de entidades y persistencia de datos)
- **Lombok** (simplificación del código boilerplate)
- **MySQL** (base de datos utilizada para desarrollo y pruebas)
- **Maven** (gestión de dependencias)

## Instalación y configuración

1. Clona este repositorio:

   ```bash
   git clone https://github.com/Alexande6055/springSoa.git
   ```

2. Abre el proyecto en tu IDE favorito (por ejemplo, IntelliJ IDEA o Eclipse).

3. Asegúrate de tener configurado un entorno JDK compatible (Java 17 o superior recomendado).

4. Configura la conexión a la base de datos MySQL en el archivo `application.yml`:

   ```properties
   Spring:
  datasource:
    url: jdbc:mysql://localhost/tu_base_de_datos
    username: tu_usuario
    password: tu_contraseña
   ```

5. Ejecuta el proyecto:

   ```bash
   mvn spring-boot:run
   ```

6. Accede a la aplicación en `http://localhost:8080` (puedes cambiar el puerto en el archivo `application.properties` si es necesario).

## Endpoints disponibles

| Método HTTP | Endpoint                    | Descripción                                                  |
|-------------|-----------------------------|--------------------------------------------------------------|
| GET         | `/venta/totalVentas`        | Obtiene el total acumulado de las ventas realizadas.         |
| GET         | `/venta/categoria={categoria}` | Devuelve las ventas filtradas por una categoría específica.   |
| GET         | `/venta/detalleVenta={id_venta}` | Obtiene los detalles de una venta específica.                |
| GET         | `/venta/clienteMasComprado` | Lista al cliente con mayores compras.                       |

## Consultas personalizadas implementadas

1. **Reporte de ventas totales**:

   ```java
   @Query("SELECT SUM(dv.subTotal) AS total FROM DetalleVenta dv")
   Object reporteVentasTotales();
   ```

   **Descripción**: Calcula el total de todas las ventas registradas.

2. **Reporte de lista de detalle de venta por ID**:

   ```java
   @Query("SELECT new com.gestionPlus.PracticaTienda.DTO.DetalleVentaDTO(dv.subTotal, dv.cantidad, p.precio, p.nombre, p.descripcion) " +
          "FROM DetalleVenta dv INNER JOIN Producto p ON dv.idProducto.id_producto = p.id_producto " +
          "WHERE dv.idVenta.id_venta = :id_venta")
   List<DetalleVentaDTO> reporteListaDetalleVenta(@Param("id_venta") Long id_venta);
   ```

   **Descripción**: Genera un reporte con los detalles de un producto en una venta específica.

3. **Cliente con más compras realizadas**:

   ```java
   @Query("SELECT c.nombre, c.cedula, COUNT(v.idCliente.cedula) AS compras_realizadas " +
          "FROM Cliente c INNER JOIN Venta v ON c.cedula = v.idCliente.cedula " +
          "GROUP BY c.cedula ORDER BY compras_realizadas DESC LIMIT 1")
   List<Object> clienteConMasCompras();
   ```

   **Descripción**: Encuentra al cliente con más compras realizadas, ordenando por la cantidad de compras.

4. **Reporte de ventas por categoría**:

   ```java
   @Query("SELECT new com.gestionPlus.PracticaTienda.DTO.VentaDTO(v.id_venta, v.fecha, v.categoria) " +
          "FROM Venta v WHERE v.categoria = :categoria")
   List<VentaDTO> reporteVentasPorCategoria(@Param("categoria") String categoria);
   ```

   **Descripción**: Lista las ventas filtradas por una categoría específica.

## Estructura del proyecto

```
src/
├── main/
│   ├── java/
│   │   └── com/gestionPlus/PracticaTienda/
│   │       ├── Controller/    # Controladores REST
│   │       ├── DTO/           # Data Transfer Objects
│   │       ├── Entity/        # Entidades JPA
│   │       ├── Repository/    # Interfaces de repositorio
│   │       ├── Service/       # Lógica de negocio
│   │       └── PracticaTiendaApplication.java
│   └── resources/
│       ├── application.properties # Configuración de la aplicación
│       ├── static/                # Archivos estáticos
│       └── templates/             # Plantillas Thymeleaf (si aplica)
└── test/
    └── java/
        └── com/gestionPlus/PracticaTienda/
```

## Autor

Proyecto creado por Alexander Tasinchano.

## Licencia

Este proyecto está bajo la Licencia MIT. Consulta el archivo `LICENSE` para más información.

