package com.challenge.Cuenta_movimientos.service;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.challenge.Cuenta_movimientos.model.dto.CuentaDto;
import com.challenge.Cuenta_movimientos.model.entity.Cuenta;

public interface ICuenta {
	Cuenta save(CuentaDto cuentadto);	
	Cuenta findByID(Integer numero_cuenta);
	//List<Cuenta> findAllByFechaBetween(Date fechaInicio, Date fechaFin);
	void delete(Cuenta cuenta);
	boolean existsById(Integer id);
	Cuenta findById(Integer id);
}
