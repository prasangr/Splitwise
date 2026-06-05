package com.mycodes.splitwise.Commands;

import com.mycodes.splitwise.Controllers.SettleUpController;
import com.mycodes.splitwise.DTOs.SettleUpGroupRequestDto;
import com.mycodes.splitwise.DTOs.SettleUpGroupResponseDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SettleUpGroup implements Command{

 /*
    Expected Input :- SettleUpGroup <group_id>


    settleUpGroup 1234
     */


    private SettleUpController settleUpController;


    @Autowired
    private SettleUpGroup(SettleUpController settleUpController){
        this.settleUpController=settleUpController;
    }

    @Override
    public void execute(String input) {
    List<String> words=List.of(input.split(" "));
    Long groupId=Long.valueOf(words.get(1));

    SettleUpGroupRequestDto settleUpGroupRequestDto=new SettleUpGroupRequestDto();
    settleUpGroupRequestDto.setGroupId(groupId);

    SettleUpGroupResponseDto settleUpGroupResponseDto=settleUpController.settleUpGroup(settleUpGroupRequestDto);

    }

    @Override
    public boolean matches(String input) {
        List<String> words = List.of(input.split(" "));
        return words.size()==2 && words.get(0).equals(CommandKeywords.SettleUpGroup);

    }
}
