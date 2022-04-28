package com.laptop.dal.adapter;

import com.laptop.dal.model.LaptopModel;
import com.laptop.dal.repository.LaptopRepository;
import com.laptop.domain.Laptop;
import com.laptop.domain.LaptopDataAdapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Component
public class LaptopAdapterImpl implements LaptopDataAdapter {

    private final LaptopRepository repository;
    private final MongoTemplate mongoTemplate;

    @Autowired
    public LaptopAdapterImpl(LaptopRepository repository, MongoTemplate mongoTemplate) {
        this.repository = repository;
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public String create(Laptop laptop) {
        LaptopModel laptopModel = new LaptopModel();

        try {
            laptopModel.setName(laptop.getName());
            laptopModel.setCode(laptop.getCode());
            laptopModel.setAvailableUnit(laptop.getAvailableUnit());
            laptopModel.setPrice(laptop.getPrice());
            laptopModel.setTaxPrice(laptop.getTaxPrice());
            laptopModel.setProductDescription(laptop.getProductDescription());
            laptopModel.setImagePath(laptop.getImagePath());
            laptopModel.setType(laptop.getType());
            laptopModel.setDatetime(laptop.getDatetime());

            laptopModel = repository.save(laptopModel);

            return "Laptop " + laptopModel.getName() + " Create Success!";
        } catch (Exception e) {
            return "Laptop Create Failed!";
        }
    }

    @Override
    public List<Laptop> getAll() {
        List<Laptop> laptops = new ArrayList<>();

        try {
            List<LaptopModel> laptopModels = repository.findAll();

            for (LaptopModel laptopModel : laptopModels) {
                Laptop laptop = new Laptop();

                laptop.setId(laptopModel.getId());
                laptop.setName(laptopModel.getName());
                laptop.setCode(laptopModel.getCode());
                laptop.setAvailableUnit(laptopModel.getAvailableUnit());
                laptop.setPrice(laptopModel.getPrice());
                laptop.setTaxPrice(laptopModel.getTaxPrice());
                laptop.setProductDescription(laptopModel.getProductDescription());
                laptop.setImagePath(laptopModel.getImagePath());
                laptop.setType(laptopModel.getType());
                laptop.setDatetime(laptopModel.getDatetime());

                laptops.add(laptop);
            }
            return laptops;
        } catch (Exception e) {
            return laptops;
        }
    }

    @Override
    public Laptop getById(String id) {
        LaptopModel laptopModel;
        Laptop laptop = new Laptop();

        try {
        	
	            laptopModel = repository.findById(id).get();
	
	            laptop.setId(laptopModel.getId());
	            laptop.setName(laptopModel.getName());
	            laptop.setCode(laptopModel.getCode());
	            laptop.setAvailableUnit(laptopModel.getAvailableUnit());
	            laptop.setPrice(laptopModel.getPrice());
	            laptop.setTaxPrice(laptopModel.getTaxPrice());
	            laptop.setProductDescription(laptopModel.getProductDescription());
	            laptop.setImagePath(laptopModel.getImagePath());
	            laptop.setType(laptopModel.getType());
	            laptop.setDatetime(laptopModel.getDatetime());

            return laptop;
        } catch (NoSuchElementException e) {
            return laptop;
        }
    }

    @Override
    public List<Laptop> getByType(String type) {
        List<Laptop> laptops = new ArrayList<>();

        try {
        	
	            List<LaptopModel> laptopModels = repository.findByType(type);
	
	            for (LaptopModel laptopModel : laptopModels) {
	                Laptop laptop = new Laptop();
	
	                laptop.setId(laptopModel.getId());
	                laptop.setName(laptopModel.getName());
	                laptop.setCode(laptopModel.getCode());
	                laptop.setAvailableUnit(laptopModel.getAvailableUnit());
	                laptop.setPrice(laptopModel.getPrice());
	                laptop.setTaxPrice(laptopModel.getTaxPrice());
	                laptop.setProductDescription(laptopModel.getProductDescription());
	                laptop.setImagePath(laptopModel.getImagePath());
	                laptop.setType(laptopModel.getType());
	                laptop.setDatetime(laptopModel.getDatetime());
	
	                laptops.add(laptop);
            }
            return laptops;
        } catch (Exception e) {
            return laptops;
        }
    }

    @Override
    public String updateById(Laptop laptop) {
        try {
	            LaptopModel laptopModel = mongoTemplate.findAndModify(
	                    Query.query(Criteria.where("id").is(laptop.getId())),
	                    new Update()
	                            .set("name", laptop.getName())
	                            .set("code", laptop.getCode())
	                            .set("availableUnit", laptop.getAvailableUnit())
	                            .set("price", laptop.getPrice())
	                            .set("taxPrice", laptop.getTaxPrice())
	                            .set("productDescription", laptop.getProductDescription())
	                            .set("imagePath", laptop.getImagePath())
	                            .set("type", laptop.getType())
	                            .set("datetime", laptop.getDatetime()),
	                    LaptopModel.class
            );

            if (laptopModel != null) {
                return "Laptop " + laptop.getName() + " Update Success!";
            } else {
                return "Laptop does not exist!";
            }
        } catch (Exception e) {
            return "Laptop update Failed!";
        }
    }

    @Override
    public String deleteById(String id) {
        LaptopModel laptopModel = null;

        try {
	            laptopModel = repository.findById(id).get();
	            if (laptopModel != null) {
	                repository.deleteById(id);
	                return "Laptop "+ laptopModel.getName() + " Delete Success!";
	            } else {
	                return "Laptop does not exist!";
	            }
        } catch (NoSuchElementException e) {
            return "Laptop delete Failed!";
        }
    }
}
