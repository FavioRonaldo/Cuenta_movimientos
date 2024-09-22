package com.challenge.Cuenta_movimientos.model.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.challenge.Cuenta_movimientos.model.entity.Cuenta;

public interface CuentaDao extends JpaRepository<Cuenta, Integer>{

}
