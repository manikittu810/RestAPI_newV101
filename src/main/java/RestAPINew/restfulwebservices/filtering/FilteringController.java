package RestAPINew.restfulwebservices.filtering;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {
    @GetMapping("/filtering")
    public SomeBean filtering(){
        return new SomeBean("value1","value2","value3");
    }
    @GetMapping("/list-filtering")
    public List<SomeBean> Listfiltering(){
        return Arrays.asList(new SomeBean("value1","value2","value3"),
                new SomeBean("value4","value5","value6"));
    }
}