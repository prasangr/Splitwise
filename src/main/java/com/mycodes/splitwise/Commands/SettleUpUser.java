package com.mycodes.splitwise.Commands;

import com.mycodes.splitwise.Controllers.SettleUpController;
import com.mycodes.splitwise.DTOs.SettleUpUserRequestDto;
import com.mycodes.splitwise.DTOs.SettleUpUserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SettleUpUser implements Command{
   /*
    Expected Input : SettleUp <user_id>
     */
    //SettleUpUser is a command from the user input.


    private SettleUpController settleUpController;

    @Autowired
    public SettleUpUser(SettleUpController settleUpController){
        this.settleUpController=settleUpController;
    }



    @Override
    public void execute(String input) {
        List<String> words=List.of(input.split(" "));
        Long userId=Long.valueOf(words.get(1));
        SettleUpUserRequestDto settleUpUserRequestDto=new SettleUpUserRequestDto();
        settleUpUserRequestDto.setUserId(userId);
        SettleUpUserResponseDto settleUpUserResponseDto=settleUpController.settleUpUser(settleUpUserRequestDto);



    }


    @Override
    public boolean matches(String input) {
        List<String> words = List.of(input.split(" "));
        return words.size()==2 && words.get(0).equals(CommandKeywords.SettleUpUser);

    }
}
