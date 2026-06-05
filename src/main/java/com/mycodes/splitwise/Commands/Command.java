package com.mycodes.splitwise.Commands;

public interface Command {


    void execute(String input);

    //validate
    boolean matches(String input);
}
