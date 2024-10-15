package com.challenge.Cuenta_movimientos.model.payload;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class MensajeRespons implements Serializable {
    private String mensaje;  
    private Object object;
}
