package ua.rd.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Petro_Gordeichuk on 10/2/2017.
 */
public class TweetInfo {
    private Tweet sourceTweet;
    private List<User> mentions = new ArrayList<>();
    private List<String> replies = new ArrayList<>();
    private int likesCount;
    private int reTweetsCount;



    public Tweet getSourceTweet() {
        return sourceTweet;
    }

    public void setSourceTweet(Tweet sourceTweet) {
        this.sourceTweet = sourceTweet;
    }

    public List<User> getMentions() {
        return mentions;
    }

    public void setMentions(List<User> mentions) {
        this.mentions = mentions;
    }

    public int getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(int likesCount) {
        this.likesCount = likesCount;
    }

    public int getReTweetsCount() {
        return reTweetsCount;
    }

    public void setReTweetsCount(int reTweetsCount) {
        this.reTweetsCount = reTweetsCount;
    }

    public List<String> getReplies() {
        return replies;
    }

    public void setReplies(List<String> replies) {
        this.replies = replies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TweetInfo tweetInfo = (TweetInfo) o;

        if (likesCount != tweetInfo.likesCount) return false;
        if (reTweetsCount != tweetInfo.reTweetsCount) return false;
        if (sourceTweet != null ? !sourceTweet.equals(tweetInfo.sourceTweet) : tweetInfo.sourceTweet != null)
            return false;
        if (mentions != null ? !mentions.equals(tweetInfo.mentions) : tweetInfo.mentions != null) return false;
        return replies.equals(tweetInfo.replies);
    }

    @Override
    public int hashCode() {
        int result = sourceTweet != null ? sourceTweet.hashCode() : 0;
        result = 31 * result + (mentions != null ? mentions.hashCode() : 0);
        result = 31 * result + likesCount;
        result = 31 * result + reTweetsCount;
        result = 31 * result + replies.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "TweetInfo{" +
                "sourceTweet=" + sourceTweet +
                ", mentions=" + mentions +
                ", likesCount=" + likesCount +
                ", reTweetsCount=" + reTweetsCount +
                ", replies=" + replies +
                '}';
    }
}
