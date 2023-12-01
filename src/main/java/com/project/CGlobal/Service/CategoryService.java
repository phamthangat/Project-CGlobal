package com.project.CGlobal.Service;

import com.project.CGlobal.Domain.dto.BaseResDto;
import com.project.CGlobal.Domain.dto.CategoryDto;

public interface CategoryService {
    BaseResDto createCategory(CategoryDto categoryDto);
}
