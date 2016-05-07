/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeuxserieux;

import static java.lang.Math.random;
import java.util.Random;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author marti
 */
public class JeuxSerieux extends Application {

    Paint color = null;
    int total = 0;
    int right = 0;

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();

        Scene scene = new Scene(root, 750, 300);
        Text t = new Text(10, 20, "Ceci est un jeu simple à apprendre les couleurs, cliquez sur démarrer et une couleur apparaît. Entrez le nom de couleur pour continuer");
        Button btn = new Button();
        TextField input = new TextField();
        Button enter = new Button();
        enter.setText("Vérifier");
        btn.setText("Démarrer");
        Text c = new Text(260, 160, "");
        Text score = new Text(50, 50, "");

        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                root.getChildren().remove(btn);
                root.getChildren().remove(t);
                setColor();
                scene.setFill(color);
                root.getChildren().add(input);
                root.getChildren().add(enter);
            }
        });
        enter.setOnAction((e) -> {
            Paint check = toEnglish(input.getText());
            root.getChildren().remove(c);
            root.getChildren().remove(score);
            if (check == color) {
                c.setText("Correcte!");
                right += 1;
                total += 1;

                setColor();
                scene.setFill(color);

            } else {
                c.setText("Faux!");
                total += 1;
            }
            score.setText(Integer.toString(right) + "/" + Integer.toString(total));
            root.getChildren().add(c);
            root.getChildren().add(score);
        });

        btn.setLayoutX(325);
        btn.setLayoutY(100);
        enter.setLayoutX(375);
        enter.setLayoutY(100);
        input.setLayoutX(230);
        input.setLayoutY(100);
        root.getChildren().add(t);
        root.getChildren().add(btn);
        primaryStage.setTitle("Jeux Serieux");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public void setColor() {
        Random rand = new Random();
        int colorNr = rand.nextInt(10);

        switch (colorNr) {
            case 0:
                color = Color.BLUE;
                break;

            case 1:
                color = Color.GREEN;
                break;
            case 2:
                color = Color.BLACK;
                break;
            case 3:
                color = Color.YELLOW;
                break;
            case 4:
                color = Color.WHITE;
                break;
            case 5:
                color = Color.PURPLE;
                break;
            case 6:
                color = Color.RED;
                break;
            case 7:
                color = Color.ORANGE;
                break;
            case 8:
                color = Color.PINK;
                break;
            case 9:
                color = Color.BROWN;
                break;
        }
    }

    public Paint toEnglish(String colorInput) {
        Paint colorEng = null;
        String toLowerCase = colorInput.toLowerCase();
        switch (toLowerCase) {
            case "bleu":
                colorEng = Color.BLUE;
                break;
            case "jaune":
                colorEng = Color.YELLOW;
                break;
            case "noir":
                colorEng = Color.BLACK;
                break;
            case "vert":
                colorEng = Color.GREEN;
                break;
            case "rouge":
                colorEng = Color.RED;
                break;
            case "orange":
                colorEng = Color.ORANGE;
                break;
            case "rose":
                colorEng = Color.PINK;
                break;
            case "brun":
                colorEng = Color.BROWN;
                break;
            case "blanc":
                colorEng = Color.WHITE;
                break;
            case "purple":
                colorEng = Color.PURPLE;
                break;
        }
        return colorEng;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
