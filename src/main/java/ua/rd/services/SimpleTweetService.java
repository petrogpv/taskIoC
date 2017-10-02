package ua.rd.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.rd.domain.Tweet;
import ua.rd.ioc.Context;
import ua.rd.repository.TweetRepository;

import java.util.function.Supplier;

class PrototypeTweetProxy implements TweetService {

    private Context context;
    private TweetService tweetService;

    public PrototypeTweetProxy(TweetService tweetService, Context context) {
        this.context = context;
    }

    @Override
    public Iterable<Tweet> allTweets() {
        return tweetService.allTweets();
    }

    @Override
    public TweetRepository getRepository() {
        return tweetService.getRepository();
    }

    @Override
    public Tweet newTweet() {
        return (Tweet) context.getBean("tweet");
    }
}
@Component
("tweetService")
public class SimpleTweetService implements TweetService {
    public SimpleTweetService() {
    }

    @Autowired
    private TweetRepository tweetRepository;
    @Autowired
    private Tweet tweet;

    public void setTweet(Tweet tweet) {
        this.tweet = tweet;
    }

    public SimpleTweetService(TweetRepository tweetRepository) {
        this.tweetRepository = tweetRepository;
    }

    @Override
    public Iterable<Tweet> allTweets() {
        return tweetRepository.allTweets();
    }

    @Override
    public TweetRepository getRepository() {
        return tweetRepository;
    }

    @Override
    public Tweet newTweet() {
        return tweet;
    }
}
