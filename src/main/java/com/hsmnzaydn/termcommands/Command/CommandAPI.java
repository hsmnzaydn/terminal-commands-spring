package com.hsmnzaydn.termcommands.Command;


import com.hsmnzaydn.termcommands.Command.service.CommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/commands")
@RequiredArgsConstructor
public class CommandAPI {

    private final CommandService commandService;

    @GetMapping
    public ResponseEntity<List<Command>> getAllCommands(){
        return ResponseEntity.ok(commandService.getAllCommands());
    }

    @PostMapping("/{commandId}")
    public ResponseEntity<Command> saveOrUpdateCommand(@RequestBody Command command,
                                                       @PathVariable int commandId){
        Command command1=commandService.finCommandById(commandId);
        command1.setCommandTitle(command.getCommandTitle());
        command1.setDescription(command.getDescription());

        return ResponseEntity.ok(commandService.saveOrUpdateCommand(command1));
    }


}
