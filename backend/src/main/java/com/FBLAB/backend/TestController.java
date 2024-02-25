package com.FBLAB.backend;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequiredArgsConstructor
public class TestController {

    @GetMapping("/api/hello")
    public HashMap hello() {
        HashMap result = new HashMap<>();
        result.put("message", "Say Hello~");

        return result;
    }
}
