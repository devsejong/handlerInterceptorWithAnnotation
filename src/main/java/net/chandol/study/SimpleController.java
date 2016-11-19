package net.chandol.study;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

    @AccessLogging
    @GetMapping("/test1")
    public String simpleHandler1(){
        return "Called test1";
    }

    @GetMapping("/test2")
    public String simpleHandler2(){
        return "Called test2";
    }
}
