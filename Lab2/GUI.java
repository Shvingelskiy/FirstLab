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

    User user1;
    AuthorizationSystem system1;


    public GUI() {
       user1 = new User();
       system1 = new AuthorizationSystem();
       user1.setAutSyst(system1);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Lab 2");

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
        Button submit = new Button("Отправить!");

        Label login = new Label("Вход");
        TextField entrName = new TextField("");
        entrName.setPromptText("Введите имя: ");
        TextField entrLogin = new TextField("");
        entrLogin.setPromptText("Введите Логин: ");
        PasswordField entrPassword = new PasswordField();
        entrPassword.setPromptText("Введите Пароль: ");
        Button signIn = new Button("Войти!");


        vbox1.getChildren().addAll(reg, regName, regLogin, regPassword, submit);
        vbox2.getChildren().addAll(login, entrName, entrLogin, entrPassword, signIn);
        hbox.getChildren().addAll(vbox1, vbox2);
        root.setTop(hbox);

        submit.setOnAction(event -> {
            user1.toRegister(regName.getText(),regLogin.getText(),regPassword.getText()) ;
        } );

        signIn.setOnAction(event -> {
            user1.getAutSyst().userReg.signIn(entrName.getText(),entrLogin.getText(),entrPassword.getText());
        } );


        Scene scene = new Scene(root, 400, 200);

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public void showing(){
        launch();
    }

}
