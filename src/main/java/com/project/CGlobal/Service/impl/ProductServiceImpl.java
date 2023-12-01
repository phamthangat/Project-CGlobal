package com.project.CGlobal.Service.impl;

import com.project.CGlobal.Domain.Category;
import com.project.CGlobal.Domain.Product;
import com.project.CGlobal.Domain.dto.BaseResDto;
import com.project.CGlobal.Domain.dto.PageResponse;
import com.project.CGlobal.Domain.dto.ProductDto;
import com.project.CGlobal.Enums.ErrorCodes;
import com.project.CGlobal.Enums.ResponseType;
import com.project.CGlobal.Repository.CategoryRepository;
import com.project.CGlobal.Repository.ProductRepository;
import com.project.CGlobal.Service.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@AllArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public BaseResDto createProduct(ProductDto productDto) {
        BaseResDto baseResDto = new BaseResDto(0,"","", "");
        Product product = new Product();
        try {
            Category category = categoryRepository.findCategoryById(productDto.getCategoryId());
            if(Objects.isNull(category)) {
                baseResDto.setResponseMessage(ErrorCodes.NOT_FOUND_CATEGORY.name());
                baseResDto.setResponseCode(ResponseType.ERROR.ordinal());
                baseResDto.setResponseType(ResponseType.ERROR.name());
                return baseResDto;
            }
            product = Product.builder()
                    .name(productDto.getName())
                    .price(productDto.getPrice())
                    .brand(productDto.getBrand())
                    .color(productDto.getColor())
                    .category(category)
                    .build();

            product = productRepository.save(product);
        } catch (Exception e) {
            baseResDto.setResponseMessage(ErrorCodes.ERROR_CREATE_PRODUCT.name());
            baseResDto.setResponseCode(ResponseType.ERROR.ordinal());
            baseResDto.setResponseType(ResponseType.ERROR.name());
            return baseResDto;
        }
        baseResDto.setData(product);
        baseResDto.setResponseMessage(ErrorCodes.CREATE_PRODUCT_SUCCESS.getMessage());
        baseResDto.setResponseCode(ResponseType.SUCCESS.ordinal());
        baseResDto.setResponseType(ResponseType.SUCCESS.name());
        return baseResDto;
    }

    @Override
    public BaseResDto findAllByFilters(ProductDto productDto, Pageable pageable) {
        BaseResDto baseResDto = new BaseResDto(0,"","", "");
        Page<Product> productPage;
        try {
            productPage = productRepository.findAllByFilters(productDto.getCategoryId(), productDto.getPrice(), productDto.getBrand(), productDto.getColor(), productDto.getName(), pageable);
            if (Objects.isNull(productPage)) {
                log.info("Err: {}",ErrorCodes.NOT_FOUND_PRODUCT.name());
                baseResDto.setResponseMessage(ErrorCodes.NOT_FOUND_PRODUCT.name());
                baseResDto.setResponseCode(ResponseType.ERROR.ordinal());
                baseResDto.setResponseType(ResponseType.ERROR.name());
                return baseResDto;
            }
        } catch (Exception e) {
            log.info("Err: {}",e.getMessage());
            baseResDto.setResponseMessage(e.getMessage());
            baseResDto.setResponseCode(ResponseType.ERROR.ordinal());
            baseResDto.setResponseType(ResponseType.ERROR.name());
            return baseResDto;
        }

        PageResponse pageResponse = new PageResponse();
        pageResponse.setContent(productPage.getContent());
        pageResponse.setPageSize(productPage.getSize());
        pageResponse.setPageNo(productPage.getNumber());
        pageResponse.setTotalPages(productPage.getTotalPages());

        baseResDto.setData(pageResponse);
        baseResDto.setResponseMessage(ErrorCodes.FILTER_PRODUCT_SUCCESS.getMessage());
        baseResDto.setResponseCode(ResponseType.SUCCESS.ordinal());
        baseResDto.setResponseType(ResponseType.SUCCESS.name());
        return baseResDto;
    }
}
