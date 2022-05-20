package com.inmon.restapi.entity.files;

import com.inmon.restapi.entity.board.InvestBoard;
import com.inmon.restapi.entity.board.TotalBoard;
import lombok.*;
import org.hibernate.annotations.Comment;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Entity(name = "total_board_attach")
public class TotalBoardAttach extends BoardAttach{
    @Comment("원본게시물")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="board_seq")
    private TotalBoard board;
}
