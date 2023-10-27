package RestAPINew.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {
    @GetMapping("/v1/person")
    public PersonV1 getFirstVersionOfPerson(){
    return new PersonV1("Bob Charlie");
            }
    @GetMapping("/v2/person")
    public PersonV2 getSecondVersionOfPerson(){
        return new PersonV2(new Name("Bob","Charlie"));
    }
//URI VERSION ENDS HERE

    @GetMapping(path="/person",params="version=1")
    public PersonV1 getFirstVersionOfPersonRequestParameter(){
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(path="/person",params = "version=2")
    public PersonV2 getSecondVersionOfPersonRequestParameter(){
        return new PersonV2(new Name("Bob","Charlie"));
    }

    //REQUEST PARAM VERSION ENDS HERE

    //HEADER VERSION STARTS HERE
    @GetMapping(path="/person/header",headers="X-API-VERSION=1")
    public PersonV1 getFirstVersionOfPersotRequesrHEADER(){
        return new PersonV1("Bob Charlie");
    }
    @GetMapping(path="/person/header",headers="X-API-VERSION=2")
    public PersonV2 getSecondVersionOfPersonRequestHEADER(){
        return new PersonV2(new Name("Bob","Charlie"));
    }

    //Media type versioning
    @GetMapping(path="/person/accept",produces="application/vnd.company.app-v1+json")
    public PersonV1 getFirstVersionOfPersotAcceptHEADER(){
        return new PersonV1("Bob Charlie");
    }
    @GetMapping(path="/person/accept",produces="application/vnd.company.app-v2+json")
    public PersonV2 getSecondVersionOfPersonAcceptHEADER(){
        return new PersonV2(new Name("Bob","Charlie"));
    }


}
