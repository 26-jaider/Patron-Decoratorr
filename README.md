# Museum Experience Pass

A Java 17 museum pass customization application.

## Features

- General museum admission
- Audio Guide
- Virtual Tour
- VIP Access
- Accessibility Mode
- Dynamic price calculation
- Responsive interface
- Java backend with built-in HTTP server

## Run

This project does not require Maven.

Open PowerShell in the project folder and run:

```powershell
javac -d out (Get-ChildItem -Recurse -Filter *.java | ForEach-Object { $_.FullName })
```

Then:

```powershell
java -cp out com.museum.Main
```

Open:

http://localhost:8080

## Academic structure

The Java implementation uses object-oriented composition to build a customizable museum pass. The base pass and optional services are represented by separate classes, allowing combinations without modifying the base pass.
