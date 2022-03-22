package com.jovan.vezba.repository;

import com.jovan.vezba.model.LiveStream;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class LiveStreamRepository {
    List<LiveStream> streams = new ArrayList<>();

    public LiveStreamRepository() {
        streams.add(new LiveStream(
                UUID.randomUUID().toString(),
                "Repository livestream test",
                "Description of the livestream",
                "http://twitch.tv",
                LocalDateTime.of(2022, 2, 2, 2, 2),
                LocalDateTime.of(2022, 2, 2, 3, 2)
        ));
    }

    public List<LiveStream> findAll() {
        return streams;
    }

    public LiveStream findById(String id) {
        return streams.stream().filter(stream -> stream.id().equals(id)).findFirst().orElse(null);
    }

    public LiveStream create(LiveStream stream) {
        streams.add(stream);
        return stream;
    }

    public void update(LiveStream stream, String id) {
        LiveStream existing = streams.stream().filter(s -> s.id().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Stream not found by id: '" + id + "'"));
        int i = streams.indexOf(existing);
        streams.set(i, stream);
    }

    public void delete(String id) {
        streams.removeIf(stream -> stream.id().equals(id));
    }
}
