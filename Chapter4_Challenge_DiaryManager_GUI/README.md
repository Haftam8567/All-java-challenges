# Chapter 4 Challenge: Simple Diary Manager

A lightweight diary management application built with JavaFX.

## Features

- **Write Entries**: Create new diary entries with date-based naming
- **Read Entries**: View and edit existing entries from a list
- **Delete Entries**: Remove unwanted entries with confirmation
- **Auto-save**: Save entries with a single click
- **File Storage**: Entries stored as simple text files in `diary_entries/` directory

## Quick Start

### Prerequisites
- Java 17 or higher
- Maven 3.6 or higher

### Running the Application

1. **Using the simplified POM:**
   ```bash
   # Copy the simplified POM
   copy pom-simple.xml pom.xml
   
   # Run the application
   mvn clean javafx:run
   ```

2. **Or run directly with the simple class:**
   ```bash
   mvn clean compile exec:java -Dexec.mainClass="com.diary.manager.SimpleDiaryApp"
   ```

## Usage

1. **New Entry**: Click "New Entry" to create a diary entry for today
2. **Write**: Type your diary content in the text area
3. **Save**: Click "Save Entry" to save your work
4. **Browse**: Select entries from the list on the left to view/edit them
5. **Delete**: Select an entry and click "Delete Entry" to remove it

## Project Structure

```
src/main/java/com/diary/manager/
├── SimpleDiaryApp.java          # Main application class
└── (other complex files can be ignored)

diary_entries/                   # Created automatically - stores your diary entries
├── 2024-01-15.txt              # Example entry file
└── ...
```

## Simplifications Made

This version removes:
- Complex MVC architecture with multiple controllers
- Rich text editing and formatting
- Advanced search functionality  
- Theme switching and complex CSS
- Multiple UI panels and navigation
- Background services and tasks
- External dependencies (ControlsFX, FormsFX, etc.)

What remains:
- Core diary functionality (create, read, update, delete)
- Simple, clean interface
- Basic file I/O operations
- Essential JavaFX components only

## File Format

Entries are stored as plain text files named by date:
- `2024-01-15.txt` - Entry for January 15, 2024
- `2024-01-15_2.txt` - Second entry for the same day

This makes your diary entries readable with any text editor and easily portable.
