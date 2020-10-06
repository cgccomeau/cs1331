import javafx.application.Application;
import javafx.beans.binding.Bindings;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
/**
 * @author ccomeau7
 * @version 1.0
 */
public class OfficeHourQueue extends Application {

    private int count = 0;
    private int max = count;

    @Override public void start(Stage stage) {
        //ObservableList<String> todos = FXCollections.observableArrayList();
        LinkedQueue<String> todos = new LinkedQueue<String>();
        ListView<String> listView = new ListView<String>(todos);

        Button addButton = new Button("Add Student");
        Button dequeue = new Button("Dequeue Student");

        TextField inputField = new TextField();

        Label counterLabel = new Label("Current Number of "
            + "Students in Queue: 0");
        Label maxLabel = new Label("Max Number of Students"
            + " in Queue: 0");

        addButton.setOnAction(e -> {
                boolean empty = true;
                String input = inputField.getText();
                for (int i = 0; i < input.length(); i++) {
                    if (input.charAt(i) != ' ') {
                        empty = false;
                    }
                }

                if (!empty) {
                    todos.enqueue(inputField.getText());
                    inputField.setText("");
                    inputField.requestFocus();
                    counterLabel.setText("Current Number of "
                        + "Students in Queue: " + (++count));
                    if (count > max) {
                        max = count;
                    }
                    maxLabel.setText("Max Number of Students in Queue: " + max);
                }

            });

        dequeue.setOnAction(e -> {
                Stage popup = new Stage();
                Label message = new Label("");
                HBox first = new HBox();
                HBox second = new HBox();
                HBox third = new HBox();
                VBox vertical = new VBox();
                Button ok = new Button("OK");
                Button cancel = new Button("Cancel");

                final PasswordField password = new PasswordField();

                password.setPromptText("Please Enter Password");
                Scene within = new Scene(vertical);

                password.setOnAction(action -> {
                        if (!password.getText().equals("CS1321R0X")) {
                            message.setText("Your password is incorrect");
                        } else {
                            message.setText("Your password has been confirmed");
                            todos.dequeue();
                            counterLabel.setText("Current Number of Students"
                                + " in Queue: " + (--count));
                            popup.close();
                        }
                        password.clear();
                    });
                cancel.setOnAction(close -> popup.close());

                ok.setOnAction(check -> {
                        if (!password.getText().equals("CS1321R0X")) {
                            message.setText("Your password is incorrect");
                        } else {
                            message.setText("Your password has been confirmed");
                            todos.dequeue();
                            counterLabel.setText("Current Number of Students"
                                + " in Queue: " + (--count));
                            popup.close();
                        }
                        password.clear();
                    });

                first.getChildren().addAll(password);
                second.getChildren().addAll(message);
                third.getChildren().addAll(cancel, ok);
                vertical.getChildren().addAll(new Label("Confirmation"),
                    first, second, third);
                popup.setScene(within);
                popup.setTitle("Privilege Check");
                popup.show();

            });

        addButton.disableProperty()
                .bind(Bindings.isEmpty(inputField.textProperty()));

        dequeue.disableProperty().bind((Bindings.isEmpty(todos)));

        HBox entryBox = new HBox();
        entryBox.getChildren().addAll(inputField, addButton, dequeue);
        VBox vbox = new VBox();
        vbox.getChildren().addAll(counterLabel, maxLabel, listView, entryBox);

        Scene scene = new Scene(vbox);
        stage.setScene(scene);
        stage.setTitle("CS 1321 Office Hours Queue");
        stage.show();
    }
}