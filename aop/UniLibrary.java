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
        System.out.println("----------------------------------------------------------------------------");
    }

    public String returnBook(){
        int a = 10 / 0;
        System.out.println("returnBook: We return book");
        return "Vojna i Mir";
    }

//    public void returnBook() {
//        System.out.println("We return book");
//        System.out.println("----------------------------------------------------------------------------");
//
//    }

    public void getMagazine() {
        System.out.println("We get Magazine from uniLibrary");
        System.out.println("----------------------------------------------------------------------------");

    }

    public void returnMagazine() {
        System.out.println("We return magazine");
        System.out.println("----------------------------------------------------------------------------");

    }

    public void addBook(String personName, Book book) {
        System.out.println("We add book to uniLibrary");
        System.out.println("----------------------------------------------------------------------------");

    }

    public void addMagazine() {
        System.out.println("We add Magazine to uniLibrary");
        System.out.println("----------------------------------------------------------------------------");

    }
}
