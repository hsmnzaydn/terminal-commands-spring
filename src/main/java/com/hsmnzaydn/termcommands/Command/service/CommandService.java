package com.hsmnzaydn.termcommands.Command.service;

import com.hsmnzaydn.termcommands.Command.Command;

import java.util.List;

public interface CommandService {
    List<Command> getAllCommands();
    Command saveOrUpdateCommand(Command command);
    Command finCommandById(int commandId);
}
