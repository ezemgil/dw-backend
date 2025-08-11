package dev.ezemgil.dw.service.implementation;

import dev.ezemgil.dw.entity.Word;
import dev.ezemgil.dw.repository.WordRepository;
import dev.ezemgil.dw.repository.specification.WordSpecification;
import dev.ezemgil.dw.service.inteface.WordService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class WordServiceImpl implements WordService {

    private final WordRepository repository;

    @Override
    public Page<Word> findAll(Pageable pageable, Integer categoryId, Integer wordTypeId, Integer genderId, String cefrLevel) {
        Specification<Word> spec = null;

        if (categoryId != null) {
            spec = WordSpecification.hasCategoryId(categoryId);
        }
        if (wordTypeId != null) {
            spec = (spec == null) ? WordSpecification.hasWordTypeId(wordTypeId) : spec.and(WordSpecification.hasWordTypeId(wordTypeId));
        }
        if (genderId != null) {
            spec = (spec == null) ? WordSpecification.hasGenderId(genderId) : spec.and(WordSpecification.hasGenderId(genderId));
        }
        if (cefrLevel != null && !cefrLevel.isEmpty()) {
            spec = (spec == null) ? WordSpecification.hasCefrLevel(cefrLevel) : spec.and(WordSpecification.hasCefrLevel(cefrLevel));
        }

        return repository.findAll(spec, pageable);
    }
}
