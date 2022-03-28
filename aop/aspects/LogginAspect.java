package aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect  // Чтобы это сработало необходимо добавить AspectJ Weaver через maven например нуженн именно jar file
         // и нобходимо добавить их в проект file/projectStructure/libraries/+/ выбрать jar file/apply/ok
public class LogginAspect {

    @Before("execution(public void getBook())") // pointCat - пишем перед каким методом выполнить beforeGetBookAdvice
    public void beforeGetBookAdvice(){
        System.out.println("beforeGetBookAdvice : try get book");
    }
}
