package com.challenge.Cuenta_movimientos.model.entity;

import java.time.LocalDate;

public class Reporte {
	private LocalDate fecha;
    private String Cliente;
    private Integer numeroCuenta;
    private String Tipo;
    private Float saldoInicial;
    private Boolean Estado;
    private Float valor;
    private Float Saldo_Inicial;

    // Constructor
    public Reporte(LocalDate fecha, String cliente, Integer numeroCuenta, String tipo, Float saldoInicial, Boolean estado, Float movimiento, Float saldoDisponible) {
        this.fecha = fecha;
        this.Cliente = cliente;
        this.numeroCuenta = numeroCuenta;
        this.Tipo = tipo;
        this.saldoInicial = saldoInicial;
        this.Estado = estado;
        this.valor = movimiento;
        this.Saldo_Inicial = saldoDisponible;
    }

	// Getters y setters
    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getCliente() {
        return Cliente;
    }

    public void setCliente(String cliente) {
        this.Cliente = cliente;
    }

    public Integer getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(Integer numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        this.Tipo = tipo;
    }

    public Float getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(Float saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public Boolean getEstado() {
        return Estado;
    }

    public void setEstado(Boolean estado) {
        this.Estado = estado;
    }

    public Float getMovimiento() {
        return valor;
    }

    public void setMovimiento(Float movimiento) {
        this.valor = movimiento;
    }

    public Float getSaldoDisponible() {
        return Saldo_Inicial;
    }

    public void setSaldoDisponible(Float saldoDisponible) {
        this.Saldo_Inicial = saldoDisponible;
    }

    // Método toString para visualizar el reporte
    @Override
    public String toString() {
        return "{\n" +
                "\"Fecha\":\"" + fecha + "\",\n" +
                "\"Cliente\":\"" + Cliente + "\",\n" +
                "\"Numero Cuenta\":\"" + numeroCuenta + "\",\n" +
                "\"Tipo\":\"" + Tipo + "\",\n" +
                "\"Saldo Inicial\":" + saldoInicial + ",\n" +
                "\"Estado\":" + Estado + ",\n" +
                "\"Movimiento\":" + valor + ",\n" +
                "\"Saldo Disponible\":" + Saldo_Inicial + "\n" +
                "}";
    }
}
