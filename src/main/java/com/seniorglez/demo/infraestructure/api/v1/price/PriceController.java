package com.seniorglez.demo.infraestructure.api.v1.price;

import com.seniorglez.demo.application.useCase.getPrice.GetPriceUseCase;
import com.seniorglez.demo.application.useCase.getPrice.GetPriceUseCaseInput;
import com.seniorglez.demo.domain.model.Price;
import com.seniorglez.demo.infraestructure.api.v1.price.response.PriceResponse;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class PriceController {

    private final GetPriceUseCase getPriceUseCase;

    public PriceController(GetPriceUseCase getPriceUseCase) {
        this.getPriceUseCase = getPriceUseCase;
    }

    @GetMapping("/price")
    public PriceResponse getPrice(
            @RequestParam(required = true) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime applicationDate,
            @RequestParam(required = true) int productId,
            @RequestParam(required = true) int brandId
    ) {
        GetPriceUseCaseInput input = new GetPriceUseCaseInput(
                applicationDate,
                productId,
                brandId
        );
        Price price = getPriceUseCase.execute(input);
        return new PriceResponse(price);
    }
}
