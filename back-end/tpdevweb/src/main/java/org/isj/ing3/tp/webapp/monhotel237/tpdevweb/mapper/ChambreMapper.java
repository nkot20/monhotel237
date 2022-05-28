package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.mapper;

import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.mapper.EntityMapper;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.ChambreDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities.Chambre;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy =  NullValueCheckStrategy.ALWAYS)
public interface ChambreMapper extends EntityMapper<ChambreDto, Chambre> {
}