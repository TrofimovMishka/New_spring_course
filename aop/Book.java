package aop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Book {
    @Value("Bimbo and Bamboo")
    private String name;

    @Value("F.M.Dostoevski")
    private String author;

    @Value("1866")
    private int yearsOfPublication;

    public String getAuthor() {
        return author;
    }

    public int getYearOfPublication() {
        return yearsOfPublication;
    }

    public String getName() {
        return name;
    }
}
