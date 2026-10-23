import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import java.lang.NumberFormatException;

public class PropertyAppFX extends Application implements EventHandler<ActionEvent> {
    private ManagementCompany mc = new ManagementCompany("Gotham City Property Group", "98-7654321");
    Button addProperty, calcTotalRent, showProperties;
    TextField propertyName, city, rent, owner;
    TextArea textArea;
    double r;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Property Managment");

        propertyName = new TextField();
        city = new TextField();
        rent = new TextField();
        owner = new TextField();

        propertyName.setPromptText("Property Name: ");
        city.setPromptText("City: ");
        rent.setPromptText("Rent: ");
        owner.setPromptText("Owner: ");

        textArea = new TextArea();

        addProperty = new Button("Add Property");
        calcTotalRent = new Button("Calculate Total Rent");
        showProperties = new Button("Show All Properties");

        addProperty.setOnAction(this);
        calcTotalRent.setOnAction(this);
        showProperties.setOnAction(this);

        HBox hbox = new HBox(10, addProperty, showProperties, calcTotalRent);
        VBox vbox = new VBox(10, propertyName, city, rent, owner, hbox, textArea);
        vbox.setPadding(new Insets(10));
        Scene scene = new Scene(vbox, 500, 400);
        primaryStage.setScene(scene);

        primaryStage.show();

    }

    @Override
    public void handle(ActionEvent e) {
        if (e.getSource() == addProperty) {

            String pn = propertyName.getText();
            if (pn.isEmpty()) {
                textArea.setText("Property name not provided. Enter a property name.");
                return;
            } else {
                try {
                    double d = Double.valueOf(propertyName.getText());
                    if (d >= 0) {
                        textArea.setText("Enter a valid property name not a number.");
                        return;
                    }
                } catch (NumberFormatException i) {
                }
            }

            String c = city.getText();
            if (c.isEmpty()) {
                textArea.setText("City was empty. Enter a city.");
                return;
            } else {
                try {
                    double d = Double.valueOf(city.getText());
                    if (d >= 0 || d < 0) {
                        textArea.setText("Enter a valid city not a number.");
                        return;
                    }

                } catch (NumberFormatException w) {
                }
            }

            String preInputChange = rent.getText();
            if (preInputChange.isEmpty()) {
                textArea.setText("Rent was empty. Enter a valid number");
                return;
            } else {
                try {
                    r = Double.valueOf(rent.getText());
                    if (r <= 0) {
                        textArea.setText("Invalid input! Enter a number that is greater than 0");
                        return;
                    }
                } catch (NumberFormatException j) {
                    textArea.setText("Error! Enter a valid number.");
                    return;
                }
            }

            String o = owner.getText();
            if (o.isEmpty()) {
                textArea.setText("Owner was empty. Enter a valid input");
                return;
            } else {
                try {
                    double d = Double.valueOf(owner.getText());
                    if (d >= 0) {
                        textArea.setText("Enter a valid owner not a number.");
                        return;
                    }
                } catch (NumberFormatException l) {
                }
            }

            Property p = new Property(pn, c, r, o);
            int retrn = mc.addProperty(p);
            if (retrn == -1) {
                textArea.setText("You have reached the limit of 5 properties");
            } else {
                textArea.setText("Property Successfully Added");
            }

        } else if (e.getSource() == calcTotalRent) {
            textArea.setText(String.format("$%,.2f", mc.totalRent()));
        } else if (e.getSource() == showProperties) {
            textArea.setText(mc.toString());
        }
    }

}
