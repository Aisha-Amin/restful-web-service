package rest.webservice.restfulwebservice.Users;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private UserDao userDao;

    public UserController(UserDao userDao){
        this.userDao = userDao;
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userDao.findAll();
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable int id){
        return userDao.findUserById(id);
    }

    @PostMapping("/users")
    public void createUser(@RequestBody User user){
         userDao.save(user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUserById(@PathVariable int id){
        userDao.deleteUserById(id);
    }
}
