package rest.webservice.restfulwebservice.Users;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="user_details")
public class User {
    @Id
    @GeneratedValue
    private Integer id;

    @Size(min=2, message="Name should have atleast 2 characters")
    private String name;

    @Past(message = "Birth Date should be in past")
    private Date birthDate;

    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Post> posts;

    public User(int id, String name, Date birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }
}
