package com.inditex.ecommerce.services;

import com.inditex.ecommerce.converter.PriceConverter;
import com.inditex.ecommerce.dao.PriceDao;
import com.inditex.ecommerce.entities.PriceEntity;
import com.inditex.ecommerce.generated.model.Filter;
import com.inditex.ecommerce.generated.model.PriceResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PriceService {

    private final PriceDao priceDao;

    public PriceService(PriceDao priceDao) {
        this.priceDao = priceDao;
    }
    public PriceResult getPrice(Filter filter) {
        PriceEntity priceEntity = priceDao.getPrice( filter.getSelectedDate(), filter.getProductId() , filter.getBrandId());
        return PriceConverter.priceEntityToPriceResult(priceEntity);
    }
}
