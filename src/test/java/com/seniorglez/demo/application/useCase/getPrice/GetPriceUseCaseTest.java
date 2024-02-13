package com.seniorglez.demo.application.useCase.getPrice;

import com.seniorglez.demo.domain.exception.NotFoundException;
import com.seniorglez.demo.domain.model.Price;
import com.seniorglez.demo.domain.service.PriceService;
import com.seniorglez.demo.infraestructure.persistence.EntityMapper;
import com.seniorglez.demo.infraestructure.persistence.entity.PriceEntity;
import com.seniorglez.demo.infraestructure.persistence.repository.PriceRepository;
import com.seniorglez.demo.infraestructure.persistence.service.PriceAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(SpringExtension.class)
public class GetPriceUseCaseTest {

    private PriceRepository priceRepository = Mockito.mock(PriceRepository.class);
    private EntityMapper entityMapper = new EntityMapper();
    private PriceService priceService = new PriceAdapter(priceRepository, entityMapper);
    private GetPriceUseCase getPriceUseCase = new GetPriceUseCase(priceService);


    private PriceEntity dummyPriceEntity;

    @BeforeEach
    void init() {
        dummyPriceEntity = createDummyPriceEntity();
    }

    private PriceEntity createDummyPriceEntity() {
        Integer brandId = 1;
        LocalDateTime startDate = LocalDateTime.of(2022, 1, 1, 0, 0);
        LocalDateTime endDate = LocalDateTime.of(2022, 12, 31, 23, 59);
        Integer priceList = 1;
        Integer productId = 35455;
        Integer priority = 0;
        Float amount = 35.50f;
        String currency = "EUR";
        LocalDateTime lastUpdate = LocalDateTime.now();
        String lastUpdateBy = "testUser";

        return new PriceEntity(
                brandId,
                startDate,
                endDate,
                priceList,
                productId,
                priority,
                amount,
                currency,
                lastUpdate,
                lastUpdateBy
        );
    }


    @Test
    void whenTheInputMatchesOnePriceThenReturnIt() {
        PriceEntity topPriorityDummyEntity = createDummyPriceEntity();
        Mockito.when(
                priceRepository.findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(dummyPriceEntity.getBrandId(), dummyPriceEntity.getProductId(), dummyPriceEntity.getStartDate(), dummyPriceEntity.getStartDate()))
                .thenReturn(List.of(
                        dummyPriceEntity,
                        topPriorityDummyEntity
                ));
        Price price = getPriceUseCase.execute(
                new GetPriceUseCaseInput(dummyPriceEntity.getStartDate(),dummyPriceEntity.getProductId(),dummyPriceEntity.getBrandId())
        );
        assertEquals(35.50f, price.getAmount());
    }

    @Test
    void whenPriceDoesNotExistThenThrowNotFoundException() {
        Mockito.when(priceRepository.findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(any(), any(), any(), any()))
                .thenReturn(List.of());
        assertThrows(NotFoundException.class,
                () -> getPriceUseCase.execute(
                        new GetPriceUseCaseInput(LocalDateTime.now(),1,1)
                )
        );
    }

    @Test
    void whenTheRepositoryReturnsMultiplePricesReturnTheTopPriority() {
        PriceEntity topPriorityDummyEntity = createDummyPriceEntity();
        topPriorityDummyEntity.setPriority(1);
        Mockito.when(priceRepository.findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(any(), any(), any(), any()))
                .thenReturn(List.of(
                    dummyPriceEntity,
                        topPriorityDummyEntity
                ));
        Price price = getPriceUseCase.execute(
                        new GetPriceUseCaseInput(LocalDateTime.now(),1,1)
                );
        assertEquals(1, price.getPriority());
    }

}
