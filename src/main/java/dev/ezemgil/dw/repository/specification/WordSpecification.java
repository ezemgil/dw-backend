package dev.ezemgil.dw.repository.specification;

import dev.ezemgil.dw.entity.Word;
import org.springframework.data.jpa.domain.Specification;

public class WordSpecification {

    public static Specification<Word> hasCategoryId(Integer categoryId) {
        return (root, query, builder) ->
                categoryId == null ? null : builder.equal(root.get("category").get("id"), categoryId);
    }

    public static Specification<Word> hasWordTypeId(Integer wordTypeId) {
        return (root, query, builder) ->
                wordTypeId == null ? null : builder.equal(root.get("wordType").get("id"), wordTypeId);
    }

    public static Specification<Word> hasGenderId(Integer genderId) {
        return (root, query, builder) ->
                genderId == null ? null : builder.equal(root.get("gender").get("id"), genderId);
    }

    public static Specification<Word> hasCefrLevel(String cefrLevel) {
        return (root, query, builder) ->
                (cefrLevel == null || cefrLevel.isEmpty()) ? null : builder.equal(root.get("cefrLevel"), cefrLevel);
    }
}
