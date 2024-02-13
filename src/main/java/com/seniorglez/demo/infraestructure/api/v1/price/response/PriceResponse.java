package com.seniorglez.demo.infraestructure.api.v1.price.response;

import com.seniorglez.demo.domain.model.Price;

import java.time.LocalDateTime;

import static java.util.Objects.nonNull;

public class PriceResponse {

    private Integer brandId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Integer priceList;
    private Integer productId;
    private Float amount;

    public PriceResponse(Price price) {
       if(nonNull(price)) {
           this.brandId = price.getBrandId();
           this.startDate = price.getStartDate();
           this.endDate = price.getEndDate();
           this.priceList = price.getPriceList();
           this.productId = price.getProductId();
           this.amount = price.getAmount();
       }
    }

    public Integer getBrandId() {
        return brandId;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public Integer getPriceList() {
        return priceList;
    }

    public Integer getProductId() {
        return productId;
    }

    public Float getAmount() {
        return amount;
    }

}
