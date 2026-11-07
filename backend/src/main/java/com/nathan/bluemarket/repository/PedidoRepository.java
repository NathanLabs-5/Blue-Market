package com.nathan.bluemarket.repository;

import com.nathan.bluemarket.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByClienteIdOrderByCriadoEmDesc(Long clienteId);
}
