package domain;

/**
 * Created by Grey on 5/30/2017.
 */
public class User {
    private String email;
    private String screenName;
    private String password;
    private String status;

    public String getEmail() {
        return email;
    }

    public String getScreenName() {
        return screenName;
    }

    public String getPassword() {
        return password;
    }

    public String getStatus() {
        return status;
    }

    public User() {
    }

    public User(Builder b)
    {
        this.email = b.email;
        this.screenName = b.screenName;
        this.password = b.password;
        this.status = b.status;
    }

    public static class Builder {
        private String email;
        private String screenName;
        private String password;
        private String status;

        public Builder email(String value) {
            this.email = value;
            return this;
        }

        public Builder screenName(String value)
        {
            this.screenName = value;
            return this;
        }

        public Builder password(String value)
        {
            this.password = value;
            return this;
        }

        public Builder status(String value)
        {
            this.status = value;
            return this;
        }

        public User build()
        {
            return new User(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return email != null ? email.equals(user.email) : user.email == null;
    }

    @Override
    public int hashCode() {
        return email != null ? email.hashCode() : 0;
    }
}
