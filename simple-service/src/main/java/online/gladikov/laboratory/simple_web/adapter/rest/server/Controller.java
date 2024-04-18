package online.gladikov.laboratory.simple_web.controller;

import online.gladikov.laboratory.simple_web.dto.Params;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class Controller {


    @GetMapping("/hello")
    String sayHelloWithParams( Params params){
        return String.join (" ","Hello",params.one (),params.foo ());
    }

    @GetMapping("/bye")
    String sayBye( ){
        return String.join (" ","Bye");
    }
}
