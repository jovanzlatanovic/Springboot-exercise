package com.jovan.vezba.controller;

import com.jovan.vezba.model.LiveStream;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/streams")
public class LiveStreamController {
    // GET REQUEST localhost:8080/streams
    @GetMapping
    public List<LiveStream> findAll() {
        return null;
    }
}
