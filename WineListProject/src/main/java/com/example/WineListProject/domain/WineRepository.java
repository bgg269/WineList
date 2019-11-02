package com.example.WineListProject.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface WineRepository extends CrudRepository<Wine, Long>{

    List<Wine> findByName(String name);

}
