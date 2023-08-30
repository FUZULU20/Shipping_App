package com.example.task2.controller;

import com.example.task2.dto.CategoriesDto;
import com.example.task2.dto.request.CategoriesRequest;
import com.example.task2.services.CategoriesServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/categories")
public class CategoriesController {

    final CategoriesServices categoriesServices;

    @GetMapping(value = "/categoriesList")
    public List<CategoriesDto> getCategoriesInfo() {return categoriesServices.getAll();}

    @GetMapping(value = "/getCategoriesById/{id}")
    public CategoriesDto getCategoriesById(@PathVariable(value = "id") Long id){
        return getCategoriesById(id);
    }

    @PostMapping(value = "/saveCategories")
    public void saveCategories(@RequestBody CategoriesRequest categoriesRequest){
        categoriesServices.saveCategories(categoriesRequest);
    }

    @PostMapping(value = "/updateCategories")
    public void updateCategories(@RequestBody CategoriesRequest categoriesRequest){
        categoriesServices.updateCategories(categoriesRequest);
    }



    @DeleteMapping(value = "/deleteById/{id}")
    public void deleteById(@PathVariable(value = "id") Long id) {
        categoriesServices.deleteById(id);
    }
}
