package com.project.CGlobal.Service.impl;

import com.project.CGlobal.Domain.Category;
import com.project.CGlobal.Domain.dto.BaseResDto;
import com.project.CGlobal.Domain.dto.CategoryDto;
import com.project.CGlobal.Enums.ErrorCodes;
import com.project.CGlobal.Enums.ResponseType;
import com.project.CGlobal.Repository.CategoryRepository;
import com.project.CGlobal.Service.CategoryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    @Override
    public BaseResDto createCategory(CategoryDto categoryDto) {
        BaseResDto baseResDto = new BaseResDto(0,"","", "");
        Category category = new Category();
        try {
            category.setName(categoryDto.getCategoryName());
            categoryRepository.save(category);
        } catch (Exception e) {
            baseResDto.setResponseMessage(ErrorCodes.ERROR_CREATE_CATEGORY.name());
            baseResDto.setResponseCode(ResponseType.ERROR.ordinal());
            baseResDto.setResponseType(ResponseType.ERROR.name());
            return baseResDto;
        }
        baseResDto.setData(category);
        baseResDto.setResponseMessage(ErrorCodes.CREATE_CATEGORY_SUCCESS.getMessage());
        baseResDto.setResponseCode(ResponseType.SUCCESS.ordinal());
        baseResDto.setResponseType(ResponseType.SUCCESS.name());
        return baseResDto;
    }
}
