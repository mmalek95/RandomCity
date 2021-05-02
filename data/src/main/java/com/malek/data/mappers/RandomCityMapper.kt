package com.malek.data.mappers

import com.malek.data.models.dtos.RandomCityDto
import com.malek.data.models.entities.RandomCityEntity
import com.malek.domain.models.RandomCity
import org.mapstruct.InheritInverseConfiguration
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper
interface RandomCityMapper {

    @Mapping(target = "dbId", ignore = true)
    fun dtoToEntity(randomCity: RandomCityDto?) : RandomCityEntity?

    @InheritInverseConfiguration
    fun entityToDto(randomCity: RandomCityEntity?) : RandomCityDto?

    fun entityToDomain(randomCity: RandomCityEntity?) : RandomCity?
}