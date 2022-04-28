package com.laptop.controller;

import com.laptop.api.LaptopApi;
import com.laptop.domain.Laptop;
import com.laptop.dto.LaptopDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/laptop")
@CrossOrigin(origins = "*", allowedHeaders = "*", exposedHeaders = "*")
public class LaptopController {

    private final LaptopApi laptopApi;

    @Autowired
    public LaptopController(LaptopApi laptopApi) {
        this.laptopApi = laptopApi;
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@RequestBody LaptopDto itemDto) {
        Laptop laptop = new Laptop();

        laptop.setName(itemDto.getName());
        laptop.setCode(itemDto.getCode());
        laptop.setAvailableUnit(itemDto.getAvailableUnit());
        laptop.setPrice(itemDto.getPrice());
        laptop.setTaxPrice(itemDto.getTaxPrice());
        laptop.setProductDescription(itemDto.getProductDescription());
        laptop.setImagePath(itemDto.getImagePath());
        laptop.setType(itemDto.getType());
        laptop.setDatetime(LocalDateTime.now());

        return laptopApi.create(laptop);
    }

    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<Laptop> getAll() {
        return laptopApi.getAll();
    }

    @GetMapping("/getById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Laptop getById(@PathVariable String id) {
        return laptopApi.getById(id);
    }

    @GetMapping("/getByType/{type}")
    @ResponseStatus(HttpStatus.OK)
    public List<Laptop> getByType(@PathVariable String type) {
        return laptopApi.getByType(type);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public String updateById(@RequestBody LaptopDto laptopDto) {
        Laptop laptop = new Laptop();

        laptop.setId(laptopDto.getId());
        laptop.setName(laptopDto.getName());
        laptop.setCode(laptopDto.getCode());
        laptop.setAvailableUnit(laptopDto.getAvailableUnit());
        laptop.setPrice(laptopDto.getPrice());
        laptop.setTaxPrice(laptopDto.getTaxPrice());
        laptop.setProductDescription(laptopDto.getProductDescription());
        laptop.setImagePath(laptopDto.getImagePath());
        laptop.setType(laptopDto.getType());
        laptop.setDatetime(LocalDateTime.now());

        return laptopApi.updateById(laptop);
    }

    @DeleteMapping("/deleteById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteById(@PathVariable String id) {
        return laptopApi.deleteById(id);
    }
}
