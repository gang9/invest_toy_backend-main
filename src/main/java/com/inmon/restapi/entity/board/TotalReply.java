package com.inmon.restapi.entity.board;

import lombok.*;
import org.hibernate.annotations.Comment;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Entity(name = "total_reply")
public class TotalReply extends Reply{
    @Comment("원본게시글정보")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="board_seq")
    private TotalBoard board;
}
