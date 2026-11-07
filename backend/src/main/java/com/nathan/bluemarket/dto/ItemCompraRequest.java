package com.nathan.bluemarket.dto;
import jakarta.validation.constraints.*;
public record ItemCompraRequest(@NotNull Long produtoId,@NotNull @Min(1) Integer quantidade) {}
