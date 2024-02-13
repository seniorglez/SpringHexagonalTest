package com.seniorglez.demo.domain.service;

import com.seniorglez.demo.domain.model.Price;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceService {
    public List<Price> findPricesBy(Integer brandId, Integer productId, LocalDateTime applyDate);
}
