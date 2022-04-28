package com.laptop.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptop.domain.Laptop;
import com.laptop.domain.LaptopDataAdapter;

import java.util.List;

@Service
public class LaptopApi {

    private final LaptopDataAdapter laptopDataAdapter;

    @Autowired
    public LaptopApi(LaptopDataAdapter laptopDataAdapter) {
        this.laptopDataAdapter = laptopDataAdapter;
    }

    public String create(Laptop item) {
        return laptopDataAdapter.create(item);
    }

    public List<Laptop> getAll() {
        return laptopDataAdapter.getAll();
    }

    public Laptop getById(String id) {
        return laptopDataAdapter.getById(id);
    }

    public List<Laptop> getByType(String type) {
        return laptopDataAdapter.getByType(type);
    }

    public String updateById(Laptop item) {
        return laptopDataAdapter.updateById(item);
    }

    public String deleteById(String id) {
        return laptopDataAdapter.deleteById(id);
    }
}
