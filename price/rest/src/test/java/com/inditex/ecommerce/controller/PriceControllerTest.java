package com.inditex.ecommerce.controller;

/*@ExtendWith(SpringExtension.class)
//@WebMvcTest(PriceController.class)
@ContextConfiguration(classes= EcommerceApplication.class)*/
public class PriceControllerTest {

	/*@Autowired
	private MockMvc mockMvc;

	//https://stackoverflow.com/questions/79243535/what-is-the-replacement-for-the-deprecated-mockbeans-in-springboot-3-4-0
	@MockitoBean
	private PriceService priceService;

	@Test
	public void whenGetPrice_withFilter_return200withPriceList1() throws Exception {
		// GIVEN
		LocalDateTime date = LocalDateTime.of(2020, Month.of(6),14,10,0,0,0);
		Filter filter = Filter.builder().
				brandId(1).
				productId(35455).
				selectedDate(date).
				build();

		LocalDateTime startDate = LocalDateTime.of(2020, Month.of(6),14,0,0,0,0);
		LocalDateTime endDate = LocalDateTime.of(2020, Month.of(12),31,23,59,59,0);
		PriceResult priceResult = PriceResult.builder().
				brandId(1).
				productId(35455).
				priceList(1).
				price(35.5).
				startDate(startDate).
				endDate(endDate).
				build();
		when(priceService.getPrice(filter)).thenReturn(priceResult);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		// WHEN
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		RequestBuilder request = MockMvcRequestBuilders.get("/price").headers(headers).contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(filter)).accept(MediaType.APPLICATION_JSON);

		String expectedResponse = "{    \"productId\": 35455,    \"brandId\": 1,    \"priceList\": 1,    \"startDate\": \"2020-06-14T00:00:00\",    \"endDate\": \"2020-12-31T23:59:59\",    \"price\": 35.5}";
		MvcResult result = mockMvc.perform(request).andExpect(status().isOk())
				.andExpect(content().json(expectedResponse)).andReturn();

		// THEN
		JSONAssert.assertEquals(expectedResponse, result.getResponse().getContentAsString(), false);
		verify(priceService,times(1)).getPrice(filter);
	}

	@Test
	public void whenGetPrice_withNoFilter_return200withPriceList1() throws Exception {
		// GIVEN
		Filter filter = Filter.builder().build();

		LocalDateTime startDate = LocalDateTime.of(2020, Month.of(6),14,0,0,0,0);
		LocalDateTime endDate = LocalDateTime.of(2020, Month.of(12),31,23,59,59,0);
		PriceResult priceResult = PriceResult.builder().
				brandId(1).
				productId(35455).
				priceList(1).
				price(35.5).
				startDate(startDate).
				endDate(endDate).
				build();
		when(priceService.getPrice(filter)).thenReturn(priceResult);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		// WHEN
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		RequestBuilder request = MockMvcRequestBuilders.get("/price").headers(headers).contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(filter)).accept(MediaType.APPLICATION_JSON);

		String expectedResponse = "{    \"productId\": 35455,    \"brandId\": 1,    \"priceList\": 1,    \"startDate\": \"2020-06-14T00:00:00\",    \"endDate\": \"2020-12-31T23:59:59\",    \"price\": 35.5}";
		MvcResult result = mockMvc.perform(request).andExpect(status().isOk())
				.andExpect(content().json(expectedResponse)).andReturn();

		// THEN
		JSONAssert.assertEquals(expectedResponse, result.getResponse().getContentAsString(), false);
		verify(priceService,times(1)).getPrice(filter);
	}

	@Test
	public void whenGetPrice_withNoContentType_return404() throws Exception {
		// GIVEN
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		// WHEN
		RequestBuilder request = MockMvcRequestBuilders.get("/price").headers(headers)
				.content("").accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(request).andExpect(status().isNotFound()).andReturn();

		// THEN
		assertTrue(result.getResponse().getContentAsString().contains("Required request body is missing"));
		verify(priceService,times(0)).getPrice(null);
	}

	@Test
	public void whenGetPrice_withNoBody_return404() throws Exception {
		// GIVEN
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		// WHEN
		RequestBuilder request = MockMvcRequestBuilders.get("/price").headers(headers).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(request).andExpect(status().isNotFound()).andReturn();

		// THEN
		assertTrue(result.getResponse().getContentAsString().contains("Required request body is missing"));
		verify(priceService,times(0)).getPrice(null);
	}*/
}