package com.inditex.ecommerce.converter;

import com.inditex.ecommerce.entities.PriceEntity;
import com.inditex.ecommerce.generated.model.PriceResult;

public class PriceConverter {


	public static PriceResult priceEntityToPriceResult(PriceEntity entity){
		if(entity==null){
			return null;
		}

		return PriceResult.builder()
				.productId(entity.getPriceId().getProductId())
				.brandId(entity.getPriceId().getBrandId())
				.priceList(entity.getPriceList())
				.startDate(entity.getStartDate())
				.endDate(entity.getEndDate())
				.price(entity.getPrice())
				.build();
	}
	
}
