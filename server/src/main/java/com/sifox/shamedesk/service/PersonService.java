package com.sifox.shamedesk.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sifox.shamedesk.dto.PersonDTO;

public interface PersonService {

    Page<PersonDTO> personList(Pageable pageable);

    PersonDTO getPerson(Long id);

    void updatePerson(PersonDTO personDTO);

    void savePerson(PersonDTO personDTO);

    void deletePerson(Long id);

}
