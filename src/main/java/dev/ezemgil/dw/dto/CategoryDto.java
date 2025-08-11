package dev.ezemgil.dw.dto;

import dev.ezemgil.dw.entity.Category;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CategoryDto {
    Integer id;
    String name;
    String iconUrl;
    Integer wordsAmount;

    public static CategoryDto from(Category category) {
        if (category == null) {
            return null;
        }

        return CategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .iconUrl(category.getIconUrl())
                .wordsAmount(category.getWordsAmount())
                .build();
    }
}
