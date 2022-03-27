package spring_introduction;

import org.springframework.context.annotation.*;

@Configuration
//@ComponentScan("spring_introduction") // auto scan - will found classes with @Component
@PropertySource("classpath:myApp.properties") // set property file
public class MyConfig { // Create class for configuration without xml file

    @Bean
    @Scope("singleton")
    public Pet catBean(){return new Cat();} //create new bean

    @Bean
    public Person personBean(){return new Person(catBean());} // DI


}
