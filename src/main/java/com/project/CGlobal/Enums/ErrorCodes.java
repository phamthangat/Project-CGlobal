package com.project.CGlobal.Enums;

import lombok.Getter;

@Getter
public enum ErrorCodes {

    ACC_NOT_FOUND("Account not found"),
    APPS_SUCCESS("Request successful"),
    APPS_FAILED("The request failed"),
    LIST_PRODUCT("List product"),
    CREATE_PRODUCT_SUCCESS("Create product successfully"),
    FILTER_PRODUCT_SUCCESS("Filter products successfully"),
    ERROR_CREATE_PRODUCT("Failed to save database"),
    NOT_FOUND_PRODUCT("Not found product"),
    CREATE_CATEGORY_SUCCESS("Create category successfully"),
    ERROR_CREATE_CATEGORY("Failed to save database"),
    NOT_FOUND_CATEGORY("Not found category"),
    CREAT_TOKEN_SUCCESS("Create token successfully"),
    ADD_SUCCESS_PRODUCT_CARD("Product added to the shopping cart");

    String message;

    ErrorCodes(String message) {
        this.message = message;
    }
}
