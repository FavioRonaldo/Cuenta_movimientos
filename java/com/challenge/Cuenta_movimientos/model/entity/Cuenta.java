package com.challenge.Cuenta_movimientos.model.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name='Cuenta')
public class Cuenta implements Serializable{
	@Id
	@Column(name='numero_cuenta')
	private Integer numero_cuenta;
	@Column(name='tipo')
	private String tipo;
	@Column(name='saldo_Inicial')
	private Float saldo_Inicial;
	@Column(name='estado')
	private Boolean estado;
	@Column(name='cliente')
	private String cliente;	
	
}
