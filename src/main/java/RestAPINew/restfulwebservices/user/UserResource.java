package RestAPINew.restfulwebservices.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResource {
    private UserDaoService service;

    public UserResource(UserDaoService service){
        this.service=service;
    }
//GET/users
    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return service.findAll();

    }
    @GetMapping("/users/{id}")
    public  User retrieveAllUser(@PathVariable int id){
        return service.findOne(id);
    }
    //POST/users
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody  User user){
        User savedUser = service.save(user);
        URI location= ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();  // /users/4 => /users/{id}, /user.getId()
        return ResponseEntity.created(location).build();
    }

}