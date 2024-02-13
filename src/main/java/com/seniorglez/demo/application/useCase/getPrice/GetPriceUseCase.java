package com.seniorglez.demo.application.useCase.getPrice;

import com.seniorglez.demo.application.Injectable;
import com.seniorglez.demo.domain.exception.NotFoundException;
import com.seniorglez.demo.domain.model.Price;
import com.seniorglez.demo.domain.service.PriceService;

import java.util.Comparator;
import java.util.List;

@Injectable
public class GetPriceUseCase {

    private final PriceService priceService;

    public GetPriceUseCase(PriceService priceService) {
        this.priceService = priceService;
    }

    public Price execute(GetPriceUseCaseInput input) {
        List<Price> prices = priceService.findPricesBy(input.getBrandId(), input.getProductId(), input.getApplyDate());
        return prices.stream().max(Comparator.comparing(Price::getPriority)).orElseThrow(NotFoundException::new);
    }
}
