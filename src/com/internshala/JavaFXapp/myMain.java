package com.internshala.JavaFXapp;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

/**
 * Created by Dell on 07-May-23.
 */

public class myMain extends Application{

    public static void main(String[] args){
        System.out.println("Main");
        launch(args);
    }

    @Override
    public void init() throws Exception {
        System.out.println("init");          //Initialization & creation of your Application
        super.init();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        System.out.println("Start");           //Starts a Application

        FXMLLoader loader = new
                FXMLLoader(getClass().getResource("app_layout.fxml"));
        VBox rootNode = loader.load();


        MenuBar menuBar = createMenu();
        rootNode.getChildren().add(0, menuBar);

        Scene scene = new Scene(rootNode, 300, 275);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Temperature Converter Tool");
//        primaryStage.setResizable(false);    (resize your application layout).
        primaryStage.show();
    }

    private MenuBar createMenu(){
        //we are creating here fileMenu
        Menu fileMenu = new Menu("File");
        MenuItem newMenuItem = new MenuItem("New");

//        newMenuItem.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                System.out.println("New Menu Item Clicked!");
//            }
//        });

        //replace by lambda
        newMenuItem.setOnAction(event -> {
            System.out.println("New Menu Item Clicked!");
        });

        SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
        MenuItem quitMenuItem = new MenuItem("Quit");

        //replace by lambda Manually
        quitMenuItem.setOnAction(event ->{
            Platform.exit();
            System.exit(0);
        });

//        quitMenuItem.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
////                System.out.println("Quit Menu Item Clicked!");
//                Platform.exit();               //Shut Down My Application
//                System.exit(0);         //Shut Down My Application
//
//            }
//        });

        fileMenu.getItems().addAll(newMenuItem, separatorMenuItem, quitMenuItem);

        //we are creating here helpMenu
        Menu helpMenu = new Menu("Help");
        MenuItem aboutApp = new MenuItem("About");

//        aboutApp.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                aboutApp();
//            }
//        });

        //replace by lambda
        aboutApp.setOnAction(event -> aboutApp());

        helpMenu.getItems().addAll(aboutApp);

        //we are creating here menuBar
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, helpMenu);

        return menuBar;
    }

    public static void aboutApp() {
        //TODO
        Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
        alertDialog.setTitle("My First Desktop App!");
        alertDialog.setHeaderText("Learning JavaFX Really Awesome!");
        alertDialog.setContentText("I am just a beginner but soon I will be pro and start developing awesome Java Games!");

        //We want costume Button
        ButtonType yesBtn = new ButtonType("Yes");
        ButtonType noBtn =new ButtonType("No");
        alertDialog.getButtonTypes().setAll(yesBtn, noBtn);

//        alertDialog.show();
        Optional<ButtonType> clickBtn =  alertDialog.showAndWait();
        if(clickBtn.isPresent() && clickBtn.get() == yesBtn){
            System.out.println("Yes Button Clicked!");
        }else {
            System.out.println("No Button Clicked!");
        }
    }

    @Override
    public void stop() throws Exception {
        System.out.println("Stop");             //Called when Application stopped & is about to shut-Down
        super.stop();
    }
}
