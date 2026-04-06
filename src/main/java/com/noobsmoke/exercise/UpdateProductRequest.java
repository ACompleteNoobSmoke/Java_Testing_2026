package com.noobsmoke.exercise;

import java.math.BigDecimal;

public record UpdateProductRequest(
        String name,
        String description,
        BigDecimal price,
        String imageUrl,
        Integer stockLevel,
        Boolean isPublished
) {}
