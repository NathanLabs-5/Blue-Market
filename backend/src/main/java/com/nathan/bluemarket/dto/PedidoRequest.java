package com.nathan.bluemarket.dto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.util.List;
public record PedidoRequest(@NotNull Long clienteId,@NotEmpty List<@Valid ItemCompraRequest> itens) {}
