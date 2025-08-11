package dev.ezemgil.dw.controller;

import dev.ezemgil.dw.dto.WordDto;
import dev.ezemgil.dw.service.WordService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/words")
@AllArgsConstructor
public class WordController {
    private final WordService service;

    @GetMapping
    public List<WordDto> getWords() {
        return service.getWords().stream()
                .map(WordDto::from)
                .collect(Collectors.toList());
    }
}
