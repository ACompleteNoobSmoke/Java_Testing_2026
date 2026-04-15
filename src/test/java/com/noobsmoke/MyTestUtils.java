package com.noobsmoke;

import com.noobsmoke.exercise.Product;
import com.noobsmoke.exercise.ProductResponse;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;

public abstract class MyTestUtils {

    protected List<Product> getProductsForTest() {
        return List.of(
                new Product(UUID.randomUUID(), "Laptop", "Gaming laptop", new BigDecimal("1200.00"), "https://example.com/laptop.png", 15),
                new Product(UUID.randomUUID(), "Phone", "Smartphone with OLED display", new BigDecimal("899.99"), "https://example.com/phone.png", 25),
                new Product(UUID.randomUUID(), "Tablet", "10-inch Android tablet", new BigDecimal("299.99"), "https://example.com/tablet.png", 8),
                new Product(UUID.randomUUID(), "Monitor", "27-inch 4K monitor", new BigDecimal("399.99"), "https://example.com/monitor.png", 12),
                new Product(UUID.randomUUID(), "Keyboard", "Mechanical keyboard", new BigDecimal("129.99"), "https://example.com/keyboard.png", 18),
                new Product(UUID.randomUUID(), "Mouse", "Wireless mouse", new BigDecimal("49.99"), "https://example.com/mouse.png", 30),
                new Product(UUID.randomUUID(), "Headphones", "Noise cancelling headphones", new BigDecimal("199.99"), "https://example.com/headphones.png", 10),
                new Product(UUID.randomUUID(), "Speaker", "Bluetooth speaker", new BigDecimal("79.99"), "https://example.com/speaker.png", 22),
                new Product(UUID.randomUUID(), "Webcam", "1080p HD webcam", new BigDecimal("59.99"), "https://example.com/webcam.png", 5),
                new Product(UUID.randomUUID(), "Chair", "Ergonomic office chair", new BigDecimal("249.99"), "https://example.com/chair.png", 14)
        );
    }

    protected List<ProductResponse> getAllProductResponse(List<Product> productList) {
        return productList.stream().map(mapToResponse()).toList();
    }

    Function<Product, ProductResponse> mapToResponse() {
        return p -> new ProductResponse(
                p.getId(),
                p.getName(),
                p.getDescription(),
                p.getPrice(),
                p.getImageUrl(),
                p.getStockLevel(),
                p.getCreatedAt(),
                p.getUpdatedAt(),
                p.getDeletedAt()
        );
    }
}
