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

    @ManyToOne
    Gender gender;

    String plural;

    String notes;

    @ManyToOne
    Category category;

    @ManyToOne
    WordType wordType;

    String imageUrl;
    String audioUrl;

    @Column(nullable = false)
    boolean isActive;

    @Column(nullable = false)
    LocalDateTime createdAt;

    @Column(nullable = false)
    LocalDateTime updatedAt;

    String cerfLevel;
}
