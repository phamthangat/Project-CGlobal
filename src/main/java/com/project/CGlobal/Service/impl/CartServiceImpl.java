package com.project.CGlobal.Service.impl;

import com.project.CGlobal.Domain.dto.BaseResDto;
import com.project.CGlobal.Domain.Cart;
import com.project.CGlobal.Domain.Product;
import com.project.CGlobal.Domain.dto.ProductDto;
import com.project.CGlobal.Enums.ErrorCodes;
import com.project.CGlobal.Enums.ResponseType;
import com.project.CGlobal.Repository.CartRepository;
import com.project.CGlobal.Repository.ProductRepository;
import com.project.CGlobal.Service.CartService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    @Override
    public BaseResDto addProductToCart(String cardId, ProductDto productDto) {
        BaseResDto baseResDto = new BaseResDto(0,"","", "");

        Product product = productRepository.findProductByName(productDto.getName());
        if(Objects.isNull(product)) {
            baseResDto.setResponseMessage(ErrorCodes.NOT_FOUND_PRODUCT.name());
            baseResDto.setResponseCode(ResponseType.ERROR.ordinal());
            baseResDto.setResponseType(ResponseType.ERROR.name());
            return baseResDto;
        }
        try {
            Cart cart = cartRepository.findShoppingCartByCartId(cardId);
            if(Objects.isNull(cart)) {
                Cart newCart = new Cart();
                newCart.setCartId(cardId);
                newCart.getProducts().add(product);
                cartRepository.save(newCart);
            } else {
                cart.getProducts().add(product);
                cartRepository.save(cart);
            }

            baseResDto.setData(cart);
            baseResDto.setResponseMessage(ErrorCodes.ADD_SUCCESS_PRODUCT_CARD.getMessage());
            baseResDto.setResponseCode(ResponseType.SUCCESS.ordinal());
            return baseResDto;
        } catch (Exception e) {
            return null;
        }
    }
}
