package domain;

import java.util.Date;

/**
 * Created by Grey on 5/30/2017.
 */
public class Reputation {
        private Date date;
        private int value;

    public Date getDate() {
        return date;
    }

    public int getValue() {
        return value;
    }

    private Reputation() {}

    public Reputation(Builder builder)
    {
        this.date = builder.date;
        this.value = builder.value;
    }

    public static class Builder
    {
        private Date date;
        private int value;

        public Builder date(Date value)
        {
            this.date = value;
            return this;
        }

        public Builder value(int v)
        {
            this.value = v;
            return this;
        }

        public Reputation build()
        {
            return new Reputation(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reputation that = (Reputation) o;

        if (value != that.value) return false;
        return date != null ? date.equals(that.date) : that.date == null;
    }

    @Override
    public int hashCode() {
        return date != null ? date.hashCode() : 0;
    }
}
