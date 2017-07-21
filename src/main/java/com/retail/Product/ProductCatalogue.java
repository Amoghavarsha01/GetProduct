package com.retail.Product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductCatalogue {
	@Autowired
	MongoTemplate mongoTemplate;
	
	@RequestMapping(consumes="application/json", method=RequestMethod.POST, name="GetProduct", produces = "application/json" )
	public String getProduct(@RequestBody Product product){
		System.out.println(product);
		Query query = new Query(Criteria.where("name").is("Effective Java"));
		List<Product> productResult = mongoTemplate.find(query, Product.class);
		System.out.println(productResult.get(0).getCategory());
	    return "Success";
	}
}
