package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.presentation.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class Test {

    @PostMapping(value = "/test")
    public String testSend(@RequestBody String tests) {
        return "yes";
    }

}
