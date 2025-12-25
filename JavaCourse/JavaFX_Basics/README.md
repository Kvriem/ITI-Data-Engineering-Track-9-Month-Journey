# JavaFX Basics

A JavaFX project containing sample applications demonstrating JavaFX capabilities.

## Applications

### TextEditor Application (Primary)
A fully functional text editor with File, Edit, and Help menus supporting:
- File operations (New, Open, Save)
- Edit operations (Cut, Copy, Paste, Delete, Select All)
- Keyboard shortcuts

### HelloWorld Application
Simple demo displaying styled "Hello World" text with effects.

## Requirements

- Java 17 or higher
- Maven 3.6+

## Running the Applications

### TextEditor (Recommended)
```bash
mvn javafx:run -Djavafx.mainClass=com.example.javafx.TextEditorApplication
```

### HelloWorld Demo
```bash
mvn javafx:run -Djavafx.mainClass=com.example.javafx.Main
```

Or simply:
```bash
mvn javafx:run
```

## Building

Compile the project:
```bash
mvn clean compile
```

Create executable JAR:
```bash
mvn clean package
```

## Project Structure

```
JavaFX_Basics/
├── pom.xml
├── src/
│   └── main/
│       ├── java/com/example/javafx/
│       │   ├── Main.java
│       │   ├── HelloWorldApp.java
│       │   ├── TextEditorApplication.java
│       │   └── TextEditorController.java
│       └── resources/com/example/javafx/
│           ├── textEditor.fxml
│           └── view.fxml
└── target/
```

## License

Educational project for learning JavaFX basics.
