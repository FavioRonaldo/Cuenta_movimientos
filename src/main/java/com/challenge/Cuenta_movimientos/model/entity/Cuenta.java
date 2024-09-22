package com.challenge.Cuenta_movimientos.model.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="Cuenta")
public class Cuenta implements Serializable{
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	@Column(name="numero_cuenta")
	private Integer Numero_cuenta;
	@Column(name="tipo")
	private String Tipo;
	@Column(name="saldo_Inicial")
	private Float Saldo_Inicial;
	@Column(name="estado")
	private Boolean Estado;
	@Column(name="cliente")
	private String Cliente;	
	
}
