package RestAPINew.restfulwebservices.helloworld;

import RestAPINew.restfulwebservices.user.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoService {
    //to implement , to retrieve details and update details
    //Now here the we are going to create some static data which is going to interact with the DAO service and the data is static and stored in the H2 base.
    // JPA/Hibernate  > Database
    //UserDaoService > Static List
    // public List<User> findAll(){
    //public User save(User user){
    //public User findOne(int id){
    public static List<User> users=new ArrayList<>();
    static{
        users.add(new User(1,"smk", LocalDate.now().minusYears(30)));
        users.add(new User(2,"Dhruva", LocalDate.now().minusYears(30)));
        users.add(new User(3,"Ajay", LocalDate.now().minusYears(30)));
    }
    public List<User> findAll(){
        return users;
    }
}
