package sample;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * This method describe RegisteredUser class
 * @Author Shvingelskiy Evgeniy
 * @since 1.0
 * @version 1.0
 */

public class RegisteredUser extends User {
    UserInformation userInf[];
    int index;

    AuthorizationSystem auts ;
    public RegisteredUser(AuthorizationSystem autsys) {
        /**
         * This method describe this aggregation class(UserInformation) and creates it's array of objects
         * @Author Shvingelskiy Evgeniy
         * @since 1.0
         * @version 1.0
         */
        userInf = new UserInformation[10];
        this.userInf = autsys.userInf;
        auts = autsys;
    }

    public int signIn(User[] users, String name, String login, String password) {
        /**
         * This login method
         * @Author Shvingelskiy Evgeniy
         * @since 1.0
         * @version 1.0
         */
        index = auts.checkUser(name,login,password, userInf);
        if (index >= 0) {
            tellInfo(users[index]);
            return 1;
        }
        return 0;
    }

    public int editInf(String name, String login, String password) {
        if (auts.editInf(name,login,password, userInf) == 1) {
            return 1;
        }
        return 0;
    }

    private void tellInfo(User parent) {
        /**
         * This method displays user information
         * @Author Shvingelskiy Evgeniy
         * @since 1.0
         * @version 1.0
         */
        //abstUserMas[0].getInformation();
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information about User");
        alert.setHeaderText(null);
        alert.setContentText("Ник: " + parent.nick + "\n\nПочта: " + parent.mail);
        alert.showAndWait();
    }
}
