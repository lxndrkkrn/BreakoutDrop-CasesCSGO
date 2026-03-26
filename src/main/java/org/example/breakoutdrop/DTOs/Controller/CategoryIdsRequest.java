package org.example.breakoutdrop.DTOs.Controller;

import java.util.List;

public record CategoryIdsRequest(
        List<Long> categoryIdsRequest
) { }
