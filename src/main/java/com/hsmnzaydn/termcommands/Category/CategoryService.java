package com.hsmnzaydn.termcommands.Category;

import com.hsmnzaydn.termcommands.Command.Command;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public List<Command> findAllCategoryCommands(Integer categoryId){
        return categoryRepository.findById(categoryId).get().getCommandList();
    }

    public Category findCategoryById(Integer categoryId){
        return categoryRepository.findById(categoryId).get();
    }

    public Category saveOrUpdateCategory(Category category){
        return categoryRepository.save(category);
    }
}
