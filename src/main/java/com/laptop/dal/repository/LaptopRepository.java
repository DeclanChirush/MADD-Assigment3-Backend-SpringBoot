package com.laptop.dal.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.laptop.dal.model.LaptopModel;

import java.util.List;

public interface LaptopRepository extends MongoRepository<LaptopModel, String> {

    List<LaptopModel> findByType(String type);
}
