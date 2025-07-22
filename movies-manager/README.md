# Movies Manager

Este repositorio contiene una serie de **retos prácticos** y **proyectos de ejemplo** para practicar **programación reactiva** utilizando Java, Spring WebFlux y Project Reactor.

La base de datos utilizada representa un conjunto de **películas**, con sus **directores** y **actores**, ideal para aplicar transformaciones, combinaciones y operaciones reactivas.

---

## 📚 Contenido

- ✅ Servicio reactivo que carga películas, actores y directores desde una base de datos MongoDB embebida
- 🔁 Retos que permiten practicar operadores clave como `map`, `filter`, `flatMap`, `groupBy`, `reduce` y `Mono.zip`
- 🔍 Consultas y endpoints REST de ejemplo para probar

---

## ⭐ Modelo de Datos

### 🎬 Movie

```json
{
    "id": "687eb1b844dc5bfc4277c358",
    "title": "Inception",
    "director": "Christopher Nolan",
    "actors": [
        "Leonardo DiCaprio",
        "Joseph Gordon-Levitt",
        "Elliot Page"
    ],
    "categories": [
        "Action",
        "Adventure",
        "Sci-Fi",
        "Psychological Thriller"
    ],
    "year": 2010,
    "rating": 8.8
}
```

### 🎬 Director

```json
{
    "id": "687eb1b844dc5bfc4277c34c",
    "name": "Christopher Nolan",
    "country": "UK",
    "birthYear": 1970,
    "deathYear": null
}
```

**Nota:**

Cada película está relacionada por el nombre del director

---

## 🌐 Endpoints REST

| Método | Ruta | Descripción | Estado |
| --- | --- | --- | --- |
| `GET` | `/movies` | Listar todas las películas | ✅ |
| `GET` | `/movies/{id}` | Obtener una película por ID | ✅ |
| `GET` | `/directors` | Películas con mejor calificación | ✅ |
| `GET` | `/directors/{id}` | Obtener un director por ID | ✅ |
| `GET` | `/directors/best-movie` | Obtiene la película con mejor rating por director | 🤔 |
| `GET` | `/directors/top-rated` | Obtiene el top 5 de directores | 🤔 |
| `GET` | `/actors/most-frequent-by-category` | Obtiene el actor mas frecuente por categoría | 🤔 |
| `GET` | `/movies/search-by-categories` | Obtiene el listado de películas de diferentes categorías | 🤔 |
| `GET` | `/movies/recommendations/{movieId}` | Obtiene recomendaciones dado una película | 🤔 |

## 🎯 Objetivo

Finalizar los endpoints propuestos con el fin de fortalecer conocimientos en **desarrollo reactivo**, **programación funcional** en Java, y el uso de **flujos de datos no bloqueantes** en aplicaciones modernas.

Estos retos están diseñados para practicar operaciones avanzadas de programación reactiva usando `Flux`, `Mono`, `Mono.zip`, agrupaciones y transformaciones, a partir de un modelo de datos de películas que incluye directores, actores, categorías y ratings.

| # | Descripción del Reto | Condiciones / Reglas de negocio |
| --- | --- | --- |
| 1 | Obtiene la película con mejor rating por director | Se debe retornar la mejor película (por rating) asociada a cada director. |
| 2 | Obtiene el top 5 de directores | Se debe retornar un listado con los 5 directores con mejor promedio de rating. |
| 3 | Obtiene el actor más frecuente por categoría | Por parámetro solo se puede recibir una sola categoría. Si existe más de un actor con la misma frecuencia, se debe retornar el primer actor ordenado alfabéticamente de forma ascendente. |
| 4 | Obtiene el listado de películas de diferentes categorías | A partir de una lista de categorías recibida por parámetro, retornar las películas agrupadas por categoría. |
| 5 | Obtiene recomendaciones dado una película | A partir del ID de una película, se deben recomendar películas que compartan al menos el director o un actor. No se debe incluir la misma película en los resultados. |

---

## 🚀 ¿Cómo ejecutar?

1. Clona el repositorio
    
    > *git clone https://github.com/loaizajimmy/java-pocs.git*

1. Ejecuta la aplicación Spring Boot (Mongo se inicia embebido)

3. Prueba los endpoints usando Postman o`curl`

4. Importa la colección de Postman desde el siguiente enlace:
   [Colección de Postman](https://api.postman.com/collections/2205264-f3908051-e7a3-4672-a8a3-906b2db7aed7?access_key=PMAT-01K0QHQVHJT55VQ5X6R4H1XDK5)


## 🤝 Contribuciones

¿Quieres agregar un nuevo reto o mejorar los existentes?

¡Tus pull requests son bienvenidos!