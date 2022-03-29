package aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect  // Чтобы это сработало необходимо добавить AspectJ Weaver через maven например нуженн именно jar file
// и нобходимо добавить их в проект file/projectStructure/libraries/+/ выбрать jar file/apply/ok
public class LogginAspect {

    //Pointcut 1)
    //    @Before("execution(public void aop.UniLibrary.getBook())") // pointCat - пишем перед каким методом выполнить beforeGetBookAdvice
//    public void beforeGetBookAdvice(){
//        System.out.println("beforeGetBookAdvice : try get book");
//    }

//    //Pointcut 2)
//    @Before("execution(public void getBook())")
//    public void beforeGetBookAdvice() {
//        System.out.println("beforeGetBookAdvice : try get book");
//    }

//    //Pointcut 3)
//    @Before("execution(public void get*())")
//    public void beforeGetBookAdvice(){
//        System.out.println("beforeGetBookAdvice : try get book");
//    }
    //Pointcut 4)
//    @Before("execution(public void getBook(String))") // only String parameter
//    public void beforeGetBookAdvice() {
//        System.out.println("beforeGetBookAdvice : try get book");
//    }
    //Pointcut 5)
//    @Before("execution(public void getBook(*))") // all type of 1 parameter are OK
//    public void beforeGetBookAdvice() {
//        System.out.println("beforeGetBookAdvice : try get book");
//    }

    //    //Pointcut 6)
//    @Before("execution(public void getBook(..))") // all type of all count parameters are OK
//    public void beforeGetBookAdvice() {
//        System.out.println("beforeGetBookAdvice : try get book");
//    }
    //Pointcut 7)
    @Before("execution(public void getBook(aop.Book))") // if we have parameter a type of class. Put full name!!!
    public void beforeGetBookAdvice() {
        System.out.println("beforeGetBookAdvice : try get book");
    }
//
//
//    @Before("execution(public * returnBook())") // use "*" for all return type
//    public void beforeReturnBookAdvice(){
//        System.out.println("beforeReturnBookAdvice : try return book");
//    }
}
