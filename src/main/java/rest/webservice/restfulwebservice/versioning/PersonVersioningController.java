package rest.webservice.restfulwebservice.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {


    @GetMapping("/v1/person")
    public PersonV1 personV1(){
        return new PersonV1("Aisha Amin");
    }

    @GetMapping("/v2/person")
    public PersonV2 personV2(){
        return new PersonV2(new Name("Aisha","Amin"));
    }

    @GetMapping(value ="/person",params = "version=1")
    public PersonV1 paramV1(){
        return new PersonV1("Aisha Amin");
    }

    @GetMapping(value ="/person",params = "version=2")
    public PersonV2 paramV2(){
        return new PersonV2(new Name("Aisha","Amin"));
    }

    @GetMapping(value ="/person/header",headers = "X-API-VERSION=1")
    public PersonV1 headerV1(){
        return new PersonV1("Aisha Amin");
    }

    @GetMapping(value ="/person/header",headers = "X-API-VERSION=2")
    public PersonV2 headerV2(){
        return new PersonV2(new Name("Aisha","Amin"));
    }

    @GetMapping(value ="/person/accept",produces = "application/vnd.company.app-v1+json")
    public PersonV1 producesV1(){
        return new PersonV1("Aisha Amin");
    }

    @GetMapping(value ="/person/accept",produces = "application/vnd.company.app-v2+json")
    public PersonV2 producesV2(){
        return new PersonV2(new Name("Aisha","Amin"));
    }
}
