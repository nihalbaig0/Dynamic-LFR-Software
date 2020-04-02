package sample;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.transform.Rotate;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class DrawTrack {
    static double ssDistance,numberOfSensors,height,width, linewidth;
    static String linecolor;

    double orgSceneX, orgSceneY;
    double orgTranslateX, orgTranslateY;
    double angle;
    boolean btpress= false;
    private Rotate rt;
    Button circlebtn ,rectbtn,anglebtn;
    FlowPane shapepane;
    void info1(double ssDistance,double numberOfSensors,double height,double width)
    {

        this.ssDistance = ssDistance;
        this.numberOfSensors = numberOfSensors;
        this.height = height;
        this.width = width;

    }
      void info2(double linewidth,String linecolor)
     {
         Stage window;
         window = new Stage();
         window.setTitle("DrawTrack");
         window.initModality(Modality.APPLICATION_MODAL);



         this.linewidth = linewidth;
         this.linecolor = linecolor;

         TextField rectHeighttxt = new TextField();
         TextField circleRadiustxt = new TextField();
         TextField angletxt = new TextField();

         circlebtn = new Button("Circle");
         circlebtn.setAlignment(Pos.BASELINE_CENTER);
         circlebtn.setOnAction(e->createCircle("blackCircle",Main.toInch(Double.parseDouble(circleRadiustxt.getText()))));

         rectbtn = new Button("Rectangle");
         rectbtn.setAlignment(Pos.BASELINE_CENTER);
         rectbtn.setOnAction(e->createRectangle(width,Main.toInch(Double.parseDouble(rectHeighttxt.getText()))));

         anglebtn= new Button("Angle");
         anglebtn.setAlignment(Pos.BASELINE_CENTER);
         anglebtn.setOnAction(e->
         {
             angle = Integer.parseInt(angletxt.getText());
             btpress = true;
             angletxt.clear();
         });
        //Label
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
         Label rectHeightlbl = new Label("Height");
         Label circleRadiuslbl = new Label("Radius");
         Label anglelbl = new Label("Angle");




         /*final Canvas canvas = new Canvas(500,700);
         GraphicsContext gc = canvas.getGraphicsContext2D();
         gc.setFill(Color.WHITE);
         gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());*/

         shapepane = new FlowPane(Orientation.VERTICAL,20,20);
        // shapepane.getChildren().addAll(canvas);
         shapepane.setStyle("-fx-background-color: white;");
         shapepane.setMinHeight(600);
         shapepane.setMinWidth(750);
         shapepane.setAlignment(Pos.BASELINE_RIGHT);

         FlowPane infopane = new FlowPane(Orientation.HORIZONTAL,20,20);
         infopane.getChildren().addAll(botspeci,ssDistancelabel,numberOfSensorslabel,heightlabel,widthlabel,linewidthlabel,linewidthcolorlabel);
         infopane.setAlignment(Pos.BASELINE_RIGHT);

         HBox hb1 = new HBox(10);
         hb1.getChildren().addAll(circleRadiuslbl,circleRadiustxt);
         hb1.setAlignment(Pos.BASELINE_CENTER);
         HBox hb2 = new HBox(10);
         hb2.getChildren().addAll(rectHeightlbl,rectHeighttxt);
         hb2.setAlignment(Pos.BASELINE_CENTER);
         HBox hb3 = new HBox(10);
         hb3.getChildren().addAll(anglelbl,angletxt);
         hb3.setAlignment(Pos.BASELINE_CENTER);

         VBox vb  = new VBox(10);
         vb.getChildren().addAll(hb1,circlebtn,hb2,rectbtn,hb3,anglebtn);
         vb.setAlignment(Pos.BASELINE_LEFT);
         //vb.setStyle("-fx-background-color: #585858");

         HBox hb = new HBox(10);
         hb.getChildren().addAll(vb,shapepane);
         hb.setAlignment(Pos.CENTER_RIGHT);
         hb.setPadding(new Insets(20,20,20,20));

         Scene drawtrackscene = new Scene(hb,1000,600);
         drawtrackscene.getStylesheets().addAll(getClass().getResource("If.css").toExternalForm());

         window.setScene(drawtrackscene);
         window.show();


     }

    void createCircle(String name,Double radius)
    {
        Circle circle;
        circle = new Circle(radius, Color.WHITE);
        circle.setStrokeWidth(width);
        circleColor(circle);
        circle.setCursor(Cursor.HAND);
        circle.setOnMousePressed(circleOnMousePressedEventHandler);
        circle.setOnMouseDragged(circleOnMouseDraggedEventHandler);

        shapepane.getChildren().add(circle);

    }
    void createRectangle(double width,double height)
    {
        Rectangle rect;
        rect = new Rectangle(width,height);
        rectColor(rect);
        rect.setCursor(Cursor.HAND);
        rect.setOnMousePressed(circleOnMousePressedEventHandler);
        rect.setOnMouseDragged(circleOnMouseDraggedEventHandler);
        rect.setOnMouseClicked(e->onMouseClick(e));
        shapepane.getChildren().add(rect);
    }

    EventHandler<MouseEvent> circleOnMousePressedEventHandler =
            new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent t) {
                    orgSceneX = t.getSceneX();
                    orgSceneY = t.getSceneY();
                    orgTranslateX = ((Shape)(t.getSource())).getTranslateX();
                    orgTranslateY = ((Shape)(t.getSource())).getTranslateY();
                }
            };

    EventHandler<MouseEvent> circleOnMouseDraggedEventHandler =
            new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent t) {
                    double offsetX = t.getSceneX() - orgSceneX;
                    double offsetY = t.getSceneY() - orgSceneY;
                    double newTranslateX = orgTranslateX + offsetX;
                    double newTranslateY = orgTranslateY + offsetY;

                    ((Shape)(t.getSource())).setTranslateX(newTranslateX);
                    ((Shape)(t.getSource())).setTranslateY(newTranslateY);
                }
            };
    public void onMouseClick(Event e)
    {
        Shape s = (Shape) e.getSource();
        if(btpress==true)
        {
            s.setRotate(angle);
            btpress = false;

        }
    }
    public void circleColor(Circle circle)
    {
        if(linecolor=="Black")
            circle.setStroke(Color.BLACK);
        else
            circle.setStroke(Color.BLUE);

    }
    public void rectColor(Rectangle rect)
    {
        if(linecolor=="Black")
            rect.setFill(Color.BLACK);
        else
            rect.setFill(Color.BLUE);
    }

}
