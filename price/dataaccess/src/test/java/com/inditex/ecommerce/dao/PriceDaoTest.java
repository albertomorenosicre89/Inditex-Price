package com.inditex.ecommerce.dao;

import com.inditex.ecommerce.ApplicationNotFound;
import com.inditex.ecommerce.dao.PriceDao;
import com.inditex.ecommerce.entities.PriceEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@ContextConfiguration(classes= ApplicationNotFound.class)
public class PriceDaoTest {

	@Autowired
    private PriceDao priceDao;

    @Test
    public void whenGetPrice_withDate20200614100000_returnResultWithPriceList1() {
        LocalDateTime date = LocalDateTime.of(2020, Month.of(6),14,10,0,0,0);
        int productId = 35455;
        int brandId = 1;
        PriceEntity result = priceDao.getPrice(date , productId , brandId);

        LocalDateTime startDate = LocalDateTime.of(2020, Month.of(6),14,0,0,0,0);
        LocalDateTime endDate = LocalDateTime.of(2020, Month.of(12),31,23,59,59,0);

        assertEquals(1, result.getPriceId().getBrandId());
        assertEquals(35455, result.getPriceId().getProductId());
        assertEquals(0, result.getPriceId().getPriority());
        assertEquals(1, result.getPriceList());
        assertEquals(35.5, result.getPrice());
        assertEquals("EUR", result.getCurr());
        assertEquals(startDate, result.getStartDate());
        assertEquals(endDate, result.getEndDate());
    }

    @Test
    public void whenGetPrice_withDate20200614160000_returnResultWithPriceList2() {
        LocalDateTime date = LocalDateTime.of(2020, Month.of(6),14,16,0,0,0);
        int productId = 35455;
        int brandId = 1;
        PriceEntity result = priceDao.getPrice(date , productId , brandId);

        LocalDateTime startDate = LocalDateTime.of(2020, Month.of(6),14,15,0,0,0);
        LocalDateTime endDate = LocalDateTime.of(2020, Month.of(6),14,18,30,0,0);

        assertEquals(1, result.getPriceId().getBrandId());
        assertEquals(35455, result.getPriceId().getProductId());
        assertEquals(1, result.getPriceId().getPriority());
        assertEquals(2, result.getPriceList());
        assertEquals(25.45, result.getPrice());
        assertEquals("EUR", result.getCurr());
        assertEquals(startDate, result.getStartDate());
        assertEquals(endDate, result.getEndDate());
    }

}