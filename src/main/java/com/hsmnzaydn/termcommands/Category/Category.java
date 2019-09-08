package com.hsmnzaydn.termcommands.Category;


import com.hsmnzaydn.termcommands.Command.Command;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String categoryTitle;

    @Column
    @ElementCollection(targetClass=Command.class)
    private List<Command> commands;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    public List<Command> getCommandList() {
        return commands;
    }

    public void setCommandList(List<Command> commandList) {
        this.commands = commandList;
    }
}
