package com.jovan.vezba.controller;

import com.jovan.vezba.model.LiveStream;
import com.jovan.vezba.repository.LiveStreamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    //@Valid annotation forces the check of constraints inside the model record (@NotEmpty)
    public LiveStream create(@Valid @RequestBody LiveStream stream){
        return repository.create(stream);
    }

    // PUT REQUEST localhost:8080/streams/1234-1234-123456-123
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody LiveStream stream, @PathVariable String id) {
        repository.update(stream, id);
    }

    // DELETE REQUEST localhost:8080/streams/1234-1234-123456-123
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        repository.delete(id);
    }
}
