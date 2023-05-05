package com.example.demo.jpa;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EGGUserRepository extends CrudRepository<EGGUser, Long> {

    List<EGGUser> findByLastName(String lastName);

    EGGUser findById(long id);
}
