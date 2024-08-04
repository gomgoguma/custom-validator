package com.example.validator.groupednotnull;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/grouped")
public class Controller {

    @PostMapping("")
    public String hello(@Validated @RequestBody ExampleDTO dto) {
        return dto.toString();
    }

}
