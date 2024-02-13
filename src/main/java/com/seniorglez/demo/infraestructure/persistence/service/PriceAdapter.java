package com.seniorglez.demo.infraestructure.persistence.service;

import com.seniorglez.demo.domain.model.Price;
import com.seniorglez.demo.domain.service.PriceService;
import com.seniorglez.demo.infraestructure.persistence.EntityMapper;
import com.seniorglez.demo.infraestructure.persistence.entity.PriceEntity;
import com.seniorglez.demo.infraestructure.persistence.repository.PriceRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PriceAdapter implements PriceService {

    private final PriceRepository priceRepository;
    private final EntityMapper entityMapper;

    public PriceAdapter(
            PriceRepository priceRepository,
            EntityMapper entityMapper
    ) {
        this.priceRepository = priceRepository;
        this.entityMapper = entityMapper;
    }

    @Override
    public List<Price> findPricesBy(Integer brandId, Integer productId, LocalDateTime applyDate) {
        List<PriceEntity> priceEntities = priceRepository
                .findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(brandId, productId, applyDate, applyDate);
        return priceEntities.stream().map(entityMapper::toModelPrice).toList();
    }

}
