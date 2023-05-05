package com.example.demo.jpa;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoleRepository extends CrudRepository<Role, Long> {

    List<Role> findByName(String name);

    Role findById(long id);
}