package dev.ezemgil.dw.service;

import dev.ezemgil.dw.entity.Word;
import dev.ezemgil.dw.repository.WordRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class WordServiceImpl implements WordService {
    private final WordRepository repository;

    @Override
    public List<Word> getWords() {
        return repository.findAll();
    }
}
