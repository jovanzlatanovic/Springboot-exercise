package com.jovan.vezba.model;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

public record LiveStream(
        @NotEmpty
        String id,
        @NotEmpty
        String title,
        @NotEmpty
        String description,
        @NotEmpty
        String url,
        LocalDateTime startDate,
        LocalDateTime endDate) { }
