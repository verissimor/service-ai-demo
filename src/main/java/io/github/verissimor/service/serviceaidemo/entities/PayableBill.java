package io.github.verissimor.service.serviceaidemo.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

public record PayableBill(
        Long id,
        String description,
        LocalDate date,
        BigDecimal value,
        Long categoryId,
        Long supplierId
) {
}
