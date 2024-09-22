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
import com.challenge.Cuenta_movimientos.model.payload.SaldoInsuficiente;
import com.challenge.Cuenta_movimientos.service.IMovimiento;

@Service
public class MovimientoImpl implements IMovimiento {

	@Autowired
	private MovimientoDao movimientoDao;
	@Autowired
	private MovimientoMapper movimientoMapper;
	@Autowired
	private CuentaDao cuentaDao;
	@Transactional
	public Movimiento save(MovimientoDto movimientodto) {
		 Movimiento movimiento = movimientoMapper.toEntity(movimientodto);
		 Cuenta cuenta=cuentaDao.findByNumeroCuenta(movimiento.getNumero_cuenta());
		 String tipoMovimiento=movimiento.getTipo_movimiento();
		 float saldo=0;
		 if(tipoMovimiento.equals("Deposito")) {
			  saldo =cuenta.getSaldo_Inicial()+movimiento.getValor();
		 }else {
			  saldo =cuenta.getSaldo_Inicial()-movimiento.getValor();
		 }		 
		 if(saldo>0) {
			 cuenta.setSaldo_Inicial(saldo);
			 	cuentaDao.save(cuenta);
			 	System.out.println(movimiento);
			 	movimiento.setSaldo(saldo);
			 	System.out.println(movimiento);
			    // Guardar la entidad   
			    return movimientoDao.save(movimiento);
		 }else {
			 throw new SaldoInsuficiente("Saldo insuficiente para realizar el movimiento.");
		 }
		
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
