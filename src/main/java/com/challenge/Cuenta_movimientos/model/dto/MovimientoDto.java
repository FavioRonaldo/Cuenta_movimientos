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
	
	private Integer Id;
	private LocalDate Fecha;
	private String tipoMovimiento;
	private Float Valor;
	private Float Saldo;
	private Integer Numero_cuenta;
}
