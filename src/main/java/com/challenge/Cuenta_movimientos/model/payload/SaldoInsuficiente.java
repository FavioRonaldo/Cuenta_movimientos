package com.challenge.Cuenta_movimientos.model.payload;

public class SaldoInsuficiente extends RuntimeException{
	    

		public SaldoInsuficiente(String message) {
	        super(message);
	    }

}
