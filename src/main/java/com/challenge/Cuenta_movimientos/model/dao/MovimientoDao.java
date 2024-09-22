package com.challenge.Cuenta_movimientos.model.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.challenge.Cuenta_movimientos.model.entity.Cuenta;
import com.challenge.Cuenta_movimientos.model.entity.Movimiento;

public interface MovimientoDao extends JpaRepository<Movimiento, Integer>{
	 List<Movimiento> findAllByFechaBetween(LocalDate startDate, LocalDate endDate);
}
