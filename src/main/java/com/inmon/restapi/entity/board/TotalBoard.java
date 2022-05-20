package com.inmon.restapi.entity.board;

import com.inmon.restapi.entity.files.TotalBoardAttach;
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
@Entity(name = "total_board")
public class TotalBoard extends Board{
    @Comment("게시판코드")
    @JoinColumn(name="board_code")
    @ManyToOne(fetch = FetchType.LAZY)
    private BoardManage boardManage;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "board")
    List<TotalReply> replies = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "board")
    List<TotalBoardAttach> boardAttachList = new ArrayList<>();
}
