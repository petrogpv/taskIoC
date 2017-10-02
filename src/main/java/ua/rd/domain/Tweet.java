package ua.rd.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Tweet {
    private Long tweetId;
    private String txt;
    private User user;
    private Date date;
    private TweetInfo tweetInfo;

    public Tweet() {
    }

    public Tweet(User user) {
        this.user = user;
    }

    public Tweet(String txt, User user) {
        this.txt = txt;
        this.user = user;
    }

    public Tweet(String txt, User user, TweetInfo tweetInfo) {
        this.txt = txt;
        this.user = user;
        this.tweetInfo = tweetInfo;

    }

    public Long getTweetId() {
        return tweetId;
    }

    public void setTweetId(Long tweetId) {
        this.tweetId = tweetId;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tweet tweet = (Tweet) o;

        if (!tweetInfo.equals(tweet.tweetInfo)) return false;
        if (tweetId != null ? !tweetId.equals(tweet.tweetId) : tweet.tweetId != null) return false;
        if (txt != null ? !txt.equals(tweet.txt) : tweet.txt != null) return false;
        return user != null ? user.equals(tweet.user) : tweet.user == null;

    }

    @Override
    public int hashCode() {
        int result = tweetId != null ? tweetId.hashCode() : 0;
        result = 31 * result + (txt != null ? txt.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (tweetInfo != null ? tweetInfo.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "tweetId=" + tweetId +
                ", txt='" + txt + '\'' +
                ", user=" + user +
                ", date=" + date +
                ", tweetInfo=" + tweetInfo +
                '}';
    }
}
