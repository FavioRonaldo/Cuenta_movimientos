package com.challenge.Cuenta_movimientos.service;


import com.challenge.Cuenta_movimientos.model.dto.CuentaDto;
import com.challenge.Cuenta_movimientos.model.entity.Cuenta;

public interface ICuenta {
	Cuenta save(CuentaDto cuentadto);	
	//List<Cuenta> findAllByFechaBetween(Date fechaInicio, Date fechaFin);
	void delete(Cuenta cuenta);
	boolean existsById(Integer id);
	Cuenta findById(Integer id);
}
