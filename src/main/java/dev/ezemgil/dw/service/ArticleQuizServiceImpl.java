package dev.ezemgil.dw.service;

import dev.ezemgil.dw.entity.Word;
import dev.ezemgil.dw.repository.WordRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ArticleQuizServiceImpl implements ArticleQuizService {

    public final WordRepository repository;

    @Override
    public List<Word> fetchBatch(String wordType, String category, int menschenUnit, int batchSize) {

        // Fetch all words from the repository (or a more specific query)
        List<Word> allWords = repository.findAll();

        // Use a Stream to filter based on the provided parameters
        List<Word> filteredWords = allWords.stream()
                .filter(word -> wordType == null || wordType.isEmpty() || word.getWordType().equals(wordType))
                .filter(word -> category == null || category.isEmpty() || word.getCategory().equals(category))
                .filter(word -> menschenUnit == 0 || word.getMenschenUnit() == menschenUnit)
                .collect(Collectors.toList());

        // Shuffle the filtered list
        Collections.shuffle(filteredWords);

        // Return the requested batch size
        return filteredWords.subList(0, Math.min(filteredWords.size(), batchSize));
    }
}