package dev.ezemgil.dw.dto;

import dev.ezemgil.dw.entity.WordType;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WordTypeDto {

    Integer id;
    String name;

    public static WordTypeDto from(WordType wordType) {
        if (wordType == null) {
            return null;
        }

        return WordTypeDto.builder()
                .id(wordType.getId())
                .name(wordType.getName())
                .build();
    }
}
