package com.laptop.domain;

import java.util.List;

public interface LaptopDataAdapter {

    public String create(Laptop item);

    public List<Laptop> getAll();

    public Laptop getById(String id);

    public List<Laptop> getByType(String type);

    public String updateById(Laptop item);

    public String deleteById(String id);
}
