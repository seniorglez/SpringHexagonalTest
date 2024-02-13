package com.seniorglez.demo.application.useCase.getPrice;

import java.time.LocalDateTime;

public class GetPriceUseCaseInput {

    private LocalDateTime applyDate;
    private Integer productId;
    private Integer brandId;

    public GetPriceUseCaseInput(LocalDateTime applyDate, Integer productId, Integer brandId) {
        this.applyDate = applyDate;
        this.productId = productId;
        this.brandId = brandId;
    }

    public LocalDateTime getApplyDate() {
        return applyDate;
    }

    public Integer getProductId() {
        return productId;
    }

    public Integer getBrandId() {
        return brandId;
    }
}
