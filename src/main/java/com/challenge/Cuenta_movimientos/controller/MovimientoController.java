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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.Cuenta_movimientos.model.dao.MovimientoDao;
import com.challenge.Cuenta_movimientos.model.dto.MovimientoDto;
import com.challenge.Cuenta_movimientos.model.entity.Movimiento;
import com.challenge.Cuenta_movimientos.model.mappers.MovimientoMapper;
import com.challenge.Cuenta_movimientos.model.payload.MensajeResponse;
import com.challenge.Cuenta_movimientos.model.payload.SaldoInsuficiente;
import com.challenge.Cuenta_movimientos.service.IMovimiento;


@RestController
@RequestMapping("/api/v1")
public class MovimientoController {

	@Autowired
	private IMovimiento movimientoService;
	@Autowired
	private MovimientoMapper movimientoMapper;
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("movimiento")
	public ResponseEntity<?> create(@RequestBody MovimientoDto movimientoDto) {		
		Movimiento movimientoSave = null;
        try {
        	movimientoSave = movimientoService.save(movimientoDto);
            return new ResponseEntity<>(MensajeResponse.builder()
                    .mnesaje("Guardado correctamente")
                    .object(movimientoMapper.toDTO(movimientoSave))
                    .build()
                    , HttpStatus.CREATED);
        }catch (SaldoInsuficiente ex) {
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                    .mnesaje(ex.getMessage())
                    .object(null)
                    .build(), HttpStatus.BAD_REQUEST); 
		}catch (DataAccessException exDt) {
	            return new ResponseEntity<>(
	                    MensajeResponse.builder()
	                            .mnesaje(exDt.getMessage())
	                            .object(null)
	                            .build()
	                    , HttpStatus.METHOD_NOT_ALLOWED);
	        }
	}
	@PutMapping("movimiento/{id}")
	public ResponseEntity<?> update(@RequestBody MovimientoDto movimientoDto,@PathVariable Integer id) {
		Movimiento movimientoUpdate = null;
        try {
            if (movimientoService.existsById(id)) {
            	movimientoDto.setId(id);
            	movimientoUpdate = movimientoService.save(movimientoDto);
                return new ResponseEntity<>(MensajeResponse.builder()
                        .mnesaje("Guardado correctamente")
                        .object(movimientoMapper.toDTO(movimientoUpdate))
                        .build()
                        , HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(
                        MensajeResponse.builder()
                                .mnesaje("El registro que intenta actualizar no se encuentra en la base de datos.")
                                .object(null)
                                .build()
                        , HttpStatus.NOT_FOUND);
            }
        } catch (DataAccessException exDt) {
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .mnesaje(exDt.getMessage())
                            .object(null)
                            .build()
                    , HttpStatus.METHOD_NOT_ALLOWED);
        }
		
	}
	@DeleteMapping("movimiento/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		 try {
	            Movimiento movimientoDelete = movimientoService.findById(id);
	            movimientoService.delete(movimientoDelete);
	            return new ResponseEntity<>(movimientoDelete, HttpStatus.NO_CONTENT);
	        } catch (DataAccessException exDt) {
	            return new ResponseEntity<>(
	                    MensajeResponse.builder()
	                            .mnesaje(exDt.getMessage())
	                            .object(null)
	                            .build()
	                    , HttpStatus.METHOD_NOT_ALLOWED);
	        }
	}
	@GetMapping("movimiento/{id}")
	public ResponseEntity<?> showById(@PathVariable Integer id) {
		Movimiento movimiento = movimientoService.findById(id);

	        if (movimiento == null) {
	            return new ResponseEntity<>(
	                    MensajeResponse.builder()
	                            .mnesaje("El registro que intenta buscar, no existe!!")
	                            .object(null)
	                            .build()
	                    , HttpStatus.NOT_FOUND);
	        }

	        return new ResponseEntity<>(
	                MensajeResponse.builder()
	                        .mnesaje("")
	                        .object(movimientoMapper.toDTO(movimiento))
	                        .build()
	                , HttpStatus.OK);
	    }

}
