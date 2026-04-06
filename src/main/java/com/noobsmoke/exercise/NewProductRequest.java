package com.noobsmoke.exercise;

import java.math.BigDecimal;

public record NewProductRequest(
        String name,
        String description,
        BigDecimal price,
        String imageUrl,
        Integer stockLevel
) {}
