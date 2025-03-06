package com.inditex.ecommerce.converter;

import com.inditex.ecommerce.converter.PriceConverter;
import com.inditex.ecommerce.entities.PriceEntity;
import com.inditex.ecommerce.entities.PriceId;
import com.inditex.ecommerce.generated.model.PriceResult;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(SpringExtension.class)
public class PriceConverterTest {

	@Test
    public void whenToPriceResult_withNotNullData_returnValidPriceResult() {
        PriceId priceId = PriceId.builder().
                brandId(1).
                productId(35455).
                priority(1).
                build();

        LocalDateTime startDate = LocalDateTime.of(2020, Month.of(6),14,0,0,0,0);
        LocalDateTime endDate = LocalDateTime.of(2020, Month.of(12),31,23,59,59,0);

        PriceEntity entity = PriceEntity.builder().
                priceId(priceId).
                priceList(0).
                price(30.2).
                startDate(startDate).
                endDate(endDate).
                curr("EUR").
                build();

        PriceResult result = PriceConverter.priceEntityToPriceResult(entity);
        assertEquals(1, result.getBrandId());
        assertEquals(35455, result.getProductId());
        assertEquals(0, result.getPriceList());
        assertEquals(startDate, result.getStartDate());
        assertEquals(endDate, result.getEndDate());
        assertEquals(30.2, result.getPrice());
    }
	
	@Test
    public void whenToPriceResult_withNullData_returnNull() {
        PriceEntity entity = null;
        PriceResult result = PriceConverter.priceEntityToPriceResult(entity);
		assertNull( result);
    }

}
