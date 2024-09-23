package com.challenge.Cuenta_movimientos.model.dto;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class MovimientoDto implements Serializable{
	
	private Integer id;
	private LocalDate fecha;
	private String tipoMovimiento;
	private Float valor;
	private Float saldo;
	private Integer numeroCuenta;
}
