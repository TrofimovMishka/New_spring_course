package spring_introduction;

public class Dog implements Pet{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void say(){
        System.out.println("Hau hau");
    }

    public void init(){
        System.out.println("Class Dog : init method");
    }

    public void destroy(){
        System.out.println("Class dog : destroy");
    }
}
