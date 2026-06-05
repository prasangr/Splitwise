package com.mycodes.splitwise.Commands;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CommandExecutor {

    private List<Command> commands=new java.util.ArrayList<>();


    @Autowired
    public CommandExecutor(SettleUpUser settleUpUser){
        commands.add(settleUpUser);
    }

    public void addCommand(Command cmd){
        commands.add(cmd);
    }

    public void removeCommand(Command cmd){
    commands.remove(cmd);
    }

    public void execute(String input){
        for(Command command:commands){
            if (command.matches(input)){
                command.execute(input);
                break;
            }
        }
    }

}
