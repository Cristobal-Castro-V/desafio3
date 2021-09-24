package desafio.devoptopus.desafio3.service.implementation;

import com.fasterxml.jackson.databind.ObjectMapper;
import desafio.devoptopus.desafio3.controller.ProductController;
import desafio.devoptopus.desafio3.document.Product;
import desafio.devoptopus.desafio3.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@WebMvcTest(ProductController.class)
class ProductServiceImplTest {

    @MockBean
    ProductRepository productRepository;

    @Autowired
    MockMvc mockMvc;

    ObjectMapper objectMapper;

    @BeforeEach
    void setup(){objectMapper = new ObjectMapper();}

    @Test
    void shouldDiscountByPalindrome() throws Exception{
        Product p1 = new Product();

        List<Product> productList = new ArrayList<>();

        p1.set_id("235ad63h7");
        p1.setId(101L);
        p1.setBrand("dsaasd");
        p1.setDescription("dsa");
        p1.setImage("image");
        p1.setPrice(32000);
        p1.setDiscount(16000);

        productList.add(p1);

        when(productRepository.findById(101L)).thenReturn(p1);


        verify(productRepository.findById(101L));

    }

}