package com.inditex.ecommerce.e2e;

import com.inditex.ecommerce.EcommerceApplication;
import com.inditex.ecommerce.generated.model.Filter;
import com.inditex.ecommerce.generated.model.PriceResult;
import com.inditex.ecommerce.services.PriceService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.time.Month;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@SpringBootTest( classes = EcommerceApplication.class,webEnvironment = WebEnvironment.RANDOM_PORT)
public class PriceControllerE2E {

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Autowired
	private PriceService priceService;

	@Test
	public void whenGetPrice_withFilterDate20200614100000_return200withPriceList1()  {
		LocalDateTime date = LocalDateTime.of(2020, Month.of(6),14,10,0,0,0);
		Filter filter = Filter.builder().
				brandId(1).
				productId(35455).
				selectedDate(date).
				build();

		LocalDateTime startDate = LocalDateTime.of(2020, Month.of(6),14,0,0,0,0);
		LocalDateTime endDate = LocalDateTime.of(2020, Month.of(12),31,23,59,59,0);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Filter> requestWithBody = new HttpEntity<>(filter, headers);
		ResponseEntity<PriceResult> response = testRestTemplate.exchange("/price", HttpMethod.GET,requestWithBody , PriceResult.class);

		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
		assertEquals(1 , response.getBody().getBrandId());
		assertEquals(35455 , response.getBody().getProductId());
		assertEquals(1 , response.getBody().getPriceList());
		assertEquals(35.5 , response.getBody().getPrice());
		assertEquals(startDate , response.getBody().getStartDate());
		assertEquals(endDate , response.getBody().getEndDate());

	}

	@Test
	public void whenGetPrice_withFilterDate20200614160000_return200withPriceList2()  {
		LocalDateTime date = LocalDateTime.of(2020, Month.of(6),14,16,0,0,0);
		Filter filter = Filter.builder().
				brandId(1).
				productId(35455).
				selectedDate(date).
				build();

		LocalDateTime startDate = LocalDateTime.of(2020, Month.of(6),14,15,0,0,0);
		LocalDateTime endDate = LocalDateTime.of(2020, Month.of(6),14,18,30,0,0);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Filter> requestWithBody = new HttpEntity<>(filter, headers);
		ResponseEntity<PriceResult> response = testRestTemplate.exchange("/price", HttpMethod.GET,requestWithBody , PriceResult.class);

		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
		assertEquals(1 , response.getBody().getBrandId());
		assertEquals(35455 , response.getBody().getProductId());
		assertEquals(2 , response.getBody().getPriceList());
		assertEquals(25.45 , response.getBody().getPrice());
		assertEquals(startDate , response.getBody().getStartDate());
		assertEquals(endDate , response.getBody().getEndDate());

	}

	@Test
	public void whenGetPrice_withFilterDate20200614210000_return200withPriceList1()  {
		LocalDateTime date = LocalDateTime.of(2020, Month.of(6),14,21,0,0,0);
		Filter filter = Filter.builder().
				brandId(1).
				productId(35455).
				selectedDate(date).
				build();

		LocalDateTime startDate = LocalDateTime.of(2020, Month.of(6),14,0,0,0,0);
		LocalDateTime endDate = LocalDateTime.of(2020, Month.of(12),31,23,59,59,0);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Filter> requestWithBody = new HttpEntity<>(filter, headers);
		ResponseEntity<PriceResult> response = testRestTemplate.exchange("/price", HttpMethod.GET,requestWithBody , PriceResult.class);

		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
		assertEquals(1 , response.getBody().getBrandId());
		assertEquals(35455 , response.getBody().getProductId());
		assertEquals(1 , response.getBody().getPriceList());
		assertEquals(35.5 , response.getBody().getPrice());
		assertEquals(startDate , response.getBody().getStartDate());
		assertEquals(endDate , response.getBody().getEndDate());

	}

	@Test
	public void whenGetPrice_withFilterDate20200615100000_return200withPriceList3()  {
		LocalDateTime date = LocalDateTime.of(2020, Month.of(6),15,10,0,0,0);
		Filter filter = Filter.builder().
				brandId(1).
				productId(35455).
				selectedDate(date).
				build();

		LocalDateTime startDate = LocalDateTime.of(2020, Month.of(6),15,0,0,0,0);
		LocalDateTime endDate = LocalDateTime.of(2020, Month.of(6),15,11,0,0,0);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Filter> requestWithBody = new HttpEntity<>(filter, headers);
		ResponseEntity<PriceResult> response = testRestTemplate.exchange("/price", HttpMethod.GET,requestWithBody , PriceResult.class);

		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
		assertEquals(1 , response.getBody().getBrandId());
		assertEquals(35455 , response.getBody().getProductId());
		assertEquals(3 , response.getBody().getPriceList());
		assertEquals(30.5 , response.getBody().getPrice());
		assertEquals(startDate , response.getBody().getStartDate());
		assertEquals(endDate , response.getBody().getEndDate());

	}

	@Test
	public void whenGetPrice_withFilterDate20200616210000_return200withPriceList4()  {
		LocalDateTime date = LocalDateTime.of(2020, Month.of(6),16,21,0,0,0);
		Filter filter = Filter.builder().
				brandId(1).
				productId(35455).
				selectedDate(date).
				build();

		LocalDateTime startDate = LocalDateTime.of(2020, Month.of(6),15,16,0,0,0);
		LocalDateTime endDate = LocalDateTime.of(2020, Month.of(12),31,23,59,59,0);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Filter> requestWithBody = new HttpEntity<>(filter, headers);
		ResponseEntity<PriceResult> response = testRestTemplate.exchange("/price", HttpMethod.GET,requestWithBody , PriceResult.class);

		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
		assertEquals(1 , response.getBody().getBrandId());
		assertEquals(35455 , response.getBody().getProductId());
		assertEquals(4 , response.getBody().getPriceList());
		assertEquals(38.95 , response.getBody().getPrice());
		assertEquals(startDate , response.getBody().getStartDate());
		assertEquals(endDate , response.getBody().getEndDate());

	}

	@Test
	public void whenGetPrice_withNoContentType_return404() {
		// GIVEN
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<Filter> requestWithNothing = new HttpEntity<>( headers);
		ResponseEntity<String> response = testRestTemplate.exchange("/price", HttpMethod.GET,requestWithNothing , String.class);

		assertThat(response.getStatusCode(), equalTo(HttpStatus.NOT_FOUND));
		assertTrue(response.getBody().contains("Content-Type is not supported"));

	}

	@Test
	public void whenGetPrice_withNoBody_return404() {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Filter> requestWithNothing = new HttpEntity<>( null, headers);
		ResponseEntity<String> response = testRestTemplate.exchange("/price", HttpMethod.GET,requestWithNothing , String.class);

		assertThat(response.getStatusCode(), equalTo(HttpStatus.NOT_FOUND));
		assertTrue(response.getBody().contains("Required request body is missing"));
	}
}