package com.seniorglez.demo.infraestructure.persistence.repository;


import com.seniorglez.demo.infraestructure.persistence.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;


import java.time.LocalDateTime;
import java.util.List;

public interface PriceRepository extends JpaRepository<PriceEntity, Integer> {

    List<PriceEntity> findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
            Integer brandId, Integer productId, LocalDateTime date1, LocalDateTime date2);

}

