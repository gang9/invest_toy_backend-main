package com.inmon.restapi.entity.board;

import com.inmon.restapi.entity.member.Member;
import lombok.*;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="reply_seq")
    private long replySeq;

    @Comment("사용자정보")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_seq")
    private Member member;

    @Comment("댓글내용")
    @Column(name = "reply_content")
    private String replyContent;

    @Comment("댓글내용 escape")
    @Column(name = "reply_content_escape")
    private String replyContentEscape;

    @Comment("댓글작성일")
    @Column(name="reg_date")
    private Date regDate;

    @Comment("댓글수정일")
    @Column(name="mod_date")
    private Date modDate;

    @Comment("댓글활성여부")
    @Column(name = "is_active")
    private Boolean isActive;

}
