package sample;
/**
 * This method describe user class
 * @Author Shvingelskiy Evgeniy
 * @since 1.0
 * @version 1.0
 */

public class User extends AbstractUser{

    private AuthorizationSystem autSyst;

    public void setAutSyst(AuthorizationSystem syst){
        autSyst = syst;
    }

    public AuthorizationSystem getAutSyst(){
        return autSyst;
    }

    public void toRegister(String name, String login, String password, String nick, String mail) {
        /**
         * This method registered new user
         * @Author Shvingelskiy Evgeniy
         * @since 1.0
         * @version 1.0
         */
        autSyst.setData(name,login,password);
        this.nick = nick;
        System.out.println(this.nick);
        this.mail = mail;
        System.out.println(this.mail);
    }
}
