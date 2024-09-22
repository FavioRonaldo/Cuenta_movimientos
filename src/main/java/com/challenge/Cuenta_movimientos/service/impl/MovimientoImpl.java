package com.challenge.Cuenta_movimientos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.challenge.Cuenta_movimientos.model.dao.CuentaDao;
import com.challenge.Cuenta_movimientos.model.dao.MovimientoDao;
import com.challenge.Cuenta_movimientos.model.dto.MovimientoDto;
import com.challenge.Cuenta_movimientos.model.entity.Cuenta;
import com.challenge.Cuenta_movimientos.model.entity.Movimiento;
import com.challenge.Cuenta_movimientos.model.mappers.CuentaMapper;
import com.challenge.Cuenta_movimientos.model.mappers.MovimientoMapper;
import com.challenge.Cuenta_movimientos.service.IMovimiento;

@Service
public class MovimientoImpl implements IMovimiento {

	@Autowired
	private MovimientoDao movimientoDao;
	@Autowired
	private MovimientoMapper movimientoMapper;
	@Transactional
	public Movimiento save(MovimientoDto movimientodto) {
		 Movimiento movimiento = movimientoMapper.toEntity(movimientodto);
		    // Guardar la entidad   
		    return movimientoDao.save(movimiento);
	}

	@Override
	public Movimiento findByID(Integer numero_cuenta) {
		// TODO Auto-generated method stub
		return movimientoDao.findById(numero_cuenta).orElse(null);
	}

	@Override
	public void delete(Movimiento movimiento) {
		// TODO Auto-generated method stub
		movimientoDao.delete(movimiento);
	}

	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return movimientoDao.existsById(id);
	}

	@Override
	public Movimiento findById(Integer id) {
		// TODO Auto-generated method stub
		return movimientoDao.findById(id).orElse(null);
	}

}
