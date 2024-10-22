package com.example.demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DashboardApp extends Application{
        // Labels to display section information
        Label cpuInfoLabel = new Label("CPU Info: Placeholder for CPU Information");
        Label memoryInfoLabel = new Label("Memory Info: Placeholder for Memory Information");
        Label pciInfoLabel = new Label("PCI Info: Placeholder for PCI Information");
        Label busInfoLabel = new Label("Bus Info: Placeholder for Bus Information");

        @Override
        public void start(Stage primaryStage) {
            // Sidebar with buttons for different sections
            VBox sidebar = new VBox();
            sidebar.setSpacing(20);
            sidebar.getStyleClass().add("sidebar");

            // Buttons for each section
            Button cpuButton = new Button("CPU Info");
            Button memoryButton = new Button("Memory Info");
            Button pciButton = new Button("PCI Info");
            Button busButton = new Button("Bus Info");

            // Set button actions to switch content
            StackPane mainContent = new StackPane();
            mainContent.getChildren().add(cpuInfoLabel);
            mainContent.getStyleClass().add("main-content");

            cpuButton.setOnAction(e -> switchContent(mainContent, cpuInfoLabel));
            memoryButton.setOnAction(e -> switchContent(mainContent, memoryInfoLabel));
            pciButton.setOnAction(e -> switchContent(mainContent, pciInfoLabel));
            busButton.setOnAction(e -> switchContent(mainContent, busInfoLabel));

            // Add buttons to sidebar
            sidebar.getChildren().addAll(cpuButton, memoryButton, pciButton, busButton);

            // Main layout with sidebar and main content
            BorderPane root = new BorderPane();
            root.setLeft(sidebar);
            root.setCenter(mainContent);

            // Set an inline style to test CSS application
            root.setStyle("-fx-background-color: lightblue;");  // <--- Test style added here

            // Scene and stage setup
            Scene scene = new Scene(root, 900, 600);

            // Temporarily hard-coded full path to style.css for debugging
            scene.getStylesheets().add("file:/home/ryanmorrissey/Desktop/cs4421/project/main/resources/css/style.css");


            primaryStage.setTitle("Dashboard");
            primaryStage.setScene(scene);
            primaryStage.show();
        }

        // Method to switch the content in the main section
        private void switchContent(StackPane mainContent, Label newContent) {
            mainContent.getChildren().clear();
            mainContent.getChildren().add(newContent);
        }

        public static void main(String[] args) {
            launch(args);
        }
    }
