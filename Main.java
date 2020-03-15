package sample;

import com.sun.source.tree.LambdaExpressionTree;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;
import java.util.concurrent.Flow;

import static javafx.scene.paint.Color.*;

public class Main extends Application {
    Scene botScene , trackScene;
    TextField ssDistancetext,numberOfSensorstext,heighttext,widthtext,lineWidthtext,lineColortext;
    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Dynamic LFR Software");
        //First Scene
        Label botlabel = new Label("Bot Specification");
        botlabel.setFont(new Font("Lato Black",24));

        Label ssDistancelabel = new Label("S->S Distance ");
        Label numberOfSensorslabel = new Label("Number of Sensors ");
        Label heightlabel = new Label("Dimension ");
        Label widthlabel = new Label("Width ");


         ssDistancetext = new TextField();
         numberOfSensorstext = new TextField();
         heighttext = new TextField();
         widthtext = new TextField();

        Button next1 = new Button("Next");
        next1.setStyle("-fx-background-color:#a6a6a6");
        next1.setOnAction(e-> {
            DrawTrack d = new DrawTrack();
            d.info1(Integer.parseInt(ssDistancetext.getText()),Integer.parseInt(numberOfSensorstext.getText()),Integer.parseInt(heighttext.getText()),Integer.parseInt(widthtext.getText()));
            primaryStage.setScene(trackScene);
        });


        FlowPane botPane = new FlowPane(20,20);
        botPane.getChildren().add(botlabel);
        botPane.setAlignment(Pos.TOP_CENTER);
        botPane.setPadding(new Insets(10,0,0,0));

        FlowPane firstPanel = new FlowPane(Orientation.HORIZONTAL,20,20);
        firstPanel.getChildren().add(ssDistancelabel);
        firstPanel.getChildren().add(ssDistancetext);
        firstPanel.getChildren().add(numberOfSensorslabel);
        firstPanel.getChildren().add(numberOfSensorstext);
        firstPanel.setPadding(new Insets(10,0,0,0));
        firstPanel.setAlignment(Pos.BASELINE_CENTER);

        FlowPane secondPanel = new FlowPane(Orientation.HORIZONTAL,20,20);
        secondPanel.getChildren().add(heightlabel);
        secondPanel.getChildren().add(heighttext);
        secondPanel.getChildren().add(widthlabel);
        secondPanel.getChildren().add(widthtext);
        secondPanel.setPadding(new Insets(10,0,0,0));
        secondPanel.setAlignment(Pos.BASELINE_CENTER);

        FlowPane nextPanel = new FlowPane(20,20);
        nextPanel.getChildren().add(next1);
        nextPanel.setAlignment(Pos.BOTTOM_RIGHT);
        nextPanel.setPadding(new Insets(300,50,0,0));

        VBox vb1 = new VBox(10);
        vb1.getChildren().addAll(botPane,firstPanel,secondPanel,nextPanel);
         botScene = new Scene(vb1, 800, 500);
        //second scene
        Label tracklabel = new Label("Track Specification");
        tracklabel.setFont(new Font("Lato Black",24));

        Label lineWidthlabel = new Label("Line Width");
        Label lineColorlabel = new Label("Line Color");

         lineWidthtext = new TextField();
         lineColortext = new TextField();

        FlowPane firstPanel_2 = new FlowPane(20,20);
        firstPanel_2.getChildren().addAll(tracklabel);
        firstPanel_2.setPadding(new Insets(20,0,0,0));
        firstPanel_2.setAlignment(Pos.TOP_CENTER);

        FlowPane secondPanel_2 = new FlowPane(Orientation.HORIZONTAL,20,20);
        secondPanel_2.getChildren().addAll(lineWidthlabel,lineWidthtext,lineColorlabel,lineColortext);
        secondPanel_2.setPadding(new Insets(20,0,0,0));
        secondPanel_2.setAlignment(Pos.BASELINE_CENTER);

        Button next2 = new Button("Next");
        next2.setStyle("-fx-background-color:#a6a6a6");
        next2.setOnAction(e-> {
            DrawTrack d = new DrawTrack();
           d.info2(Integer.parseInt(lineWidthtext.getText()),lineColortext.getText());
        });
        FlowPane nextpane2 = new FlowPane(20,20);
        nextpane2.getChildren().add(next2);
        nextpane2.setAlignment(Pos.BOTTOM_RIGHT);
        nextpane2.setPadding(new Insets(327,50,0,0));

        VBox vb2 = new VBox(10);
        vb2.getChildren().addAll(firstPanel_2,secondPanel_2,nextpane2);
       trackScene = new Scene(vb2,800,500);


        primaryStage.setScene(botScene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
