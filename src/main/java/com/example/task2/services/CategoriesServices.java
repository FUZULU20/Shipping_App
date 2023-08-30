package com.example.task2.services;

import com.example.task2.dto.CategoriesDto;
import com.example.task2.dto.request.CategoriesRequest;
import com.example.task2.model.Categories;

import java.util.List;

public interface CategoriesServices {

    CategoriesDto getCategoriesById(Long id);

    void saveCategories(CategoriesRequest categoriesRequest);

    void updateCategories(CategoriesRequest categoriesRequest);

    void deleteById(Long id);

    List<CategoriesDto> getAll();

}
