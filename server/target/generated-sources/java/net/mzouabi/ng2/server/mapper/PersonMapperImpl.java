package net.mzouabi.ng2.server.mapper;

import javax.annotation.Generated;

import org.springframework.stereotype.Component;

import com.sifox.shamedesk.dto.PersonDTO;
import com.sifox.shamedesk.mapper.PersonMapper;
import com.sifox.shamedesk.model.Person;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2017-05-23T17:48:03+0300",
    comments = "version: 1.0.0.Final, compiler: javac, environment: Java 1.8.0_121 (Oracle Corporation)"
)
@Component
public class PersonMapperImpl implements PersonMapper {

    @Override
    public PersonDTO toDTO(Person person) {
        if ( person == null ) {
            return null;
        }

        PersonDTO personDTO = new PersonDTO();

        personDTO.setId( person.getId() );
        personDTO.setLogin( person.getLogin() );
        personDTO.setName( person.getName() );
        personDTO.setScore( person.getScore() );
        personDTO.setComment( person.getComment() );

        return personDTO;
    }

    @Override
    public Person toEntity(PersonDTO person) {
        if ( person == null ) {
            return null;
        }

        Person person_ = new Person();

        person_.setId( person.getId() );
        person_.setLogin( person.getLogin() );
        person_.setName( person.getName() );
        person_.setScore( person.getScore() );
        person_.setComment( person.getComment() );

        return person_;
    }

    @Override
    public void mapToEntity(PersonDTO personDTO, Person person) {
        if ( personDTO == null ) {
            return;
        }

        person.setId( personDTO.getId() );
        person.setLogin( personDTO.getLogin() );
        person.setName( personDTO.getName() );
        person.setScore( personDTO.getScore() );
        person.setComment( personDTO.getComment() );
    }
}
