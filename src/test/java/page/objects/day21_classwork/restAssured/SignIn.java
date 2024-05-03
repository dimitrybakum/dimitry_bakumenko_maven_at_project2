package page.objects.day21_classwork.restAssured;

import java.util.Objects;

public class SignIn {
    String login = "";
    String password = "";

    public SignIn(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public SignIn() {}

    public String getlogin() {
        return login;
    }

    public void setlogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SignIn signIn = (SignIn) o;
        return Objects.equals(getlogin(), signIn.getlogin()) && Objects.equals(getPassword(), signIn.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getlogin(), getPassword());
    }

    @Override
    public String toString() {
        return "SignIn{" +
                "userName='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
