package RestAPINew.restfulwebservices.helloworld;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController //This will make this controller a Rest controller
public class HelloWorldController {
    private MessageSource messageSource;
    public HelloWorldController(MessageSource messageSource){
        this.messageSource=messageSource;
    }

    @GetMapping (path="/hello-world") //
    public String helloWorld(){
        return "HelloWorld";
    }
    @GetMapping (path="/hello-world-bean") //
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello world");
    }

    //path Parameters
// /users//{id}/todos/{id} => /users/1/todos/101 -> these variables are called path parameters
// /hello-world/path-variable/{name} -> create a simple helloWorld path variable url

    @GetMapping (path="/hello-world/path-variable/{name}") //
    public HelloWorldBean helloWorldBean(@PathVariable String name){
//        return new HelloWorldBean("Hello world ! " + name); or
        return new HelloWorldBean(String.format("Hello world !,%s ",name));
    }

    @GetMapping (path="/hello-world-internationalized") //
    public String HelloWorldController(){
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message",null,"Default Message",locale);
    }

}





