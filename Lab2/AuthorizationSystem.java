package sample;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * This method describe AuthorizationSystem class
 * @Author Shvingelskiy Evgeniy
 * @since 1.0
 * @version 1.0
 */

public class AuthorizationSystem {

    UserInformation[] userInf; // создание массива объектов типа информация о пользователе(будет хранить всех пользователей)
    RegisteredUser userReg;
    int count = 0;
    int flag = 0;

    public AuthorizationSystem() {
        /**
         * This method describe this aggregation class(UserInformation) and creates it's array of objects
         * @Author Shvingelskiy Evgeniy
         * @since 1.0
         * @version 1.0
         */
        userInf = new UserInformation[5];
        for (int i = 0; i < 5; i++) {
            userInf[i] = new UserInformation();
        }
        userReg = new RegisteredUser(this);
    }

    public void setData(String name, String login, String password) {
        /**
         * This method set information to UserInformation
         * @Author Shvingelskiy Evgeniy
         * @since 1.0
         * @version 1.0
         */
        userInf[count].setInfo(name,login,password); // объекту сообщаем инфу
        count++ ;
    }

    public void checkUser(String name, String login, String password, UserInformation []inf) {
        /**
         * This method checks register user
         * @Author Shvingelskiy Evgeniy
         * @since 1.0
         * @version 1.0
         */
        for (int i=0; i < count ; i++) {
            if (inf[i].getName().equals(name) && inf[i].getLogin().equals(login) && inf[i].getPassword().equals(password)) {
                System.out.println("Вход в систему подтвержден!");
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Login verified.");
                alert.setHeaderText(null);
                alert.setContentText("Вход в систему подтвержден!");
                alert.showAndWait();

                flag = 1;
                break;
            }
            flag = 0;
        }
        if (flag==0)
        {
            System.out.println("Пользователь не найден!");
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("User is not found.");
            alert.setHeaderText(null);
            alert.setContentText("Пользователь не найден!");
            alert.showAndWait();
        }
    }
}
