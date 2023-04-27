package br.com.zubcovsoft.financas.domain.renda.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class RendaFilter {
    private UUID categoria;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate data;
}
