package com.naishaairlines.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @GetMapping("/_register")
    public ResponseEntity<String> testMyController(){
        log.info("Request received for /login");
        return new ResponseEntity<>("Hello", HttpStatus.OK);
    }

}
