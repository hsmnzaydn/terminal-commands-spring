package com.hsmnzaydn.termcommands.Category.service;

import com.hsmnzaydn.termcommands.Category.Category;
import com.hsmnzaydn.termcommands.Command.Command;

import java.util.List;

public interface CategoryService {

    List<Category> findAllCategory();
    List<Command> findAllCommandsOfCategory(int categoryId);
    Category findCategoryById(int categoryId);
    Category saveOrUpdateCategory(Category category);
}
