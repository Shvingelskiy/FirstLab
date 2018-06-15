package sample;

/**
 * This method describe RegisteredUser class
 * @Author Shvingelskiy Evgeniy
 * @since 1.0
 * @version 1.0
 */

public class RegisteredUser extends User {
    UserInformation userInf[];

    AuthorizationSystem auts ;
    public RegisteredUser(AuthorizationSystem autsys) {
        /**
         * This method describe this aggregation class(UserInformation) and creates it's array of objects
         * @Author Shvingelskiy Evgeniy
         * @since 1.0
         * @version 1.0
         */
        userInf = new UserInformation[5];

        this.userInf = autsys.userInf;
        auts = autsys;
    }

    public void signIn(String name, String login, String password) {
        /**
         * This login method
         * @Author Shvingelskiy Evgeniy
         * @since 1.0
         * @version 1.0
         */
        auts.checkUser(name,login,password, userInf);
    }

}
