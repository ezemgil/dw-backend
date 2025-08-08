package dev.ezemgil.dw.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "words")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Word {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(nullable = false)
    String word;

    String gender;
    String plural;
    String wordType;
    String hint;
    String category;
    String cerfLevel;
    int menschenUnit;
    String imageQuery;
    String audioQuery;

    @Column(nullable = false)
    boolean isActive;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
