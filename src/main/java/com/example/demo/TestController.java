package com.example.demo;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/foo")
    @PreAuthorize("hasAuthority('foo')")
    public String foo() {
        return "foo";
    }

    @GetMapping("/bar")
    @PreAuthorize("hasAuthority('bar')")
    public String bar() {
        return "bar";
    }
}
