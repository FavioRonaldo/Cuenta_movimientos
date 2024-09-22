package com.challenge.Cuenta_movimientos.model.dto;

import java.io.Serializable;
import java.sql.Date;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class MovimientoDto implements Serializable{
	
	private Integer Id;
	private Date Fecha;
	private String Tipo_movimiento;
	private Float Valor;
	private Float Saldo;
	private Integer Numero_cuenta;
}
