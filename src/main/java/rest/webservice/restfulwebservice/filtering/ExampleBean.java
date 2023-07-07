package rest.webservice.restfulwebservice.filtering;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString

//@JsonIgnoreProperties("field1") // Class level filtering
public class ExampleBean {
    private String field1;

    @JsonIgnore
    private String field2;
    private String field3;
}
