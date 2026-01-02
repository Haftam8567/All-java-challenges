package com.diary.manager;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;
import java.nio.file.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class SimpleDiaryApp extends Application {
    
    private TextArea textArea;
    private ListView<String> entryList;
    private Label statusLabel;
    private final Path diaryDir = Paths.get("diary_entries");
    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    
    @Override
    public void start(Stage stage) {
        try {
            Files.createDirectories(diaryDir);
        } catch (IOException e) {
            System.err.println("Could not create diary directory: " + e.getMessage());
        }
        
        BorderPane root = new BorderPane();
        
        // Left panel - entry list
        VBox leftPanel = new VBox(10);
        leftPanel.setPadding(new Insets(10));
        leftPanel.setPrefWidth(250);
        
        Label entriesLabel = new Label("Diary Entries:");
        entryList = new ListView<>();
        entryList.setPrefHeight(400);
        
        Button newButton = new Button("New Entry");
        newButton.setOnAction(e -> createNewEntry());
        
        Button deleteButton = new Button("Delete Entry");
        deleteButton.setOnAction(e -> deleteCurrentEntry());
        
        leftPanel.getChildren().addAll(entriesLabel, entryList, newButton, deleteButton);
        
        // Center panel - text editor
        VBox centerPanel = new VBox(10);
        centerPanel.setPadding(new Insets(10));
        
        Label editorLabel = new Label("Entry Content:");
        textArea = new TextArea();
        textArea.setPrefHeight(500);
        textArea.setWrapText(true);
        
        Button saveButton = new Button("Save Entry");
        saveButton.setOnAction(e -> saveCurrentEntry());
        
        centerPanel.getChildren().addAll(editorLabel, textArea, saveButton);
        
        // Bottom status
        statusLabel = new Label("Ready");
        statusLabel.setPadding(new Insets(5));
        
        root.setLeft(leftPanel);
        root.setCenter(centerPanel);
        root.setBottom(statusLabel);
        
        // Load existing entries
        loadEntries();
        
        // Set up entry selection
        entryList.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                loadEntry(newVal);
            }
        });
        
        Scene scene = new Scene(root, 800, 600);
        stage.setTitle("Simple Diary Manager");
        stage.setScene(scene);
        stage.show();
        
        createNewEntry();
    }
    
    private void loadEntries() {
        try {
            List<String> entries = new ArrayList<>();
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(diaryDir, "*.txt")) {
                for (Path entry : stream) {
                    entries.add(entry.getFileName().toString().replace(".txt", ""));
                }
            }
            entries.sort(String::compareTo);
            entryList.getItems().setAll(entries);
        } catch (IOException e) {
            statusLabel.setText("Error loading entries: " + e.getMessage());
        }
    }
    
    private void createNewEntry() {
        String date = LocalDate.now().format(dateFormatter);
        String entryName = date;
        int counter = 1;
        
        while (entryList.getItems().contains(entryName)) {
            entryName = date + "_" + counter++;
        }
        
        textArea.clear();
        entryList.getSelectionModel().clearSelection();
        statusLabel.setText("New entry: " + entryName);
    }
    
    private void loadEntry(String entryName) {
        try {
            Path entryFile = diaryDir.resolve(entryName + ".txt");
            String content = Files.readString(entryFile);
            textArea.setText(content);
            statusLabel.setText("Loaded: " + entryName);
        } catch (IOException e) {
            statusLabel.setText("Error loading entry: " + e.getMessage());
        }
    }
    
    private void saveCurrentEntry() {
        String content = textArea.getText();
        if (content.trim().isEmpty()) {
            statusLabel.setText("Cannot save empty entry");
            return;
        }
        
        String entryName = entryList.getSelectionModel().getSelectedItem();
        if (entryName == null) {
            createNewEntry();
            entryName = LocalDate.now().format(dateFormatter);
        }
        
        try {
            Path entryFile = diaryDir.resolve(entryName + ".txt");
            Files.writeString(entryFile, content);
            
            if (!entryList.getItems().contains(entryName)) {
                entryList.getItems().add(entryName);
                entryList.getItems().sort(String::compareTo);
            }
            
            statusLabel.setText("Saved: " + entryName);
        } catch (IOException e) {
            statusLabel.setText("Error saving entry: " + e.getMessage());
        }
    }
    
    private void deleteCurrentEntry() {
        String entryName = entryList.getSelectionModel().getSelectedItem();
        if (entryName == null) {
            statusLabel.setText("No entry selected to delete");
            return;
        }
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Entry");
        alert.setHeaderText("Delete entry: " + entryName);
        alert.setContentText("Are you sure you want to delete this entry?");
        
        if (alert.showAndWait().get() == ButtonType.OK) {
            try {
                Path entryFile = diaryDir.resolve(entryName + ".txt");
                Files.deleteIfExists(entryFile);
                entryList.getItems().remove(entryName);
                textArea.clear();
                statusLabel.setText("Deleted: " + entryName);
            } catch (IOException e) {
                statusLabel.setText("Error deleting entry: " + e.getMessage());
            }
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
