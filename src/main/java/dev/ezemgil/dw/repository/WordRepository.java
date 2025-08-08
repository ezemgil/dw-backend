package dev.ezemgil.dw.repository;

import dev.ezemgil.dw.entity.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WordRepository extends JpaRepository<Word, Integer> {
    List<Word> findAllByWordTypeAndCategoryAndMenschenUnit(String wordType, String category, int menschenUnit);
}
