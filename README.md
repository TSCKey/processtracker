# Process Tracker

A simple task/process tracking application built with Spring Boot and a lightweight HTML/CSS/JS frontend.

---

## Deutsch

### Anwendung starten

#### Option 1 – Ausführbare JAR-Datei starten

1. Das ZIP-Archiv von der [Release-Seite](https://github.com/TSCKey/processtracker/releases/tag/v1.0.0) herunterladen und entpacken.
2. Im entpackten Ordner die Anwendung starten:

   ```bash
   java -jar ProcessTracker-v1.0.jar
   ```

3. Anschließend [http://localhost:8080](http://localhost:8080) im Browser öffnen.

#### Option 2 – Projekt aus dem Quellcode starten

1. Repository klonen:

   ```bash
   git clone https://github.com/TSCKey/processtracker.git
   cd ProcessTracker
   ```

2. Anwendung starten:

   ```bash
   ./gradlew bootRun
   ```

3. Anschließend [http://localhost:8080](http://localhost:8080) im Browser öffnen.

### Entscheidungen

Die Anwendung wurde mit Spring Boot und einem einfachen HTML-, CSS- und JavaScript-Frontend umgesetzt, um eine klare und leicht wartbare Architektur zu gewährleisten. Als Datenbank wurde SQLite gewählt, da sie ohne zusätzliche Installation auskommt und dennoch eine persistente Speicherung der Aufgaben ermöglicht. Die Kommunikation zwischen Frontend und Backend erfolgt über eine REST-API, wobei Statusänderungen direkt übernommen werden können.

### KI-Einsatz

KI wurde hauptsächlich zum Refactoring des Codes, zur Unterstützung bei der Fehlersuche und -behebung, zur Verbesserung des Frontend-Layouts sowie zur Formulierung und Überarbeitung von Dokumentationstexten eingesetzt. Die Architektur, Implementierung und abschließende Integration der Anwendung wurden eigenständig umgesetzt und überprüft.

---

## English

### Starting the application

#### Option 1 – Run the executable JAR

1. Download the ZIP archive from the [releases page](https://github.com/TSCKey/processtracker/releases/tag/v1.0.0) and extract it.
2. From the extracted folder, run the application:

   ```bash
   java -jar ProcessTracker-v1.0.jar
   ```

3. Then open [http://localhost:8080](http://localhost:8080) in your browser.

#### Option 2 – Run from source

1. Clone the repository:

   ```bash
   git clone https://github.com/TSCKey/processtracker.git
   cd ProcessTracker
   ```

2. Start the application:

   ```bash
   ./gradlew bootRun
   ```

3. Then open [http://localhost:8080](http://localhost:8080).

### Design decisions

The application was implemented with Spring Boot and a simple HTML, CSS, and JavaScript frontend to provide a lightweight and maintainable architecture. SQLite was chosen as the database because it requires no additional setup while still providing persistent storage. Communication between the frontend and backend is handled through a REST API, allowing task status updates without restarting the application.

### AI usage

AI was primarily used for code refactoring, debugging and error fixing, improving the frontend layout, and assisting with writing and refining documentation. The overall architecture, implementation, and final integration of the application were completed and verified independently.
