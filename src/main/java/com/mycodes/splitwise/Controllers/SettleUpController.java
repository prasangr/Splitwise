package com.mycodes.splitwise.Controllers;


import com.mycodes.splitwise.DTOs.SettleUpGroupRequestDto;
import com.mycodes.splitwise.DTOs.SettleUpGroupResponseDto;
import com.mycodes.splitwise.DTOs.SettleUpUserRequestDto;
import com.mycodes.splitwise.DTOs.SettleUpUserResponseDto;
import com.mycodes.splitwise.Services.SettleUpService;
import org.springframework.stereotype.Controller;

@Controller
public class SettleUpController {

    private SettleUpService settleUpService;
    public SettleUpGroupResponseDto settleUpGroup(
            SettleUpGroupRequestDto settleUpGroupRequestDto
    ) {
        // settleup service -> settleup strategy
        settleUpService.settleUpGroup(settleUpGroupRequestDto.getGroupId());

        return null;
    }

    public SettleUpUserResponseDto settleUpUser(
            SettleUpUserRequestDto settleUpUserRequestDto
    ) {
        return null;
    }
}
