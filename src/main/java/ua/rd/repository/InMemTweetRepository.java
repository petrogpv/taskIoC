package ua.rd.repository;

import org.springframework.stereotype.Component;
import ua.rd.domain.Tweet;
import ua.rd.ioc.Benchmark;

import javax.annotation.PostConstruct;
import java.util.*;

@Component
//        ("tweetRepository")
public class InMemTweetRepository implements TweetRepository {
    private static Long idCounter = Long.valueOf(0);
    private Map<Long, Tweet> tweets = new HashMap<>() ;

    public InMemTweetRepository() {
    }

    @Override
    public Collection<Tweet> allTweets() {
        return tweets.values();

    }

    @Override
    public Optional<Tweet> getTweet(Long id) {
        return Optional.ofNullable(tweets.get(id));
    }

    @Override
    public Tweet save(Tweet tweet) {
        if (tweet.getTweetId() == null) {
            tweet.setTweetId(idCounter++);
        }
        put(tweet);
        return tweet;
    }

    private Tweet put(Tweet tweet) {
        return tweets.put(tweet.getTweetId(), tweet);
    }
}
