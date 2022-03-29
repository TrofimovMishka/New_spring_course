package aop;

import org.springframework.stereotype.Component;

@Component
public class UniLibrary extends AbstractLibrary {
//    @Override
//    public void getBook(){
//        System.out.println("We get book from uniLibrary");
//    }

//    public void getBook(Book book){
//        System.out.println("We get book " + book.getName() +" from uniLibrary");
//    }

    public void getBook() {
        System.out.println("We get book from uniLibrary");
    }

//    public String returnBook(){
//        System.out.println("We return book");
//        return "Ok, we return this book";
//    }

    public void returnBook() {
        System.out.println("We return book");
    }

    public void getMagazine() {
        System.out.println("We get Magazine from uniLibrary");
    }

    public void returnMagazine() {
        System.out.println("We return magazine");
    }

    public void addBook() {
        System.out.println("We add book to uniLibrary");
    }

    public void addMagazine() {
        System.out.println("We add Magazine to uniLibrary");
    }
}
