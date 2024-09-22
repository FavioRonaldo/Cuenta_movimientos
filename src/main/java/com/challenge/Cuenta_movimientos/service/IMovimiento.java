package com.challenge.Cuenta_movimientos.service;


import java.time.LocalDate;
import java.util.List;

import com.challenge.Cuenta_movimientos.model.dto.MovimientoDto;
import com.challenge.Cuenta_movimientos.model.entity.Movimiento;
import com.challenge.Cuenta_movimientos.model.entity.Reporte;

public interface  IMovimiento {
	Movimiento save(MovimientoDto movimientodto);	
	Movimiento findByID(Integer numero_cuenta);
	//List<Cuenta> findAllByFechaBetween(Date fechaInicio, Date fechaFin);
	void delete(Movimiento movimiento);
	boolean existsById(Integer id);
	Movimiento findById(Integer id);
	List<Reporte> findAllByFechaBetween(LocalDate startDate, LocalDate endDate );
}
