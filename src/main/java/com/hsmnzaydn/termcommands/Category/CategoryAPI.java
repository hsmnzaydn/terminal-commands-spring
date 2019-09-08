package com.hsmnzaydn.termcommands.Category;


import com.hsmnzaydn.termcommands.Command.Command;
import com.hsmnzaydn.termcommands.Command.CommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryAPI {

    private final CategoryService categoryService;
    private final CommandService commandService;


    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        return ResponseEntity.ok(categoryService.findAll());
    }

    @PostMapping
    public ResponseEntity saveCategory(@RequestBody Category category) {
        return ResponseEntity.ok(categoryService.saveOrUpdateCategory(category));
    }

    @PostMapping("/{categoryId}/commands")
    @GetMapping
    ResponseEntity<List<Command>> findAllCommandsOfCategory(@PathVariable Integer categoryId,
                                                            @RequestBody Command command) {

        commandService.saveOrUpdateCommand(command);
        Category category = categoryService.findCategoryById(categoryId);
        category.getCommandList().add(commandService.saveOrUpdateCommand(command));
        categoryService.saveOrUpdateCategory(category);

        return ResponseEntity.ok(categoryService.findAllCategoryCommands(categoryId));
    }
}
