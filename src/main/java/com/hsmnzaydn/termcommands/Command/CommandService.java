package com.hsmnzaydn.termcommands.Command;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommandService  {
    private final CommandRepository commandRepository;

    public List<Command> getAllCommands() {
        return commandRepository.findAll();
    }

    public Command saveOrUpdateCommand(Command command){
        return commandRepository.save(command);
    }
}
