package com.challenge.Cuenta_movimientos.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.challenge.Cuenta_movimientos.model.dao.CuentaDao;
import com.challenge.Cuenta_movimientos.model.dao.MovimientoDao;
import com.challenge.Cuenta_movimientos.model.dto.MovimientoDto;
import com.challenge.Cuenta_movimientos.model.entity.Cuenta;
import com.challenge.Cuenta_movimientos.model.entity.Movimiento;
import com.challenge.Cuenta_movimientos.model.entity.Reporte;
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
		 Cuenta cuenta=cuentaDao.findByNumeroCuenta(movimiento.getNumeroCuenta());
		 String tipoMovimiento=movimiento.getTipoMovimiento();
		 float saldo=0;
		 if(tipoMovimiento.equals("Deposito")) {
			  saldo =cuenta.getSaldo_Inicial()+movimiento.getValor();
		 }else {
			  saldo =cuenta.getSaldo_Inicial()-movimiento.getValor();
		 }		 
		 if(saldo>0) {
			 cuenta.setSaldo_Inicial(saldo);
			 	cuentaDao.save(cuenta);
			 	movimiento.setSaldo(saldo);
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

	@Override
	public List<Reporte> findAllByFechaBetween(LocalDate startDate, LocalDate endDate) {
		// TODO Auto-generated method stub
		List<Reporte> reporte = new ArrayList<>();
		List<Movimiento> movimientos= movimientoDao.findAllByFechaBetween(startDate,endDate);
		Iterator<Movimiento> iterator = movimientos.iterator();
		while (iterator.hasNext()) {
		    Movimiento movimiento = iterator.next();
		    // Aquí puedes acceder a cada movimiento
		    Cuenta cuenta=cuentaDao.findByNumeroCuenta(movimiento.getNumeroCuenta());
		    float valorInicial=cuenta.getSaldo_Inicial()-movimiento.getValor();		    
		    reporte.add(new Reporte(
		    		movimiento.getFecha(),
		    		cuenta.getCliente(),
		    		movimiento.getNumeroCuenta(),
		    		cuenta.getTipo(),
		    		valorInicial,
		    		cuenta.getEstado(),
		    		movimiento.getValor(),
		    		cuenta.getSaldo_Inicial()
		    		));
		}
		System.out.println(reporte);
		return reporte;
	}

}
