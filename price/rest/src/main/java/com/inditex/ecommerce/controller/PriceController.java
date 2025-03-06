package com.inditex.ecommerce.controller;


import com.inditex.ecommerce.generated.api.PriceApi;
import com.inditex.ecommerce.generated.model.Filter;
import com.inditex.ecommerce.generated.model.PriceResult;
import com.inditex.ecommerce.services.PriceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PriceController implements PriceApi {

	private final PriceService priceService;

	public PriceController(PriceService priceService) {
		this.priceService = priceService;
	}

	@Override
	public ResponseEntity<PriceResult> getPrice(Filter filter) {
		return new ResponseEntity<>(priceService.getPrice(filter),HttpStatus.OK);

	}

}