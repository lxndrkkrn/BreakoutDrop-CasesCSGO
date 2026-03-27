package org.example.breakoutdrop.DTOs.Create;

import java.math.BigDecimal;

public record CreatePromoDTO(
        String code,
        BigDecimal factor
) { }
