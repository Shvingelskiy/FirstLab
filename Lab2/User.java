package sample;
/**
 * This method describe user class
 * @Author Shvingelskiy Evgeniy
 * @since 1.0
 * @version 1.0
 */

public class User {

    private AuthorizationSystem autSyst;

    public void setAutSyst(AuthorizationSystem syst){
        autSyst = syst;
    }

    public AuthorizationSystem getAutSyst(){
        return autSyst;
    }

    public void toRegister(String name, String login, String password) {
        /**
         * This method registered new user
         * @Author Shvingelskiy Evgeniy
         * @since 1.0
         * @version 1.0
         */
        autSyst.setData(name,login,password);
    }

}
