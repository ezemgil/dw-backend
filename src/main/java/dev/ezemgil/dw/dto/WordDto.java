package dev.ezemgil.dw.dto;

import dev.ezemgil.dw.entity.Word;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WordDto {
    Integer id;
    String word;
    GenderDto gender;
    String plural;
    String notes;
    CategoryDto category;
    WordTypeDto wordType;
    String imageUrl;
    String audioUrl;
    String cefrLevel;

    public static WordDto from(Word word) {
        if (word == null) {
            return null;
        }

        return WordDto.builder()
                .id(word.getId())
                .word(word.getWord())
                .gender(GenderDto.from(word.getGender()))
                .plural(word.getPlural())
                .notes(word.getNotes())
                .category(CategoryDto.from(word.getCategory()))
                .wordType(WordTypeDto.from(word.getWordType()))
                .imageUrl(word.getImageUrl())
                .audioUrl(word.getAudioUrl())
                .cefrLevel(word.getCerfLevel())
                .build();
    }
}
