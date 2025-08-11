package dev.ezemgil.dw.service.implementation;

import dev.ezemgil.dw.entity.Category;
import dev.ezemgil.dw.repository.CategoryRepository;
import dev.ezemgil.dw.service.inteface.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository repository;

    @Override
    public Page<Category> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
