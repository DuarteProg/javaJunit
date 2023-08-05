package com.example.projecttdd.controller;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// import java.util.ArrayList;
// import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.projecttdd.model.Product;
import com.example.projecttdd.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;

// import com.example.projecttdd.model.Product;

@WebMvcTest
public class ProductControllerTest {

    @Autowired
    private ProductController productController;

    @MockBean
    private ProductService productService;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        // execute before all tests
        this.mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
    }

    @Test
    public void should_return_status_200_when_calls_get_all() throws Exception {

        List<Product> products = new ArrayList<Product>();
        var requestBuilder = MockMvcRequestBuilders.get("/api/products");
        when(this.productService.getAll()).thenReturn(products);

        this.mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void should_return_product_by_id() throws Exception {

        Product product = new Product();
        product.setId(2l);
        product.setName("Lucas");
        product.setAmount(10);

        Optional<Product> optProduct = Optional.of(product);

        var requestBuilder = MockMvcRequestBuilders.get("/api/products/2");
        when(this.productService.getById(2l)).thenReturn(optProduct);

        this.mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(2l));

    }

    @Test
    public void should_add_the_product() throws Exception {

        Product product = new Product();
        product.setName("Lucas");
        product.setAmount(10);

        String json = new ObjectMapper().writeValueAsString(product);

        var requestBuilder = MockMvcRequestBuilders.post("/api/products")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON);

        product.setId(1l);

        when(this.productService.addProduct(product)).thenReturn(product);

        this.mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isCreated());

    }

}
