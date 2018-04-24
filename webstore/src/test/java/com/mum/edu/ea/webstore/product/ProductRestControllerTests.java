package com.mum.edu.ea.webstore.product;

import com.mum.edu.ea.webstore.entity.Order;
import com.mum.edu.ea.webstore.entity.Product;
import com.mum.edu.ea.webstore.entity.ProductCategory;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductRestControllerTests {
    private final String SERVER_URI = "http://localhost:8080/rest/product";

    @Test
    public void a_getProducts(){
        RestTemplate restTemplate = new RestTemplate();
        ParameterizedTypeReference<List<Product>> typeRef = new ParameterizedTypeReference<List<Product>>() {};
        ResponseEntity<List<Product>> response = restTemplate.exchange(SERVER_URI + "/all", HttpMethod.GET, null, typeRef);
        List<Product> products = response.getBody();
        System.out.println(products.size());
    }

    @Test
    public void b_searchProduct(){
        RestTemplate restTemplate = new RestTemplate();
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(SERVER_URI + "/search").queryParam("query", "Full");

        ParameterizedTypeReference<List<Product>> typeRef = new ParameterizedTypeReference<List<Product>>() {};
        ResponseEntity<List<Product>> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, typeRef);
        List<Product> products = response.getBody();
        System.out.println(products.size());
    }

    @Test
    public void c_getProduct(){
        RestTemplate restTemplate = new RestTemplate();
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(SERVER_URI + "/-1");

        Product product = restTemplate.getForObject(builder.toUriString(), Product.class);
        System.out.println(product.getName());
    }

    @Test
    public void d_addProduct(){
        Product product = new Product();
        product.setName("Ladies Modern Stretch Full Zip");
        product.setPrice(41.60);
        product.setDescription("With an updated fit and figure-flattering details, this full-zip combines ultra soft cotton with a dash of spandex to retain its shape all day long.");
        product.setCategory(ProductCategory.SHIRT);
        product.setAvailable(true);
        product.setManufacturer("Nike");
        product.setImageURL("https://shop.polymer-project.org/es6-unbundled/data/images/10-24102A.jpg");

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForObject(SERVER_URI + "/addProduct", product, Void.class);
    }

    @Test
    public void e_updateProduct(){
        RestTemplate restTemplate = new RestTemplate();

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(SERVER_URI + "/-1");

        Product product = restTemplate.getForObject(builder.toUriString(), Product.class);

        System.out.println("Before update : " + product.getName());

        product.setName(product.getName() + " UPDATED");
        restTemplate.postForObject(SERVER_URI + "/updateProduct", product, Void.class);

        product = restTemplate.getForObject(builder.toUriString(), Product.class);

        System.out.println("After update : " + product.getName());
    }

    @Test
    public void f_deleteProduct(){
        RestTemplate restTemplate = new RestTemplate();
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(SERVER_URI + "/delete/-2");

        restTemplate.postForEntity(builder.toUriString(), null, Product.class);


        builder = UriComponentsBuilder.fromHttpUrl(SERVER_URI + "/-2");

        Product product = restTemplate.getForObject(builder.toUriString(), Product.class);

        System.out.println(product);
    }
}
