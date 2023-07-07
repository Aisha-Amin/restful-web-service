package rest.webservice.restfulwebservice.Users;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;

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
}
