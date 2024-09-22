package com.challenge.Cuenta_movimientos.service.impl;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.challenge.Cuenta_movimientos.model.dao.CuentaDao;
import com.challenge.Cuenta_movimientos.model.dto.CuentaDto;
import com.challenge.Cuenta_movimientos.model.entity.Cuenta;
import com.challenge.Cuenta_movimientos.model.mappers.CuentaMapper;
import com.challenge.Cuenta_movimientos.service.ICuenta;
@Service
public class CuentaImpl implements ICuenta{
	@Autowired
	private CuentaDao cuentaDao;
	@Autowired
	private CuentaMapper cuentaMapper;
	@Transactional
	public Cuenta save(CuentaDto cuentadto) {
	    // Convertir DTO a entidad
		//System.out.println(cuentadto);
	    Cuenta cuenta = cuentaMapper.toEntity(cuentadto);
	   // System.out.println("Cuenta mapeada: " + cuenta);
	    // Guardar la entidad   
	    return cuentaDao.save(cuenta);
	}
	@Transactional(readOnly=true)
	@Override
	public Cuenta findByID(Integer numero_cuenta) {
		// TODO Auto-generated method stub
		
		return cuentaDao.findById(numero_cuenta).orElse(null);
	}
	/*@Transactional(readOnly=true)
	@Override
	public List<Cuenta> findAllByFechaBetween(Date fechaInicio, Date fechaFin) {
		// TODO Auto-generated method stub
		return cuentaDao.findAllByFechaBetween(fechaInicio, fechaFin);
	}*/
	@Transactional
	@Override
	public void delete(Cuenta cuenta) {
		// TODO Auto-generated method stub
		cuentaDao.delete(cuenta);
		
	}
	 @Override
	    public boolean existsById(Integer id) {
	        return cuentaDao.existsById(id);
	    }
	 @Transactional(readOnly = true)
	    @Override
	    public Cuenta findById(Integer id) {
	        return cuentaDao.findById(id).orElse(null);
	    }

	

}
