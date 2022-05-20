package com.inmon.restapi.controller.board.invest;

import com.inmon.restapi.controller.member.dto.MemberJoinRequest;
import com.inmon.restapi.service.MemberService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/board/invest")
public class InvestBoardController {

    @Autowired
    private MemberService memberService;

    @ApiOperation(value = "종목게시물 목록 조회")
    @GetMapping("/list")
    @ResponseBody
    public Map boardList(@RequestBody MemberJoinRequest member, HttpServletRequest request){
        return memberService.insertUser(member.getEntity());
    }

    @ApiOperation(value = "종목게시물 작성 ")
    @PostMapping("/")
    @ResponseBody
    public Map boardWrite(@RequestBody MemberJoinRequest member, HttpServletRequest request){
        return memberService.insertUser(member.getEntity());
    }
}
