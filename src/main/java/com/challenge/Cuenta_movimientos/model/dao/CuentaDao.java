package com.challenge.Cuenta_movimientos.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.challenge.Cuenta_movimientos.model.entity.Cuenta;

public interface CuentaDao extends JpaRepository<Cuenta, Integer>{
	//@Query("SELECT numero_cuenta FROM Cuenta c WHERE c.numero_cuenta= :numero_cuenta")
	Cuenta findByNumeroCuenta(Integer numero_cuenta);
}
