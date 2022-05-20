package com.inmon.restapi.repository.member.custom.impl;

import com.inmon.restapi.repository.member.custom.MemberRepositoryCustom;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class MemberRepositoryImpl implements MemberRepositoryCustom {
    @Autowired
    private JPAQueryFactory queryFactory;
}
