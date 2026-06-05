package com.mycodes.splitwise.Commands;

import java.util.Arrays;
import java.util.List;

public class RegisterUserCommand implements Command{


    /*
    Expected Input :-

        registerUser <userName> <phoneNumber> <password>
        registerUser nikhil 1234 password
        register nikhil 1234 password   -- not a valid cmd
     */



    @Override
    public void execute(String input) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean matches(String input) {
        List<String> words = Arrays.asList(input.split(" "));
       return words.size()==4 && words.get(0).equals(CommandKeywords.RegisterUser);

    }
}
