package com.challenge.Cuenta_movimientos.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.Cuenta_movimientos.model.dto.CuentaDto;
import com.challenge.Cuenta_movimientos.model.entity.Cuenta;
import com.challenge.Cuenta_movimientos.model.mappers.CuentaMapper;
import com.challenge.Cuenta_movimientos.model.payload.MensajeRespons;
import com.challenge.Cuenta_movimientos.service.ICuenta;

@RestController
@RequestMapping("/api/v1")
public class CuentaController {
	@Autowired
	private ICuenta cuentaService;
	@Autowired
	private CuentaMapper cuentaMapper;
	@PostMapping("cuenta")
	public ResponseEntity<?> create(@RequestBody CuentaDto cuentaDto) {		
		Cuenta cuentaSave = null;
        try {
        	cuentaSave = cuentaService.save(cuentaDto);
            return new ResponseEntity<>(MensajeRespons.builder()
                    .mensaje("Guardado correctamente")
                    .object(cuentaMapper.toDTO(cuentaSave))
                    .build()
                    , HttpStatus.CREATED);
        } catch (DataAccessException exDt) {
            return new ResponseEntity<>(
                    MensajeRespons.builder()
                            .mensaje(exDt.getMessage())
                            .object(null)
                            .build()
                    , HttpStatus.METHOD_NOT_ALLOWED);
        }
	}
	@PutMapping("cuenta/{id}")
	public ResponseEntity<?> update(@RequestBody CuentaDto cuentadto,@PathVariable Integer id) {
		Cuenta cuentaUpdate = null;
        try {
            if (cuentaService.existsById(id)) {
            	cuentadto.setId(id);
                cuentaUpdate = cuentaService.save(cuentadto);
                return new ResponseEntity<>(MensajeRespons.builder()
                        .mensaje("Guardado correctamente")
                        .object(cuentaMapper.toDTO(cuentaUpdate))
                        .build()
                        , HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(
                        MensajeRespons.builder()
                                .mensaje("El registro que intenta actualizar no se encuentra en la base de datos.")
                                .object(null)
                                .build()
                        , HttpStatus.NOT_FOUND);
            }
        } catch (DataAccessException exDt) {
            return new ResponseEntity<>(
                    MensajeRespons.builder()
                            .mensaje(exDt.getMessage())
                            .object(null)
                            .build()
                    , HttpStatus.METHOD_NOT_ALLOWED);
        }
		
	}
	@DeleteMapping("cuenta/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		 try {
	            Cuenta cuentaDelete = cuentaService.findById(id);
	            cuentaService.delete(cuentaDelete);
	            return new ResponseEntity<>(cuentaDelete, HttpStatus.NO_CONTENT);
	        } catch (DataAccessException exDt) {
	            return new ResponseEntity<>(
	                    MensajeRespons.builder()
	                            .mensaje(exDt.getMessage())
	                            .object(null)
	                            .build()
	                    , HttpStatus.METHOD_NOT_ALLOWED);
	        }
	}
	@GetMapping("cuenta/{id}")
	public ResponseEntity<?> showById(@PathVariable Integer id) {
		Cuenta cuenta = cuentaService.findById(id);

	        if (cuenta == null) {
	            return new ResponseEntity<>(
	                    MensajeRespons.builder()
	                            .mensaje("El registro que intenta buscar, no existe!!")
	                            .object(null)
	                            .build()
	                    , HttpStatus.NOT_FOUND);
	        }

	        return new ResponseEntity<>(
	                MensajeRespons.builder()
	                        .mensaje("")
	                        .object(cuentaMapper.toDTO(cuenta))
	                        .build()
	                , HttpStatus.OK);
	    }

	
}
