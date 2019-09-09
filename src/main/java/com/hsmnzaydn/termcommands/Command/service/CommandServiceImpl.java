package com.hsmnzaydn.termcommands.Command.service;


import com.hsmnzaydn.termcommands.Command.Command;
import com.hsmnzaydn.termcommands.Command.CommandRepository;
import com.hsmnzaydn.termcommands.Command.service.CommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommandServiceImpl implements CommandService {

    private final CommandRepository commandRepository;

    @Override
    public List<Command> getAllCommands() {
        return commandRepository.findAll();
    }

    @Override
    public Command saveOrUpdateCommand(Command command){
        return commandRepository.save(command);
    }

    @Override
    public Command finCommandById(int commandId) {
        return commandRepository.findById(commandId).get();
    }
}
