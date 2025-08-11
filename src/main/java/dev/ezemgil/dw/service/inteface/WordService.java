package dev.ezemgil.dw.service.inteface;

import dev.ezemgil.dw.entity.Word;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface WordService {
    Page<Word> findAll(Pageable pageable, Integer categoryId, Integer wordTypeId, Integer genderId, String cefrLevel);
}
