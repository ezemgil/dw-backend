package dev.ezemgil.dw.controller;

import dev.ezemgil.dw.dto.CategoryDto;
import dev.ezemgil.dw.service.inteface.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CategoryController {
    private final CategoryService service;

    @GetMapping("/categories")
    public Page<CategoryDto> getCategories(Pageable pageable) {
        return service.findAll(pageable)
                .map(CategoryDto::from);
    }
}
