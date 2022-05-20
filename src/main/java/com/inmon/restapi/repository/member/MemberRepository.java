package com.inmon.restapi.repository.member;


import com.inmon.restapi.entity.member.Member;
import com.inmon.restapi.repository.member.custom.MemberRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryCustom {
    Member findByUserId(String id);
}
