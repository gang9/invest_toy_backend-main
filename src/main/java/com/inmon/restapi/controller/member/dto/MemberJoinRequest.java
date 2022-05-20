package com.inmon.restapi.controller.member.dto;

import com.inmon.restapi.entity.member.Member;
import lombok.Data;

@Data
public class MemberJoinRequest {
    private String userId;
    private String userPass;
    private String userName;
    private String userPhone;

    public Member getEntity(){
        Member result = Member.builder()
                .userId(userId)
                .userPass(userPass)
                .userName(userName)
                .userPhone(userPhone)
                .build();
        return result;
    }
}
