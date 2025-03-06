package com.inditex.ecommerce.services;

import com.inditex.ecommerce.dao.PriceDao;
import com.inditex.ecommerce.entities.PriceEntity;
import com.inditex.ecommerce.entities.PriceId;
import com.inditex.ecommerce.generated.model.Filter;
import com.inditex.ecommerce.generated.model.PriceResult;
import com.inditex.ecommerce.services.PriceService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class PriceServiceTest {

	@InjectMocks
	private PriceService priceService;

	@Mock
	private PriceDao priceDao;

	@Test
	public void whenGetPrice_withDate20200614100000_returnResultWithPriceList1() {
		//GIVEN
		LocalDateTime date = LocalDateTime.of(2020, Month.of(6),14,10,0,0,0);
		Filter filter = Filter.builder().
				brandId(1).
				productId(35455).
				selectedDate(date).
				build();


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


		when(priceDao.getPrice(filter.getSelectedDate(),filter.getProductId(),filter.getBrandId())).thenReturn(entity);

		//WHEN
		PriceResult result = priceService.getPrice(filter);
		
		//THEN
		assertEquals(1, result.getBrandId());
		assertEquals(35455, result.getProductId());
		assertEquals(0, result.getPriceList());
		assertEquals(startDate, result.getStartDate());
		assertEquals(endDate, result.getEndDate());
		assertEquals(30.2, result.getPrice());
	}

	@Test
	public void whenGetPrice_withNothing_returnNull() {
		//GIVEN
		LocalDateTime date = LocalDateTime.of(2020, Month.of(6),14,10,0,0,0);
		Filter filter = Filter.builder().
				brandId(1).
				productId(35455).
				selectedDate(date).
				build();

		when(priceDao.getPrice(filter.getSelectedDate(),filter.getProductId(),filter.getBrandId())).thenReturn(null);

		//WHEN
		PriceResult result = priceService.getPrice(filter);

		//THEN
		assertNull( result );
	}
	
}