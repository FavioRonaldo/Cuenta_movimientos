package com.challenge.Cuenta_movimientos.model.mappers;

import org.mapstruct.Mapper;

import com.challenge.Cuenta_movimientos.model.dto.MovimientoDto;
import com.challenge.Cuenta_movimientos.model.entity.Movimiento;

@Mapper(componentModel = "spring")
public abstract class MovimientoMapper {
	// Mapea de entidad a DTO
		public abstract MovimientoDto toDTO(Movimiento movimiento);

		// Mapea de DTO a entidad
		public abstract Movimiento toEntity(MovimientoDto movimientoDto);

}
