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
    String word;
    String gender;
    String wordType;
    String hint;
    String category;
    int menschenUnit;
    String imageQuery;
    String audioQuery;

    public static WordDto from(Word word) {
        return WordDto.builder()
                .word(word.getWord())
                .gender(word.getGender())
                .wordType(word.getWordType())
                .hint(word.getHint())
                .category(word.getCategory())
                .menschenUnit(word.getMenschenUnit())
                .imageQuery(word.getImageQuery())
                .audioQuery(word.getAudioQuery())
                .build();
    }
}
