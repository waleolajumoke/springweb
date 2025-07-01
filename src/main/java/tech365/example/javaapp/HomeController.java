package tech365.example.javaapp;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController

public class HomeController{
    @GetMapping("/")
    public String Index(){
        return "welcome to Tech365";
    }
}