package dev.ezemgil.dw.service;

import dev.ezemgil.dw.entity.Word;
import dev.ezemgil.dw.repository.WordRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ArticleQuizServiceImpl implements ArticleQuizService {

    private final WordRepository repository;

    @Override
    public List<Word> fetchBatch(String wordType, String category, int menschenUnit, int batchSize) {
        return repository.findRandomFiltered(wordType, category, menschenUnit, PageRequest.of(0, batchSize));
    }
}