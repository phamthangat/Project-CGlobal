package com.project.CGlobal.Service;

import com.project.CGlobal.Domain.dto.BaseResDto;
import com.project.CGlobal.Domain.dto.ProductDto;
import org.springframework.data.domain.Pageable;

public interface ProductService {

    BaseResDto createProduct(ProductDto productDto);

    BaseResDto findAllByFilters(ProductDto productDto, Pageable pageable);
}