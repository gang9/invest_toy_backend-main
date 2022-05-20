package com.inmon.restapi.entity.board;

import lombok.*;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Entity(name = "board_manage")
public class BoardManage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="board_code")
    private Long boardCode;

    @Comment("게시판이름")
    @Column(name="board_name")
    private String boardName;

    @Comment("게시판활성여부")
    @Column(name = "is_active")
    private Boolean isActive;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "boardManage")
    List<BoardRole> boardRoles = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "boardManage")
    List<TotalBoard> boards = new ArrayList<>();

}
