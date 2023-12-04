package com.project.CGlobal.Controller;

import com.project.CGlobal.Domain.dto.BaseResDto;
import com.project.CGlobal.Domain.dto.ProductDto;
import com.project.CGlobal.Service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ProductController extends BaseController{
    private final ProductService productService;

    @PostMapping("/products")
    public BaseResDto createProduct(@RequestBody ProductDto productDto) {
        return productService.createProduct(productDto);
    }

    @GetMapping("/products/filters-product")
    public BaseResDto filters(@ModelAttribute ProductDto productDto,
                              @RequestParam(defaultValue = "0") int page,
                              @RequestParam(defaultValue = "10") int size,
                              @RequestParam(defaultValue = "name") String sort,
                              @PageableDefault(size = 40, sort = "name", direction = Sort.Direction.ASC) Pageable pageable) {
        pageable = PageRequest.of(page, size, Sort.by(sort));
        return productService.findAllByFilters(productDto, pageable);
    }
}
