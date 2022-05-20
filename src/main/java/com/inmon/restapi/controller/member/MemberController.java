package com.inmon.restapi.controller.member;

import com.inmon.restapi.controller.member.dto.MemberJoinRequest;
import com.inmon.restapi.service.MemberService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @ApiOperation(value = "회원가입 요청 메소드")
    @PostMapping("/join")
    @ResponseBody
    public Map memberJoin(@RequestBody MemberJoinRequest member, HttpServletRequest request){
        return memberService.insertUser(member.getEntity());
    }
}
