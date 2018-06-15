package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;

/**
 * This method describe GUI and method for button
 * @Author Shvingelskiy Evgeniy
 * @since 1.0
 * @version 1.0
 */

public class GUI extends Application {

    User users[];
    AuthorizationSystem system1;
    int count;


    public GUI() {
        system1 = new AuthorizationSystem();
        users = new User[10];
        for (int i = 0; i < 10; i++) {
            users[i] = new User();
            users[i].setAutSyst(system1);
        }
        count = 0;
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Lab 3");

        BorderPane root = new BorderPane();

        VBox vbox1 = new VBox(10); // отступы между элементами - 10px
        VBox vbox2 = new VBox(10); // отступы между элементами - 10px
        HBox hbox = new HBox(30);
        hbox.setAlignment(Pos.CENTER);


        Label reg = new Label("Регистрация");
        TextField regName = new TextField("");
        regName.setPromptText("Введите имя: ");
        TextField regLogin = new TextField("");
        regLogin.setPromptText("Введите Логин: ");
        PasswordField regPassword = new PasswordField();
        regPassword.setPromptText("Введите Пароль: ");


        TextField regNick = new TextField("");
        regNick.setPromptText("Введите ник: ");
        TextField regMail = new TextField("");
        regMail.setPromptText("Введите mail: ");

        Button submit = new Button("Отправить!");

        Label login = new Label("Вход");
        TextField entrName = new TextField("");
        entrName.setPromptText("Введите имя: ");
        TextField entrLogin = new TextField("");
        entrLogin.setPromptText("Введите Логин: ");
        PasswordField entrPassword = new PasswordField();
        entrPassword.setPromptText("Введите Пароль: ");
        Button signIn = new Button("Войти!");

        Label editInf = new Label("Изменить информацию");
        Label emptyInf = new Label("\n\n\n");
        TextField editName = new TextField("");
        editName.setPromptText("Введите имя: ");
        TextField editLogin = new TextField("");
        editLogin.setPromptText("Введите Логин: ");
        PasswordField editPassword = new PasswordField();
        editPassword.setPromptText("Введите Пароль: ");
        Button edit = new Button("Изменить!");


        vbox1.getChildren().addAll(reg, regName, regLogin, regPassword, regNick, regMail, submit);
        vbox2.getChildren().addAll(login, entrName, entrLogin, entrPassword, signIn);
        hbox.getChildren().addAll(vbox1, vbox2);
        root.setTop(hbox);


        submit.setOnAction(event -> {
            users[count++].toRegister(regName.getText(),regLogin.getText(),regPassword.getText(), regNick.getText(), regMail.getText()) ;

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Registration user");
            alert.setHeaderText(null);
            alert.setContentText("Пользователь успешно зарегистрирован!");
            alert.showAndWait();

            regName.setText("");
            regLogin.setText("");
            regPassword.setText("");
            regNick.setText("");
            regMail.setText("");
        } );

        signIn.setOnAction(event -> {
            if (users[0].getAutSyst().userReg.signIn(users,entrName.getText(),entrLogin.getText(),entrPassword.getText()) == 1) {
                vbox2.getChildren().addAll(emptyInf, editInf, editName, editLogin, editPassword, edit);
            }
            entrName.setText("");
            entrLogin.setText("");
            entrPassword.setText("");

            edit.setOnAction(event1 -> {
                if (users[count].getAutSyst().userReg.editInf(editName.getText(),editLogin.getText(),editPassword.getText()) == 1) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Edit profile info.");
                    alert.setHeaderText(null);
                    alert.setContentText("Информация о пользователе успешна изменена!");
                    alert.showAndWait();

                    editName.setText("");
                    editLogin.setText("");
                    editPassword.setText("");
                    vbox2.getChildren().removeAll(emptyInf, editInf, editName, editLogin, editPassword, edit);

                }
            } );

        } );

        Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void showing(){
        launch();
    }

}
