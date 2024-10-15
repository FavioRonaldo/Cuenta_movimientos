package com.challenge.Cuenta_movimientos.model.dto;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;


@Data
@ToString
@Builder
public class CuentaDto implements Serializable{


	private Integer id;
	private Integer numeroCuenta;
	private String tipo;
	private Float saldo_Inicial;
	private Boolean estado;
	private String cliente;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getNumeroCuenta() {
		return numeroCuenta;
	}
	public void setNumeroCuenta(Integer numero_cuenta) {
		this.numeroCuenta = numero_cuenta;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Float getSaldo_Inicial() {
		return saldo_Inicial;
	}
	public void setSaldo_Inicial(Float saldo_Inicial) {
		this.saldo_Inicial = saldo_Inicial;
	}
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}	
	
}
