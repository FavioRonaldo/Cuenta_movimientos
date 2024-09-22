package com.challenge.Cuenta_movimientos.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.challenge.Cuenta_movimientos.model.entity.Cuenta;
import com.challenge.Cuenta_movimientos.model.entity.Movimiento;

public interface MovimientoDao extends JpaRepository<Movimiento, Integer>{
	/*@Query("SELECT * FROM Movimiento e WHERE e.fecha BETWEEN :fechaInicio AND :fechaFin")
	List<Cuenta> findAllByFechaBetween(@Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin);*/

}
