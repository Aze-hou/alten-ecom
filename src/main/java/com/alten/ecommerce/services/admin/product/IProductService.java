package com.alten.ecommerce.services.admin.product;

import java.util.List;

import com.alten.ecommerce.dto.ProductDto;

public interface IProductService {

	ProductDto save(ProductDto productDto) throws Exception;

	ProductDto update(ProductDto productDto, Long id) throws Exception;

	List<ProductDto> getAll();

	void delete(Long id);

}
