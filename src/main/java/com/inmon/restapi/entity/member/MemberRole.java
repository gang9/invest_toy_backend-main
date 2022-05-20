package com.inmon.restapi.entity.member;

import com.inmon.restapi.entity.board.BoardRole;
import lombok.*;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "member_role")
public class MemberRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="member_role_seq")
    private Long memberRoleSeq;

    @Comment("권한명")
    @Column(name="role_name")
    private String roleName;

    @Comment("권한코드")
    @Column(name="role_code")
    private String roleCode;

    @Comment("권한활성여부")
    @Column(name="is_active")
    private String isActive;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "memberRole")
    List<Member> members = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "memberRole")
    List<BoardRole> boardRoles = new ArrayList<>();
}
