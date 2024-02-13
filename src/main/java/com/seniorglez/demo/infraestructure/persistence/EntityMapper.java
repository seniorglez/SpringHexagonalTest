package com.seniorglez.demo.infraestructure.persistence;

import com.seniorglez.demo.domain.model.Price;
import com.seniorglez.demo.infraestructure.persistence.entity.PriceEntity;
import org.springframework.stereotype.Component;

@Component
public class EntityMapper {

    public Price toModelPrice(PriceEntity entity) {
        return new Price(
                entity.getId(),
                entity.getBrandId(),
                entity.getStartDate(),
                entity.getEndDate(),
                entity.getPriceList(),
                entity.getProductId(),
                entity.getPriority(),
                entity.getAmount(),
                entity.getCurrency(),
                entity.getLastUpdate(),
                entity.getLastUpdateBy()
        );
    }

    public PriceEntity toEntityPrice(Price model) {
        return new PriceEntity(
                model.getBrandId(),
                model.getStartDate(),
                model.getEndDate(),
                model.getPriceList(),
                model.getProductId(),
                model.getPriority(),
                model.getAmount(),
                model.getCurrency(),
                model.getLastUpdate(),
                model.getLastUpdateBy()
        );
    }
}

