package domain;

import java.util.Date;

/**
 * Created by Grey on 5/30/2017.
 */
public class Comment {
    private String comment;
    private String ipaddress;
    private Date date;

    public String getComment() {
        return comment;
    }

    public String getIpaddress() {
        return ipaddress;
    }

    public Date getDate() {
        return date;
    }

    public Comment() {
    }

    public Comment(Builder builder)
    {
        this.comment = builder.comment;
        this.ipaddress = builder.ipaddress;
        this.date = builder.date;
    }

    public static class Builder
    {
        private String comment;
        private String ipaddress;
        private Date date;

        public Builder comment(String value)
        {
            this.comment = value;
            return this;
        }

        public Builder ipaddress(String value)
        {
            this.ipaddress = value;
            return this;
        }

        public Builder date(Date date)
        {
            this.date = date;
            return this;
        }

        public Comment build()
        {
            return new Comment(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comment comment = (Comment) o;

        return ipaddress != null ? ipaddress.equals(comment.ipaddress) : comment.ipaddress == null;
    }

    @Override
    public int hashCode() {
        return ipaddress != null ? ipaddress.hashCode() : 0;
    }
}
