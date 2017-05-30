package domain;

import java.util.Date;

/**
 * Created by Grey on 5/30/2017.
 */
public class Response {
    private String comment;
    private String ipaddress;
    private Date date;
    private Comment comments;

    public String getComment() {
        return comment;
    }

    public String getIpaddress() {
        return ipaddress;
    }

    public Date getDate() {
        return date;
    }

    public Comment getComments()
    {
        return comments;
    }

    private Response ()
    {

    }

    public Response(Builder builder)
    {
        this.comment = builder.comment;
        this.ipaddress = builder.ipaddress;
        this.date = builder.date;
        this.comments = builder.comments;
    }

    public static class Builder
    {
        private String comment;
        private String ipaddress;
        private Date date;
        private Comment comments;

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

        public Builder comments(Comment value)
        {
            this.comments = value;
            return this;
        }

        public Response build()
        {
            return new Response(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Response response = (Response) o;

        return ipaddress != null ? ipaddress.equals(response.ipaddress) : response.ipaddress == null;
    }

    @Override
    public int hashCode() {
        return ipaddress != null ? ipaddress.hashCode() : 0;
    }
}
