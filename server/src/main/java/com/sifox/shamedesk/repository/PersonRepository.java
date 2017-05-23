package com.sifox.shamedesk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sifox.shamedesk.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long>, PersonRepositoryCustom {

}
