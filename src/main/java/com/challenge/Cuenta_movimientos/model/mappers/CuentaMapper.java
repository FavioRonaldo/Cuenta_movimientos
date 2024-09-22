package com.challenge.Cuenta_movimientos.model.mappers;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.challenge.Cuenta_movimientos.model.dto.CuentaDto;
import com.challenge.Cuenta_movimientos.model.entity.Cuenta;

@Mapper(componentModel = "spring")
public abstract class CuentaMapper {
	//private CuentaMapper INSTANCE = Mappers.getMapper(CuentaMapper.class);

	// Mapea de entidad a DTO
	public abstract CuentaDto toDTO(Cuenta cuenta);

	// Mapea de DTO a entidad
	public abstract Cuenta toEntity(CuentaDto cuentaDto);

	
}


