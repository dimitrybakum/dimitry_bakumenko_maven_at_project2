package page.objects.day21_classwork.restAssured;

import java.util.Objects;

public class Search {
    String user = "";
    boolean strict;

    public Search(String user, boolean strict) {
        this.user = user;
        this.strict = strict;
    }

    public Search() {}

    public String getUser() {return user;}
    public void setUser(String user) {
        this.user = user;
    }
    public boolean isStrict() {
        return strict;
    }
    public void setStrict(boolean strict) {
        this.strict = strict;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Search that = (Search) o;
        return strict == that.strict &&
                Objects.equals(user, that.user);
    }

    @Override
    public String toString() {
        return "Search{" +
                "user='" + user + '\'' +
                ", strict=" + strict +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, strict);
    }
}
