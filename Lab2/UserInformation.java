package sample;

/**
 * This method describe UserInformation class
 * @Author Shvingelskiy Evgeniy
 * @since 1.0
 * @version 1.0
 */

public class UserInformation {
    private String name;
    private String login;
    private String password;

    private AuthorizationSystem autSyst;

    public void setAutSyst(AuthorizationSystem sys){
        autSyst = sys;
    }

    public void getInfoForCons() {
        /**
         * This method output information to console
         * @Author Shvingelskiy Evgeniy
         * @since 1.0
         * @version 1.0
         */
        System.out.println("name: " + name);
        System.out.println("login: " + login);
        System.out.println("password: " + password);
    }

    public void setInfo(String name, String login, String password) {
        /**
         * This method set information
         * @Author Shvingelskiy Evgeniy
         * @since 1.0
         * @version 1.0
         */
        this.name = name;
        this.login = login;
        this.password = password;
        System.out.println("Пользователь зарегистрирован");
        getInfoForCons();
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

}
