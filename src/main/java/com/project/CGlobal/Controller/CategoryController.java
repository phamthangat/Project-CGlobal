package com.project.CGlobal.Controller;

import com.project.CGlobal.Domain.dto.BaseResDto;
import com.project.CGlobal.Domain.dto.CategoryDto;
import com.project.CGlobal.Service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    @GetMapping("/category")
    public BaseResDto createCategory(@ModelAttribute CategoryDto categoryDto) {
        return categoryService.createCategory(categoryDto);
    }
}
