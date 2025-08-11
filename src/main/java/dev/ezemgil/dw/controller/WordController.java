package dev.ezemgil.dw.controller;

import dev.ezemgil.dw.dto.WordDto;
import dev.ezemgil.dw.service.inteface.WordService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class WordController {

    private final WordService service;

    @GetMapping("/words")
    public Page<WordDto> getWords(
            Pageable pageable,
            @RequestParam(required = false) Integer categoryId,
            @RequestParam(required = false) Integer wordTypeId,
            @RequestParam(required = false) Integer genderId,
            @RequestParam(required = false) String cefrLevel
    ) {
        return service.findAll(pageable, categoryId, wordTypeId, genderId, cefrLevel)
                .map(WordDto::from);
    }
}
