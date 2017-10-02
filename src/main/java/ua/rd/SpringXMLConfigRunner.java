package ua.rd;

import org.springframework.aop.framework.Advised;
import org.springframework.aop.support.AopUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.rd.ioc.AppContext;
import ua.rd.ioc.Benchmark;
import ua.rd.repository.TweetRepository;
import ua.rd.services.TweetService;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class SpringXMLConfigRunner {
    public static void main(String[] args) {

//        ConfigurableApplicationContext repoContext
//                = new ClassPathXmlApplicationContext("repoContext.xml");
//
//        ConfigurableApplicationContext serviceContext
//                = new ClassPathXmlApplicationContext(new String[]{"serviceContext.xml"},repoContext);

        ApplicationContext serviceContext= new ClassPathXmlApplicationContext("serviceContext.xml");

//        System.out.println(
//                Arrays.toString(repoContext.getBeanDefinitionNames()));

        System.out.println(
                Arrays.toString(serviceContext.getBeanDefinitionNames()));


        TweetService tweetService = (TweetService) serviceContext.getBean("tweetService");
        System.out.println(tweetService.allTweets());

        System.out.println(
                tweetService.newTweet() == tweetService.newTweet()
        );

        TweetRepository tweetRepository = tweetService.getRepository();
        tweetRepository = (TweetRepository)createBenchmarkProxy(tweetRepository);
        System.out.println("tweetRepository class: " + tweetRepository.getClass());

        System.out.println(tweetRepository.methodToBenchmark("String"));
        System.out.println(tweetRepository.methodToBenchmark2("String2"));

//        serviceContext.close();
//        repoContext.close();
    }


        static Object createBenchmarkProxy(Object bean) {
            Class<?> beanType = bean.getClass();
            Object genuineBean = bean;
            return   Proxy.newProxyInstance(beanType.getClassLoader(),
                    beanType.getInterfaces(),
                    (proxy, method, args) -> {
                        Method methodImplemented =  beanType
                                .getMethod(method.getName(), method.getParameterTypes());
                        if(methodImplemented.isAnnotationPresent(Benchmark.class)
                                && checkBenchmarkAnnotationIsActive(methodImplemented)
                                ){
                            Long start = System.currentTimeMillis();
                            Object result = method.invoke(genuineBean, args);
                            Long stop = System.currentTimeMillis();
                            System.out.println("Duration: " + (stop-start));
                            return result;
                        } else{
                            return method.invoke(genuineBean, args);
                        }
                    });
        }

    static boolean checkBenchmarkAnnotationIsActive(Method method) {
        Benchmark benchmark = method.getAnnotation(Benchmark.class);
        return benchmark.enabled();
    }

    @SuppressWarnings({"unchecked"})
    protected static <T> T getTargetObject(Object proxy) throws Exception {
        if (AopUtils.isJdkDynamicProxy(proxy)) {
            System.out.println("Flag1");
            return (T) ((Advised)proxy).getTargetSource().getTarget();
        } else {
            return (T) proxy; // expected to be cglib proxy then, which is simply a specialized class
        }
    }
}
