package com.sifox.shamedesk.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import com.sifox.shamedesk.dto.PersonDTO;
import com.sifox.shamedesk.model.Person;

/**
 * 
 * @Author Zaytsev Roman V.
 * @date 22.05.2017
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PersonMapper {

    public PersonDTO toDTO(Person person);

    public Person toEntity(PersonDTO person);

    public void mapToEntity(PersonDTO personDTO, @MappingTarget Person person);

}
