package dev.ezemgil.dw.repository;

import dev.ezemgil.dw.entity.Word;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WordRepository extends JpaRepository<Word, Integer> {

    @Query("""
        SELECT w FROM Word w
        WHERE (:wordType IS NULL OR :wordType = '' OR w.wordType = :wordType)
            AND (:category IS NULL OR :category = '' OR w.category = :category)
            AND (:menschenUnit = 0 OR w.menschenUnit = :menschenUnit)
        ORDER BY function('RANDOM') 
    """)
    List<Word> findRandomFiltered(
            @Param("wordType") String wordType,
            @Param("category") String category,
            @Param("menschenUnit") int menschenUnit,
            Pageable pageable
    );
}
