package com.jovan.vezba.controller;

import com.jovan.vezba.model.LiveStream;
import com.jovan.vezba.repository.LiveStreamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/streams")
public class LiveStreamController {
    private final LiveStreamRepository repository;

    @Autowired // Autowired is implicit, I've explicitly defined it here as an example of implicit Controller Injection
    // This is the preferred way to inject the repository, field injection is usually not recommended because it makes unit testing more difficult, since
    // the unit testing would not be only limited to the controller, but the external factor of data storage (database) as well.
    public LiveStreamController(LiveStreamRepository repository) {
        this.repository = repository;
    }

    // GET REQUEST localhost:8080/streams
    @GetMapping
    public List<LiveStream> findAll() {
        return repository.findAll();
    }

    // GET REQUEST localhost:8080/streams/1234-1234-123456-123
    @GetMapping("/{id}")
    public LiveStream findById(@PathVariable String id) {
        return repository.findById(id);
    }

    // POST REQUEST localhost:8080/streams
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LiveStream create(@RequestBody LiveStream stream){
        return repository.create(stream);
    }
}
