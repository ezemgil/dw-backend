package dev.ezemgil.dw.service.inteface;

import dev.ezemgil.dw.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryService {
    Page<Category> findAll(Pageable pageable);
}
