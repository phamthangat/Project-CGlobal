package com.project.CGlobal.Service;

import com.project.CGlobal.Domain.dto.BaseResDto;
import com.project.CGlobal.Domain.Product;
import com.project.CGlobal.Domain.dto.ProductDto;

public interface CartService {
    BaseResDto addProductToCart(String cardId, ProductDto productDto);
}
