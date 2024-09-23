package com.challenge.Cuenta_movimientos.model.entity;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name= "movimiento")
public class Movimiento implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name="tipo_movimiento", columnDefinition = "VARCHAR(10) CHECK (tipo_movimiento IN ('DEPOSITO','RETIRO'))")
    
    private String tipoMovimiento;

    @Column(name = "valor")
    private Float valor;

    @Column(name = "saldo")
    private Float saldo;

    @Column(name = "numero_cuenta")
    private Integer numeroCuenta;
}

