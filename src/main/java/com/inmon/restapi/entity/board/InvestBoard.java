package com.inmon.restapi.entity.board;

import com.inmon.restapi.entity.files.InvestBoardAttach;
import lombok.*;
import org.hibernate.annotations.Comment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Entity(name = "invest_board")
public class InvestBoard extends Board{
    @Comment("거래주가 코드")
    @Column(name="stck_shrn_iscd")
    private String stckShrnIscd;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "board")
    List<InvestReply> replies = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "board")
    List<InvestBoardAttach> boardAttachList = new ArrayList<>();
}
