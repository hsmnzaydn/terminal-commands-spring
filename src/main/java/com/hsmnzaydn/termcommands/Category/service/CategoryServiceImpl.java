package com.hsmnzaydn.termcommands.Category.service;

import com.hsmnzaydn.termcommands.Category.Category;
import com.hsmnzaydn.termcommands.Category.CategoryRepository;
import com.hsmnzaydn.termcommands.Category.service.CategoryService;
import com.hsmnzaydn.termcommands.Command.Command;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;


    @Override
    public List<Category> findAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public List<Command> findAllCommandsOfCategory(int categoryId) {
        return categoryRepository.findById(categoryId).get().getCommands();
    }

    @Override
    public Category findCategoryById(int categoryId) {
        return categoryRepository.findById(categoryId).get();
    }

    @Override
    public Category saveOrUpdateCategory(Category category){
        return categoryRepository.save(category);
    }
}
