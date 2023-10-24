package RestAPINew.restfulwebservices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //This will make this controller a Rest controller
public class HelloWorldController {
    @GetMapping (path="/hello-world") //

    public String helloWorld(){
        return "HelloWorld";
    }
}
