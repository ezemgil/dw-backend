package dev.ezemgil.dw.controller;

import dev.ezemgil.dw.dto.WordDto;
import dev.ezemgil.dw.entity.Word;
import dev.ezemgil.dw.service.ArticleQuizService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/quiz/article")
public class ArticleQuizController {
    private final ArticleQuizService service;

    @GetMapping("/batch")
    public List<WordDto> getBatch(
            @RequestParam String wordType,
            @RequestParam String category,
            @RequestParam int menschenUnit,
            @RequestParam int batchSize
            ) {
        List<Word> batch = service.fetchBatch(wordType, category, menschenUnit, batchSize);
        return batch.stream()
                .map(WordDto::from)
                .collect(Collectors.toList());
    }
}