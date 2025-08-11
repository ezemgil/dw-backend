package dev.ezemgil.dw.repository;

import dev.ezemgil.dw.entity.WordType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordTypeRepository extends JpaRepository<WordType, Integer> {
}
