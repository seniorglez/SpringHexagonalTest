package com.seniorglez.demo.infraestructure.api.v1.price;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PriceControllerEndToEndTest {

    @Autowired
    private MockMvc mockMvc;

    @ParameterizedTest
    @CsvSource({
            "2020-06-14 10:00:00, 35455, 1, 35.5",
            "2020-06-14 16:00:00, 35455, 1, 25.45",
            "2020-06-14 21:00:00, 35455, 1, 35.5",
            "2020-06-15 10:00:00, 35455, 1, 30.5",
            "2020-06-16 21:00:00, 35455, 1, 38.95"
    })
    void performGetPriceRequest(String dateTime, int productId, int brandId, double expectedPrice) throws Exception {
        mockMvc.perform(get("/price")
                        .param("applicationDate", dateTime)
                        .param("productId", String.valueOf(productId))
                        .param("brandId", String.valueOf(brandId))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.amount").value(expectedPrice));
    }

    @Test
    public void whenResourceNotFound_thenNotFound() throws Exception {
        mockMvc.perform(get("/price")
                        .param("productId", "9999")
                        .param("brandId", "1")
                        .param("applicationDate", "2020-06-14 10:00:00"))
                .andExpect(status().isNotFound());
    }


    @Test
    public void whenIncorrectProductIdParameterTypeThenBadRequest() throws Exception {
        mockMvc.perform(get("/price")
                        .param("productId", "notAnInteger")
                        .param("brandId", "1")
                        .param("applicationDate", "2020-06-14 10:00:00"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void whenIncorrectBrandIdParameterTypeThenBadRequest() throws Exception {
        mockMvc.perform(get("/price")
                        .param("productId", "35455")
                        .param("brandId", "notAnInteger")
                        .param("applicationDate", "2020-06-14 10:00:00"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void whenIncorrectDateParameterTypeThenBadRequest() throws Exception {
        mockMvc.perform(get("/price")
                        .param("productId", "35455")
                        .param("brandId", "1")
                        .param("applicationDate", "notADate"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void whenMissingProductIdThenBadRequest() throws Exception {
        mockMvc.perform(get("/price")
                        .param("brandId", "1")
                        .param("applicationDate", "2020-06-14 10:00:00"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void whenMissingBrandIdThenBadRequest() throws Exception {
        mockMvc.perform(get("/price")
                        .param("productId", "35455")
                        .param("applicationDate", "2020-06-14 10:00:00"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void whenMissingDateThenBadRequest() throws Exception {
        mockMvc.perform(get("/price")
                        .param("brandId", "1")
                        .param("productId", "35455"))
                .andExpect(status().isBadRequest());
    }

}