package RestAPINew.restfulwebservices.JPA;

import RestAPINew.restfulwebservices.user.Post;
import RestAPINew.restfulwebservices.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Integer> {

}
