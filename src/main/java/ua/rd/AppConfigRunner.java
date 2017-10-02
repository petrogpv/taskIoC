package ua.rd;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import ua.rd.repository.TweetRepository;
import ua.rd.services.TweetService;

/**
 * Created by Petro_Gordeichuk on 9/22/2017.
 */
//@ComponentScan("ua.rd")
public class AppConfigRunner {
    public static void main(String[] args) {
       AnnotationConfigApplicationContext serviceConfig = new AnnotationConfigApplicationContext();
        AnnotationConfigApplicationContext repoConfig = new AnnotationConfigApplicationContext(RepoConfig.class);
       serviceConfig.setParent(repoConfig);
       serviceConfig.register(ServiceConfig.class);
       serviceConfig.refresh();

        TweetService service = (TweetService) serviceConfig.getBean("tweetService");
        TweetRepository tweetRepository = (TweetRepository) serviceConfig.getBean("tweetRepository");
        System.out.println(service.allTweets());
        System.out.println(tweetRepository.allTweets());
        System.out.println(service.newTweet() == service.newTweet());
    }
}
