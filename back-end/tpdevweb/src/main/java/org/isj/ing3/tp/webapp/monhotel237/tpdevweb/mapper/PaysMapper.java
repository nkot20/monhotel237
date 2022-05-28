package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.mapper;

import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.mapper.EntityMapper;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.PaysDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities.Pays;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy =  NullValueCheckStrategy.ALWAYS)
public interface PaysMapper extends EntityMapper<PaysDto, Pays> {
}