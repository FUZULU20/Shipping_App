package com.example.task2.services.impl;

import com.example.task2.dto.CategoriesDto;
import com.example.task2.dto.request.CategoriesRequest;
import com.example.task2.model.Categories;
import com.example.task2.repository.CategoriesRepository;
import com.example.task2.services.CategoriesServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriesImpl implements CategoriesServices {
    private final CategoriesRepository categoriesRepository;
    @Override
    public CategoriesDto getCategoriesById(Long id) {
        Categories categories = categoriesRepository.getCategoriesById(id);
        return CategoriesDto.builder()
                .categoryName(categories.getCategoryName())
                .description(categories.getDescription())
                .picture(categories.getPicture())
                .build();
    }

    @Override
    public void saveCategories(CategoriesRequest categoriesRequest) {
        Categories categories = Categories.builder()
                .categoryName(categoriesRequest.getCategoryName())
                .description(categoriesRequest.getDescription())
                .build();

        categoriesRepository.save(categories);
    }

    @Override
    public void updateCategories(CategoriesRequest categoriesRequest) {
        Categories categories = Categories.builder()
                .categoryName(categoriesRequest.getCategoryName())
                .description(categoriesRequest.getDescription())
                .picture(categoriesRequest.getPicture())
                .build();

        categoriesRepository.save(categories);
    }

    @Override
    public void deleteById(Long id) {
        if (id == null) {
            throw new RuntimeException("There is no such information");
        } else {
            categoriesRepository.deleteById(id);
        }
    }

    @Override
    public List<CategoriesDto> getAll() {
        List<Categories> categories1 = categoriesRepository.findAll();
        List<CategoriesDto> categoriesDtos = new ArrayList<>();

        for (Categories categories : categories1) {
            CategoriesDto categoriesDto = CategoriesDto.builder()
                    .categoryName(categories.getCategoryName())
                    .picture(categories.getPicture())
                    .description(categories.getDescription())
                    .build();

            categoriesDtos.add(categoriesDto);
        }
        return categoriesDtos;
    }
}
