package ua.rd.repository;

import ua.rd.domain.Tweet;
import ua.rd.ioc.Benchmark;

import java.util.Collection;
import java.util.Optional;

public interface TweetRepository {

    Iterable<Tweet> allTweets();

    Optional<Tweet> getTweet(Long id);

    Tweet save(Tweet tweet);

}