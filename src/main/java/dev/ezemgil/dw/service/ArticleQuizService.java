package dev.ezemgil.dw.service;

import dev.ezemgil.dw.entity.Word;

import java.util.List;

public interface ArticleQuizService {
    List<Word> fetchBatch(String wordType, String category, int menschenUnit, int batchSize);
}
