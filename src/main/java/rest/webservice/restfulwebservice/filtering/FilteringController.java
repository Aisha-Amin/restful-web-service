package rest.webservice.restfulwebservice.filtering;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public ExampleBean filtering(){
        return new ExampleBean("val1","val2","val3");
    }

    @GetMapping("/filtering-list")
    public List<ExampleBean> filteringList(){
        return Arrays.asList(new ExampleBean("val1", "val2", "val3"),
                new ExampleBean("val12", "val22", "val32"));
    }

}
