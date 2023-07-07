package rest.webservice.restfulwebservice.Users;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class User {
    private Integer id;

    @Size(min=2, message="Name should have atleast 2 characters")
    private String name;

    @Past(message = "Birth Date should be in past")
    private Date birthDate;
}
