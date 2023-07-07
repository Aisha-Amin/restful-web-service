package rest.webservice.restfulwebservice.helloWorld;

import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    private MessageSource messageSource;

    public HelloWorldController(MessageSource messageSource){
        this.messageSource = messageSource;
    }

    @GetMapping("/hello-world")
    public HelloWorld helloWorld(){
        return new HelloWorld("Hello World");
    }

    @GetMapping("/hello-world/{name}")
    public HelloWorld helloWorld(@PathVariable String name){
        return new HelloWorld(String.format("Hello World, %s", name));
    }

}
