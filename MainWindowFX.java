package upwork;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Роман Лотоцький on 31.03.2017.
 * Write a Java application which allows
 * to enter information about an image to be displayed.
 * Then, it displays the image.
 * The user will enter name, shape, what to color, color of line, color of fill.

 Use appropriate controls to request data from the user:
 •	The shape should be selected from radio buttons.
 •	A combo box should display the colors for line of the shape.
 The user should be able to select one field only.
 •	Color of the fill is in JList and it should allow user to select one value.
 •	What to be colored can be selected from a group of check boxes.
 •	For Background color use any color you want (user does not have a choice)

 All the drawing should appear in a separate window. This window should display
 name, draw the image and display information about the image in the TextArea.
 Classes to draw shapes will be provided.

 Hint: to implement colors you can create two arrays one with string
 values and one of the Color class. When user would select the color you
 can get the index of that element and pick up corresponding Color from
 the other array at the same index position.

 Main window should exit application if user closes it.
 Response (output window) should only close/dispose itself but not exit the application.

 */
public class MainWindowFX extends Application {
    RadioButton rectangleRB, squareRB, circleRB;
    CheckBox checkBackground, checkFill, checkLine;
    ComboBox<String> comboBoxColorLine, comboBoxColorFill;
    Map<String, Color> map;

    @Override
    public void start(Stage primaryStage) throws Exception {

        HBox firstHBox = createHBox();
        TextField textFieldName = new TextField();
        firstHBox.getChildren().addAll(new Label("Name"), textFieldName);

        rectangleRB = new RadioButton();
        squareRB = new RadioButton();
        circleRB = new RadioButton();
        final ToggleGroup group = new ToggleGroup();
        rectangleRB.setToggleGroup(group);
        rectangleRB.setSelected(true);
        squareRB.setToggleGroup(group);
        circleRB.setToggleGroup(group);
        HBox secondHBox = createHBox();
        secondHBox.getChildren().addAll(new Label("What shape to draw?"),
                new Label("Rectangle"), rectangleRB,
                new Label("Square"), squareRB,
                new Label("Circle"), circleRB);

        checkBackground = new CheckBox();
        checkFill = new CheckBox();
        checkLine = new CheckBox();
        HBox hBoxColor = createHBox();
        hBoxColor.getChildren().addAll(new Label("What to color?"),
                new Label("Background"), checkBackground,
                new Label("Fill"), checkFill,
                new Label("Line"), checkLine);

        String[] choices = { "RED", "ORANGE", "YELLOW", "GREEN", "BLUE", "MAGENTA" };
        Color[] colors = { Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.MAGENTA };
        map = new HashMap<>();
        for(int i = 0; i < choices.length; i++){
            map.put(choices[i], colors[i]);
        }

        ObservableList<String> options = FXCollections.observableArrayList(choices);
        comboBoxColorLine = new ComboBox<>(options);
        comboBoxColorLine.setValue(map.keySet().toArray()[0].toString());
        HBox hBoxColorLine = createHBox();
        hBoxColorLine.getChildren().addAll(new Label("What color line?"), comboBoxColorLine);

        comboBoxColorFill = new ComboBox<>(options);
        comboBoxColorFill.setValue(map.keySet().toArray()[0].toString());
        HBox hBoxColorFill = createHBox();
        hBoxColorFill.getChildren().addAll(new Label("What color of fill?"), comboBoxColorFill);

        Button btn = new Button("Submit");
        btn.setOnAction(e -> new ResultWindow(textFieldName.getText()));
        HBox hBoxForButton = createHBox();
        hBoxForButton.getChildren().addAll(btn);

        VBox root = new VBox();
        root.getChildren().addAll(firstHBox, secondHBox, hBoxColor,
                hBoxColorLine, hBoxColorFill, hBoxForButton);
        Scene scene = new Scene(root, 530, 320, Color.WHITE);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Shapes");
        primaryStage.show();

    }

    public class ResultWindow extends Stage{

        public ResultWindow(String name){
            HBox hBox = createHBox();
            Color backgroundColor = null;
            if(checkBackground.isSelected()) backgroundColor = Color.BLACK;
            Color colorFill = map.get(comboBoxColorFill.getSelectionModel().getSelectedItem());
            Color colorStroke = map.get(comboBoxColorLine.getSelectionModel().getSelectedItem());
            if(rectangleRB.isSelected()) {
                Rectangle rectangle = new Rectangle(250, 150);
                rectangle.setFill(colorFill);
                rectangle.setStroke(colorStroke);
                rectangle.setStrokeWidth(10);
                hBox.setBackground(new Background(new BackgroundFill(backgroundColor,
                        CornerRadii.EMPTY, Insets.EMPTY)));
                hBox.getChildren().add(rectangle);
            }
            if(squareRB.isSelected()){
                Rectangle rectangle = new Rectangle(200, 200);
                rectangle.setFill(colorFill);
                rectangle.setStroke(colorStroke);
                rectangle.setStrokeWidth(10);
                hBox.setBackground(new Background(
                        new BackgroundFill(backgroundColor, CornerRadii.EMPTY, Insets.EMPTY)));
                hBox.getChildren().add(rectangle);
            }
            if(circleRB.isSelected()){
                Circle circle = new Circle(100);
                circle.setFill(colorFill);
                circle.setStroke(colorStroke);
                circle.setStrokeWidth(10);
                hBox.setBackground(new Background(
                        new BackgroundFill(backgroundColor, CornerRadii.EMPTY, Insets.EMPTY)));
                hBox.getChildren().add(circle);
            }

            HBox hBox2 = createHBox();
            TextArea textArea = new TextArea();
            textArea.setText("fillColor: " + colorFill + '\n' +
                    "outlineColor: " + colorStroke + '\n' +
                    "backColor: " + backgroundColor + '\n' +
                    "isFilled: " + checkFill.isSelected() + '\n' +
                    "isOutlined: " + checkLine.isSelected() + '\n' +
                    "isBackColored: " + checkBackground.isSelected());
            hBox2.getChildren().add(textArea);
            VBox root = new VBox();
            root.getChildren().addAll(hBox, hBox2);
            Scene scene = new Scene(root, 440, 380);
            this.setTitle(name);
            this.setScene(scene);
            this.show();
        }
    }

    private HBox createHBox() {
        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setPadding(new Insets(10, 10, 10, 10));
        hBox.setAlignment(Pos.CENTER);
        return hBox;
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
