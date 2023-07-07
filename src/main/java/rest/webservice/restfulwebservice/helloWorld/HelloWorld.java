package rest.webservice.restfulwebservice.helloWorld;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HelloWorld {
    private String message;

    public HelloWorld(String message) {
        this.message = message;
    }
}
