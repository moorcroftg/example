package domain;

/**
 * Created by Grey on 5/30/2017.
 */
public class ContentFilter {
    private String contentCheck;
    private Comment comment;

    public String getContentCheck() {
        return contentCheck;
    }

    public Comment getComment() {
        return comment;
    }

    public ContentFilter() {
    }

    public ContentFilter(Builder builder)
    {
        this.contentCheck = builder.contentCheck;
        this.comment = builder.comment;
    }

    public static class Builder
    {
        private String contentCheck;
        private Comment comment;

        public Builder contentCheck(String value)
        {
            this.contentCheck = value;
            return this;
        }

        public Builder comment(Comment comment)
        {
            this.comment = comment;
            return this;
        }

        public ContentFilter build()
        {
            return new ContentFilter(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContentFilter that = (ContentFilter) o;

        return contentCheck != null ? contentCheck.equals(that.contentCheck) : that.contentCheck == null;
    }

    @Override
    public int hashCode() {
        return contentCheck != null ? contentCheck.hashCode() : 0;
    }
}
