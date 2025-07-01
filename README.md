# Basket - Aplicación de Finanzas Multiplataforma 📊

Basket es una aplicación de seguimiento de activos financieros desarrollada con Kotlin Multiplatform y Compose Multiplatform, que te permite monitorear precios de criptomonedas en tiempo real.

## 🌟 Características

- 📱 Aplicación multiplataforma (Android, Desktop, Web)
- 💰 Seguimiento en tiempo real de precios de criptomonedas
- ⭐ Gestión de activos favoritos
- 📊 Visualización de datos de mercado
- 🌐 Soporte offline
- 🎨 Interfaz moderna con Material Design 3

## 🛠️ Tecnologías

- **Kotlin Multiplatform**: Base del proyecto multiplataforma
- **Compose Multiplatform**: UI multiplataforma
- **Clean Architecture**: Arquitectura del proyecto
- **Koin**: Inyección de dependencias
- **SQLDelight**: Base de datos local
- **Ktor**: Cliente HTTP
- **Kotlin Coroutines & Flow**: Programación asíncrona

## 📁 Estructura del Proyecto

El proyecto sigue los principios de Clean Architecture y está organizado en las siguientes capas:

- `/composeApp`: Código compartido entre plataformas
  - `commonMain`: Código común para todas las plataformas
    - `data`: Implementación de repositorios y fuentes de datos
    - `domain`: Lógica de negocio y casos de uso
    - `ui`: Interfaces de usuario con Compose
    - `di`: Configuración de inyección de dependencias
  - `androidMain`: Implementación específica para Android
  - `desktopMain`: Implementación específica para Desktop
  - `wasmJsMain`: Implementación específica para Web

## 🚀 Inicio Rápido

### Requisitos Previos

- Android Studio Arctic Fox o superior
- JDK 11 o superior
- Kotlin 1.9.0 o superior

### Ejecutar el Proyecto

**Android**:
```bash
./gradlew :composeApp:assembleDebug
```

**Desktop**:
```bash
./gradlew :composeApp:run
```

**Web**:
```bash
./gradlew :composeApp:wasmJsBrowserDevelopmentRun
```

## 🤝 Contribuir

Las contribuciones son bienvenidas. Por favor, asegúrate de:

1. Hacer fork del proyecto
2. Crear una rama para tu feature (`git checkout -b feature/AmazingFeature`)
3. Commit de tus cambios (`git commit -m 'Add some AmazingFeature'`)
4. Push a la rama (`git push origin feature/AmazingFeature`)
5. Abrir un Pull Request

## 📝 Licencia

Este proyecto está bajo la Licencia MIT - ver el archivo [LICENSE](LICENSE) para más detalles.

## 👥 Autores

- **Tu Nombre** - *Trabajo Inicial* - [TuUsuarioGitHub](https://github.com/TuUsuarioGitHub)

## 🙏 Agradecimientos

- CoinGecko API por proporcionar datos de criptomonedas
- JetBrains por Kotlin y las herramientas de desarrollo
- La comunidad de Kotlin por su continuo soporte
