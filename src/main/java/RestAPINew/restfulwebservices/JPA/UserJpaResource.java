package RestAPINew.restfulwebservices.JPA;

import RestAPINew.restfulwebservices.user.User;
import RestAPINew.restfulwebservices.user.UserDaoService;
import RestAPINew.restfulwebservices.user.UserNotFoundException;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserJpaResource {
    private UserRepository repository;

    public UserJpaResource(UserRepository repository){
        this.repository=repository;
    }
//GET/users
    @GetMapping("/jpa/users")
    public List<User> retrieveAllUsers(){
        return repository.findAll();

    }
    //Entity model->wrap the user in entity model

    @GetMapping("/jpa/users/{id}")
    public EntityModel<User> retrieveUser(@PathVariable int id){
        Optional<User> user= repository.findById(id);
        if(user.isEmpty()){
            throw new UserNotFoundException("id : "+id);
        }
        EntityModel<User> entityModel=EntityModel.of(user.get());
        WebMvcLinkBuilder link =linkTo(methodOn(this.getClass()).retrieveAllUsers());
        entityModel.add(link.withRel("all-users"));
        return entityModel;
    }
    //POST/users
    @PostMapping("/jpa/users")
    public ResponseEntity<User> createUser(@Valid  @RequestBody  User user){
        User savedUser = repository.save(user);
        URI location= ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/jpa/{id}")
                .buildAndExpand(savedUser.getId()).toUri();  // /users/4 => /users/{id}, /user.getId()
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/jpa/users/{id}")
    public  void deleteUser(@PathVariable int id){
        repository.deleteById(id);

    }

}