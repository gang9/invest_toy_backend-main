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
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="board_seq")
    private Long boardSeq;

    @Comment("사용자정보")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_seq")
    private Member member;

    @Comment("거래주가 코드")
    @Column(name="stck_shrn_iscd")
    private String stckShrnIscd;

    @Comment("게시글제목")
    @Column(name="board_title")
    private String boardTitle;

    @Comment("게시글내용")
    @Column(name="board_content")
    private String boardContent;

    @Comment("게시글내용 escape")
    @Column(name="board_content_escape")
    private String boardContentEscape;

    @Comment("게시글작성일")
    @Column(name="reg_date")
    private Date regDate;

    @Comment("게시글수정일")
    @Column(name="mod_date")
    private Date modDate;

    @Comment("게시글활성여부")
    @Column(name = "is_active")
    private Boolean isActive;

    @Comment("조회수")
    @Column(name = "view_count")
    private Integer viewCount;

}
