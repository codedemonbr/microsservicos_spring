package com.codedmonbr.book_service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Foo-bar Endpoint")
@RestController
@RequestMapping("book-service")
public class FoobarController {
    private Logger logger = LoggerFactory.getLogger(FoobarController.class);

    @GetMapping("/foo-bar")
    // @Retry(name= "default")
    // @Retry(name= "foo-bar")
    // @Retry(name="foo-bar", fallbackMethod = "fallbackMethod")
    // @CircuitBreaker(name="default", fallbackMethod = "fallbackMethod")
    @RateLimiter(name = "default")
    public String fooBar() {
        logger.info("Request to foo-bar is received!");
        // var response = new
        // RestTemplate().getForEntity("http://localhost:8080/foo-bar", String.class);
        //
        // return response.getBody();
        return "Foo bar!!!";
    }

    public String fallbackMethod(Exception ex) {
        return "fallbackMethod full-bar!!!";
    }
}
