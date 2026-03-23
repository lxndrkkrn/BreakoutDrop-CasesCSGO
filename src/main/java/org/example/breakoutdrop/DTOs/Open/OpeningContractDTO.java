package org.example.breakoutdrop.DTOs.Open;

import java.util.List;

public record OpeningContractDTO(
        Long userId,
        List<Long> skinId
) { }