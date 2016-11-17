package net.chandol.study;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

    @Auth("테스트입니다")
    @GetMapping("/test1")
    public void simpleHandler1(){
        //do nothing
    }

    @GetMapping("/test2")
    public void simpleHandler2(){
        //do nothing
    }
}
