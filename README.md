# Gestión de Tienda - Artículos y Categorías

Aplicación en Java por consola para gestionar artículos y categorías de una tienda, desarrollada aplicando los principales conceptos de Programación Orientada a Objetos.

## Consigna General

Desarrollar una aplicación en Java por consola que permita gestionar **artículos** y **categorías** de una tienda.

La aplicación deberá trabajar con:

- Programación Orientada a Objetos
- Clase abstracta
- Herencia
- Polimorfismo
- Interfaces
- Generics
- Relación entre objetos
- Menús separados

---

## Estructura Conceptual Esperada

### 1. Clase Abstracta `Articulo`

- `codigo`
- `nombre`
- `precio`
- `categoria` (objeto de tipo `Categoria`, **no** un `String`)

### 2. Clases Hijas de `Articulo`

- `ArticuloElectronico`
- `ArticuloAlimenticio`

### 3. Clase `Categoria`

Debe tener su propio **CRUD** completo.

### 4. Interfaz `Calculable`

- `double calcularPrecioFinal();`

### 5. Interfaz `Identificable`

- `int getCodigo();`

### 6. Repositorio Genérico

- `Repositorio<T extends Identificable>`
- Administra tanto artículos como categorías en memoria.

### 7. Sistema de Menús

- Clase base: `Menu`
- `MenuArticulos` (hereda de `Menu`)
- `MenuCategorias` (hereda de `Menu`)

---

## Reglas de Negocio Principales

- No se puede crear un artículo si no existen categorías cargadas.
- No se puede eliminar una categoría si tiene artículos asociados.
- Los códigos de artículos y categorías deben ser **automáticos** (generados por el sistema).
- Se deben validar **todos** los datos ingresados por el usuario.
- No debe resolverse toda la lógica dentro del método `main()`.

---

## Tecnologías y Conceptos Aplicados

- Java (JDK 8 o superior)
- Programación Orientada a Objetos (POO)
- Clases Abstractas e Interfaces
- Herencia y Polimorfismo
- Generics
- Manejo de colecciones en memoria
- Menús modulares por consola
