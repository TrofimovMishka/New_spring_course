package aop;

import org.springframework.stereotype.Component;

@Component
public class UniLibrary extends AbstractLibrary{
//    @Override
//    public void getBook(){
//        System.out.println("We get book from uniLibrary");
//    }

//    public void getBook(Book book){
//        System.out.println("We get book " + book.getName() +" from uniLibrary");
//    }

    public void getBook(){
        System.out.println("We get book from uniLibrary");
    }

    public String returnBook(){
        System.out.println("We return book");
        return "Ok, we return this book";
    }

    public void getMagazine(){
        System.out.println("We get Magazine from uniLibrary");
    }
}
