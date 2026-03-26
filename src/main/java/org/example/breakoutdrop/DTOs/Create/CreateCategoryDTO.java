package org.example.breakoutdrop.DTOs.Create;

import org.example.breakoutdrop.Enums.CategoryType;

public record CreateCategoryDTO(
        String title,
        CategoryType categoryType
) { }
