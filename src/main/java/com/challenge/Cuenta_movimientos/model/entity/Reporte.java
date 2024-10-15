package com.challenge.Cuenta_movimientos.model.entity;

import java.time.LocalDate;

public class Reporte {
	private LocalDate fecha;
    private String cliente;
    private Integer numeroCuenta;
    private String tipo;
    private Float saldoInicial;
    private Boolean estado;
    private Float valor;
    private Float saldo_Inicial;
    private String tipo_movimiento;

    // Constructor
    public Reporte(LocalDate fecha, String cliente, Integer numeroCuenta, String tipo, Float saldoInicial, Boolean estado, Float movimiento, Float saldoDisponible, String tipo_movimiento) {
        this.fecha = fecha;
        this.cliente = cliente;
        this.numeroCuenta = numeroCuenta;
        this.tipo = tipo;
        this.saldoInicial = saldoInicial;
        this.estado = estado;
        this.valor = movimiento;
        this.saldo_Inicial = saldoDisponible;
        this.tipo_movimiento= tipo_movimiento;
    }

	// Getters y setters
    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Integer getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(Integer numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Float getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(Float saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Float getMovimiento() {
        return valor;
    }

    public void setMovimiento(Float movimiento) {
        this.valor = movimiento;
    }

    public Float getSaldoDisponible() {
        return saldo_Inicial;
    }

    public void setSaldoDisponible(Float saldoDisponible) {
        this.saldo_Inicial = saldoDisponible;
    }
    public String getTipo_movimiento() {
        return tipo_movimiento;
    }

    public void setTipo_movimiento(String tipo_movimiento) {
        this.tipo_movimiento = tipo_movimiento;
    }

    // Método toString para visualizar el reporte
    @Override
    public String toString() {
        return "{\n" +
                "\"Fecha\":\"" + fecha + "\",\n" +
                "\"Cliente\":\"" + cliente + "\",\n" +
                "\"Numero Cuenta\":\"" + numeroCuenta + "\",\n" +
                "\"Tipo\":\"" + tipo + "\",\n" +
                "\"Saldo Inicial\":" + saldoInicial + ",\n" +
                "\"Estado\":" + estado + ",\n" +
                "\"Movimiento\":" + valor + ",\n" +
                "\"Saldo Disponible\":" + saldo_Inicial + "\n" +
                "\"Tipo de Movimiento\":" + tipo_movimiento + "\n" +
                "}";
    }
}
