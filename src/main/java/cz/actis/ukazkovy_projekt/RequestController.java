package cz.actis.ukazkovy_projekt;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class RequestController {

    @GetMapping("/")
    public String index(){
        return "Hello world";
    }
}
