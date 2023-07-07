package rest.webservice.restfulwebservice.Users;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDao {

    private static List<User> users = new ArrayList<>();

    private static int usersCount = 0;

    static {
        users.add(new User(++usersCount,"Aisha", new Date()));
                //LocalDate.now().minusYears(20)));
        users.add(new User(++usersCount,"Hisham", new Date()));
        users.add(new User(++usersCount,"Amin", new Date()));
    }

    public List<User> findAll(){
        return users;
    }

    public User findUserById(int id){
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().orElse(null);
    }

    public User save(User user) {
        user.setId(++usersCount);
        users.add(user);
        return user;
    }

    public void deleteUserById(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        users.removeIf(predicate);
    }
}
