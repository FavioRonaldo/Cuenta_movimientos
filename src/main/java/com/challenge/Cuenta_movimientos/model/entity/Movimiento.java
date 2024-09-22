package com.challenge.Cuenta_movimientos.model.entity;

import java.sql.Date;

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
@Table(name="movimiento")
public class Movimiento {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	@Column(name="fecha")
	private Date Fecha;
	@Column(name="tipo_movimiento")
	private String Tipo_movimiento;
	@Column(name="valor")
	private Float Valor;
	@Column(name="saldo")
	private Float Saldo;
	
	
}
