package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DrawTrack {
    static int ssDistance,numberOfSensors,height,width, linewidth;
    static String linecolor;

      void info1(int ssDistance,int numberOfSensors,int height,int width)
    {

        this.ssDistance = ssDistance;
        this.numberOfSensors = numberOfSensors;
        this.height = height;
        this.width = width;

    }
      void info2(int linewidth,String linecolor)
     {
         Stage window;
         window = new Stage();
         window.setTitle("DrawTrack");
         window.initModality(Modality.APPLICATION_MODAL);
         this.linewidth = linewidth;
         this.linecolor = linecolor;
         Label botspeci = new Label("LFR System");
         botspeci.setFont(new Font("Lato Black",24));

         Label ssDistancelabel = new Label();
         ssDistancelabel.setText("S->S Distance : " + this.ssDistance);
         Label numberOfSensorslabel = new Label();
         numberOfSensorslabel.setText("Number of Sensors : " + this.numberOfSensors);
         Label heightlabel = new Label();
         heightlabel.setText("Height : " + this.height);
         Label widthlabel = new Label();
         widthlabel.setText("Width : " + this.width);
         Label linewidthlabel = new Label();
         linewidthlabel.setText("Line width : " + this.linewidth);
         Label linewidthcolorlabel = new Label();
         linewidthcolorlabel.setText("Line color : " + this.linecolor);
         VBox vb = new VBox(10);
         vb.getChildren().addAll(botspeci,ssDistancelabel,numberOfSensorslabel,heightlabel,widthlabel,linewidthlabel,linewidthcolorlabel);
         vb.setAlignment(Pos.CENTER_RIGHT);
         vb.setPadding(new Insets(20,20,20,20));

         Scene drawtrackscene = new Scene(vb,800,500);

         window.setScene(drawtrackscene);
         window.show();


     }

}
