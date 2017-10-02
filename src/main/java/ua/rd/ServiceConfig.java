package ua.rd;

import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import ua.rd.domain.Tweet;
import ua.rd.repository.TweetRepository;
import ua.rd.services.SimpleTweetService;
import ua.rd.services.TweetService;

import javax.annotation.Resource;

/**
 * Created by Petro_Gordeichuk on 9/22/2017.
 */
@Configuration
//@Import(RepoConfig.class)
public class ServiceConfig {
    @Autowired
    TweetRepository tweetRepository;

    @Bean
    @Scope("singleton")
    public Tweet tweet(){
        return new Tweet();
    }
    @Bean
    public TweetService tweetService(){
        SimpleTweetService simpleTweetService = new SimpleTweetService(tweetRepository){
            @Override
            public Tweet newTweet() {
                return tweet();
            }
        };
        return  simpleTweetService;
    }
}
