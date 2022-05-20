package com.inmon.restapi.entity.board;

import com.inmon.restapi.entity.member.MemberRole;
import lombok.*;
import org.hibernate.annotations.Comment;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Entity(name = "board_role")
public class BoardRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="board_role_seq")
    private Long boardRoleSeq;

    @Comment("게시판코드")
    @JoinColumn(name="board_code")
    @ManyToOne(fetch = FetchType.LAZY)
    private BoardManage boardManage;

    @Comment("사용자권한")
    @JoinColumn(name="member_role_seq")
    @ManyToOne(fetch = FetchType.LAZY)
    private MemberRole memberRole;

    @Comment("허가행위")
    @Column(name = "board_act")
    private String boardAct;

}
