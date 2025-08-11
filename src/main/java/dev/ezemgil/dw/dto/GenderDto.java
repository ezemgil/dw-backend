package dev.ezemgil.dw.dto;

import dev.ezemgil.dw.entity.Gender;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GenderDto {
    // Jakarta annotations
    Integer id;
    String name;

    public static GenderDto from(Gender gender) {
        if (gender == null) {
            return null;
        }
        return GenderDto.builder()
                .id(gender.getId())
                .name(gender.getName())
                .build();
    }
}
