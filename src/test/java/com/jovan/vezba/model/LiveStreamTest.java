package com.jovan.vezba.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

public class LiveStreamTest {
    @Test
    @DisplayName("Test creating new mutable livestream")
    void createNewMutableLiveStream() {
        MutableLiveStream stream = new MutableLiveStream();
        stream.setId(UUID.randomUUID().toString());
        stream.setTitle("Test stream");
        stream.setDescription("Description of the test stream");
        stream.setUrl("https://twitch.tv/user");
        stream.setStartDate(LocalDateTime.of(2020, 1, 2, 3, 4));
        stream.setEndDate(LocalDateTime.of(2020, 1, 3, 6, 2));

        Assertions.assertNotNull(stream);
        Assertions.assertEquals("Test stream", stream.getTitle());
    }

    @Test
    @DisplayName("Test creating new immutable livestream")
    void createNewImmutableLiveStream() {
        ImmutableLiveStream stream = new ImmutableLiveStream(
                UUID.randomUUID().toString(),
                "Test stream",
                "Description of the test stream",
                "https://twitch.tv/user",
                LocalDateTime.of(2020, 1, 2, 3, 4),
                LocalDateTime.of(2020, 1, 3, 6, 2)
                );

        Assertions.assertNotNull(stream);
        Assertions.assertEquals("Test stream", stream.getTitle());
    }

    @Test
    @DisplayName("Test creating a new record livestream")
    void createNewRecordLiveStream() {
        LiveStream stream = new LiveStream(
                UUID.randomUUID().toString(),
                "Test stream",
                "Description of the test stream",
                "https://twitch.tv/user",
                LocalDateTime.of(2020, 1, 2, 3, 4),
                LocalDateTime.of(2020, 1, 3, 6, 2)
        );

        Assertions.assertNotNull(stream);

        Assertions.assertTrue(stream.getClass().isRecord());
        Assertions.assertEquals(6, stream.getClass().getRecordComponents().length);
        Assertions.assertEquals("Test stream", stream.title());
    }
}
