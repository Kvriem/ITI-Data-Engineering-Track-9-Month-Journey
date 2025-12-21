import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HelloWorldApp extends Application {

    @Override
    public void start(Stage primaryStage) {

        Text text = new Text("Hello World");
        text.setFill(Color.ORANGE);
        text.setFont(Font.font("Verdana", FontWeight.BOLD, 40));


        Reflection reflection = new Reflection();
        reflection.setFraction(0.7);
        reflection.setTopOffset(-10);
        text.setEffect(reflection);

        Stop[] stops = new Stop[] {
                new Stop(0, Color.GRAY),
                new Stop(1, Color.WHITE)
        };

        LinearGradient gradient = new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE, stops);

        StackPane root = new StackPane();
        root.getChildren().add(text);
        root.setAlignment(Pos.CENTER);
        root.setBackground(new Background(new BackgroundFill(gradient, null, null)));

        Scene scene = new Scene(root, 400, 300);

        primaryStage.setTitle("Hello JFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}