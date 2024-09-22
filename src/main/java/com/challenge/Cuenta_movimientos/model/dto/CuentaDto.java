package com.challenge.Cuenta_movimientos.model.dto;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;


@Data
@ToString
@Builder
public class CuentaDto implements Serializable{


	private Integer Id;
	private Integer numeroCuenta;
	private String Tipo;
	private Float Saldo_Inicial;
	private Boolean Estado;
	private String Cliente;
	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		this.Id = id;
	}
	public Integer getNumeroCuenta() {
		return numeroCuenta;
	}
	public void setNumeroCuenta(Integer numero_cuenta) {
		this.numeroCuenta = numero_cuenta;
	}
	public String getTipo() {
		return Tipo;
	}
	public void setTipo(String tipo) {
		this.Tipo = tipo;
	}
	public Float getSaldo_Inicial() {
		return Saldo_Inicial;
	}
	public void setSaldo_Inicial(Float saldo_Inicial) {
		this.Saldo_Inicial = saldo_Inicial;
	}
	public Boolean getEstado() {
		return Estado;
	}
	public void setEstado(Boolean estado) {
		this.Estado = estado;
	}
	public String getCliente() {
		return Cliente;
	}
	public void setCliente(String cliente) {
		this.Cliente = cliente;
	}	
	
}
