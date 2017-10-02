package ua.rd;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ua.rd.domain.Tweet;
import ua.rd.repository.InMemTweetRepository;
import ua.rd.repository.TweetRepository;

/**
 * Created by Petro_Gordeichuk on 9/22/2017.
 */
@Configuration
public class RepoConfig {
    @Bean(initMethod = "init")
    public TweetRepository tweetRepository(){
        return new InMemTweetRepository();
    }

}
