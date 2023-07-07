package rest.webservice.restfulwebservice.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public MappingJacksonValue filtering(){
        ExampleBean exampleBean = new ExampleBean("val1","val2","val3");
        MappingJacksonValue mapping = new MappingJacksonValue(exampleBean);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field3");
        FilterProvider filters = new SimpleFilterProvider().addFilter("ExampleBeanFilter", filter);
        mapping.setFilters(filters);
        return mapping;
    }

    @GetMapping("/filtering-list")
    public MappingJacksonValue filteringList(){
        List<ExampleBean> exampleBeanList =  Arrays.asList(new ExampleBean("val1", "val2", "val3"),
                new ExampleBean("val12", "val22", "val32"));

        MappingJacksonValue mapping = new MappingJacksonValue(exampleBeanList);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2", "field3");
        FilterProvider filters = new SimpleFilterProvider().addFilter("ExampleBeanFilter", filter);
        mapping.setFilters(filters);
        return mapping;
    }

}
