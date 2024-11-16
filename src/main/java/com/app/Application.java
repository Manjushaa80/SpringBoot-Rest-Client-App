package com.app;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.app.model.Product;

@SpringBootApplication
public class Application {
	public static final String GET_APP_URL = "http://localhost:8080/api/v1/products/{id}";
	public static final String POST_APP_URL = "http://localhost:8080/api/v1/products";
	public static final String DELETE_APP_URL = "http://localhost:8080/api/v1/products/{id}";
	public static final String PUT_APP_URL = "http://localhost:8080/api/v1/products/{id}";
	public static final String GET_ALL_APP_URL = "http://localhost:8080/api/v1/products";
	public static final String PATCH_APP_URL = "http://localhost:8080/api/v2/products/{id}";

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		// getSingleProductsUsinggetForObject(); // String format

		// getProductsid(template); //hole data means url,header,statuscode ,status
		// value

		RestTemplate template = new RestTemplate();
		// postforobject(template);

		// postforentity(template);

		// getForObject

		// delete(template);
		// getData(template);

		// put(template);

		// getAllString(template);
		// getAllProductsgetforentity(template);
		//PatchMethod
		Map<String, Integer> urlvariable = new HashMap<String, Integer>();
		urlvariable.put("id", 21);

		Product pr = new Product();
		pr.setProductCategory("Cloths");
		pr.setProductPrice(2000.00);
		String result = template.patchForObject(PATCH_APP_URL, pr, String.class, urlvariable);

		System.out.println(result);

	}

	private static void getAllProductsgetforentity(RestTemplate template) {
		ResponseEntity<Product[]> entity = template.getForEntity(GET_ALL_APP_URL, Product[].class);
		Product[] pr = entity.getBody();

		for (Product product : pr) {
			System.out.println(product);

		}
		System.out.println("---------");
		System.out.println(entity.getHeaders());
		System.out.println(entity.getStatusCode());
		System.out.println(entity.getStatusCodeValue());
	}

	private static void getAllString(RestTemplate template) {
		ResponseEntity<String> entity = template.getForEntity(GET_ALL_APP_URL, String.class);
		System.out.println(entity.getBody());
		System.out.println(entity.getHeaders());
		System.out.println(entity.getStatusCode());
		System.out.println(entity.getStatusCodeValue());
		System.out.println("-----");
	}

	private static void put(RestTemplate template) {
		Product pr = new Product();
		pr.setProductName("Cycle");
		pr.setCompannyName("Decathlon");
		pr.setProductCategory("Fitness");
		pr.setProductPrice(20002.2);
		pr.setProductColor("Black");
		Map<String, Integer> urlvariable = new HashMap<String, Integer>();
		urlvariable.put("id", 13);
		template.put(PUT_APP_URL, pr, urlvariable);
	}

	private static void delete(RestTemplate template) {
		Map<String, Integer> urlvariable = new HashMap<String, Integer>();
		urlvariable.put("id", 22);
		template.delete(DELETE_APP_URL, urlvariable);
	}

	private static void getData(RestTemplate template) {
		String url = "http://localhost:8080/api/v1/products/9";
		Map<String, Integer> urlvariable = new HashMap<String, Integer>();
		urlvariable.put("id", 3);
		ResponseEntity<Product> entity = template.getForEntity(url, Product.class, urlvariable);
		Product product = entity.getBody();
		System.out.println(product);
		System.out.println(entity.getHeaders());
		System.out.println(entity.getStatusCode());
		System.out.println(entity.getStatusCodeValue());
	}

	private static void postforentity(RestTemplate template) {
		Product pr = new Product(22, "Shirt", 1999.2, "Allen Solly", "Fashion", "Pink");
		ResponseEntity<Product> entity2 = template.postForEntity(POST_APP_URL, pr, Product.class);
		System.out.println(entity2.getBody());
		System.out.println(entity2.getHeaders());
		System.out.println(entity2.getStatusCode());
		System.out.println(entity2.getStatusCodeValue());
		System.out.println("-----------");
	}

	private static void postforobject(RestTemplate template) {
		Product pr = new Product(21, "T-Shirt", 1000.2, "POLO", "Fashion", "Yellow");
		Product product2 = template.postForObject(POST_APP_URL, pr, Product.class);
		System.out.println(product2);
	}

	private static void getSingleProductsUsinggetForObject() {
		String url = "http://localhost:8080/api/v1/products/9";
		RestTemplate template = new RestTemplate();
		String result = template.getForObject(url, String.class);
		System.out.println(result);
	}

	private static void getProductsid(RestTemplate template) {

		Map<String, Integer> urlvariable = new HashMap<String, Integer>();
		urlvariable.put("id", 3);

		ResponseEntity<String> entity = template.getForEntity(GET_APP_URL, String.class, urlvariable);
		System.out.println(entity.getBody());
		System.out.println(entity.getHeaders());
		System.out.println(entity.getStatusCode());
		System.out.println(entity.getStatusCodeValue());
	}

}
