package com.noobsmoke.exercise;

import com.noobsmoke.MyTestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;


public class ProductServiceTest extends MyTestUtils {

    private ProductRepository productRepository;

    private ProductService underTest;


    @BeforeEach
    void setUp() {
        productRepository = mock(ProductRepository.class);
        this.underTest = new ProductService(productRepository);
    }

    @Test
    void shouldGetAllProducts() {
        // given
        List<Product> allProducts = getProductsForTest();
        when(productRepository.findAll()).thenReturn(allProducts);

        // when
        List<ProductResponse> actualProducts = underTest.getAllProducts();

        // then
        actualProducts.forEach(System.out::println);
    }

    @Test
    void shouldGetProductById() {
        UUID id = UUID.randomUUID();
        Instant createdAt = Instant.now();
        Instant updatedAt = Instant.now().minusMillis(10000);
        Instant deletedAt = Instant.now().minusMillis(10001);
        Product product = new Product(
                id,
                "XBOX 360",
                "The best microsoft console",
                BigDecimal.TEN,
                "http://xboximage.jpeg",
                20,
                createdAt,
                updatedAt,
                deletedAt,
                false
        );
        ProductResponse productResponse
                = new ProductResponse(
                        id,
                "XBOX 360",
                "The best microsoft console",
                BigDecimal.TEN,
                "http://xboximage.jpeg",
                20,
                createdAt,
                updatedAt,
                deletedAt
        );


        when(productRepository.findById(id)).thenReturn(Optional.of(product));

        ProductResponse actualProductResponse
                = underTest.getProductById(id);

        assertThat(actualProductResponse).isEqualTo(productResponse);
    }

    @Test
    void shouldThrowExceptionWhenGetProductByIdNotFound() {
        UUID id = UUID.randomUUID();
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> underTest.getProductById(id));

        assertEquals("product with id [" + id + "] not found", ex.getMessage());
    }

    @Test
    void shouldDeleteProductByID() {
        UUID id = UUID.randomUUID();
        when(productRepository.existsById(id)).thenReturn(true);
        underTest.deleteProductById(id);
    }

    @Test
    void shouldThrowExceptionWhenDeleteProductByIdNotFound() {
        UUID id = UUID.randomUUID();
        when(productRepository.existsById(id)).thenReturn(false);
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> underTest.deleteProductById(id));
        assertEquals("product with id [" + id + "] not found", ex.getMessage());
    }

    @Test
    void shouldSaveNewProduct() {
        String name = "Nintendo Switch";
        String description = "Nintendo Switch";
        BigDecimal price = BigDecimal.TEN;
        String imageUrl = "Nintendo Switch.jpeg";
        Integer stock = 100;

        NewProductRequest newProductRequest = new NewProductRequest(
                name,
                description,
                price,
                imageUrl,
                stock
        );

        UUID productID = underTest.saveNewProduct(newProductRequest);
        ArgumentCaptor<Product> captor = ArgumentCaptor.forClass(Product.class);
        verify(productRepository).save(captor.capture());

       assertEquals(productID, captor.getValue().getId());
       assertEquals(name, captor.getValue().getName());
       assertEquals(description, captor.getValue().getDescription());
       assertEquals(price, captor.getValue().getPrice());
       assertEquals(imageUrl, captor.getValue().getImageUrl());
       assertEquals(stock, captor.getValue().getStockLevel());
    }

    @Test
    void shouldUpdateProduct() {
        Product originalProduct =
                createNewProduct("XBOX", "Console", BigDecimal.TEN, "xbox.jpeg", 20);
        UpdateProductRequest newProductRequest = new UpdateProductRequest(
                "Playstation 5",
                "Sony Console",
                BigDecimal.ONE,
                "ps5.jpeg",
                21,
                true
        );

        when(productRepository.findById(originalProduct.getId())).thenReturn(Optional.of(originalProduct));
        underTest.updateProduct(originalProduct.getId(), newProductRequest);
        ArgumentCaptor<Product> captor = ArgumentCaptor.forClass(Product.class);

        verify(productRepository).save(captor.capture());

        assertEquals(originalProduct.getId(), captor.getValue().getId());
        assertEquals(newProductRequest.name(), captor.getValue().getName());
        assertEquals(newProductRequest.description(), captor.getValue().getDescription());
        assertEquals(newProductRequest.price(), captor.getValue().getPrice());
        assertEquals(newProductRequest.imageUrl(), captor.getValue().getImageUrl());
        assertEquals(newProductRequest.stockLevel(), captor.getValue().getStockLevel());
        assertEquals(newProductRequest.isPublished(), captor.getValue().getIsPublished());
    }

    @Test
    void shouldThrowExceptionWhenUpdateProductNotFound() {
        UUID id = UUID.randomUUID();
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> underTest.updateProduct(id, null));

        assertEquals("product with id [" + id + "] not found", ex.getMessage());
    }

    @Test
    void shouldReturnSameValuesWhenUpdateWithSameValues() {
        String name = "PC Gaming";
        String description =  "PC Master Race";
        BigDecimal price = BigDecimal.TEN;
        String imageUrl = "PC Master Race";
        Integer stock = 100;
        Product product = createNewProduct(name, description, price, imageUrl, stock);
        UpdateProductRequest updateProductRequest = new UpdateProductRequest(
                name,
                description,
                price,
                imageUrl,
                stock,
                false
        );

        when(productRepository.findById(product.getId())).thenReturn(Optional.of(product));
        underTest.updateProduct(product.getId(), updateProductRequest);
        ArgumentCaptor<Product> captor = ArgumentCaptor.forClass(Product.class);
        verify(productRepository).save(captor.capture());

        assertEquals(product.getId(), captor.getValue().getId());
        assertEquals(name, captor.getValue().getName());
        assertEquals(description, captor.getValue().getDescription());
        assertEquals(price, captor.getValue().getPrice());
        assertEquals(imageUrl, captor.getValue().getImageUrl());
        assertEquals(stock, captor.getValue().getStockLevel());
        assertEquals(updateProductRequest.isPublished(), captor.getValue().getIsPublished());

    }


    private Product createNewProduct(String name, String description, BigDecimal price, String imageUrl, Integer stock ) {
        UUID id = UUID.randomUUID();
        Instant createdAt = Instant.now();
        Instant updatedAt = Instant.now().minusMillis(10000);
        Instant deletedAt = Instant.now().minusMillis(10001);
        return new Product(
                id,
                name,
                description,
                price,
                imageUrl,
                stock,
                createdAt,
                updatedAt,
                deletedAt,
                false
        );
    }

}
