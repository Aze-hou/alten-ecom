package com.alten.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alten.ecommerce.dto.ProductDto;
import com.alten.ecommerce.services.admin.product.IProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

	@Autowired
	private IProductService productService;

	// list of products
	@GetMapping
	@CrossOrigin("*")
	public ResponseEntity<List<ProductDto>> getAllProducts() {
		List<ProductDto> productDtos = productService.getAll();
		return ResponseEntity.ok(productDtos);
	}

	// add Product
	@PostMapping
	@CrossOrigin("*")
	public ResponseEntity<ProductDto> create(@RequestBody ProductDto productDto) throws Exception {
		ProductDto productDto1 = productService.save(productDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(productDto1);
	}

	// update Product
	@PutMapping("/{id}")
	@CrossOrigin("*")
	public ResponseEntity<ProductDto> update(@PathVariable(name = "id") Long id, @RequestBody ProductDto productDto)
			throws Exception {
		ProductDto productDto1 = productService.update(productDto, id);
		return ResponseEntity.status(HttpStatus.OK).body(productDto1);
	}

	// delete Product
	@DeleteMapping("/{id}")
	@CrossOrigin("*")
	public void deleteProduct(@PathVariable(name = "id") Long id) {
		productService.delete(id);
	}

}
