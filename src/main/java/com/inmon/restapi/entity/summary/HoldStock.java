package com.inmon.restapi.entity.summary;

import com.inmon.restapi.entity.member.Member;
import lombok.*;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Entity(name = "hold_stock")
public class HoldStock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="hold_seq")
    private Long holdSeq;

    @Comment("사용자정보")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_seq")
    private Member member;

    @Comment("거래주가 코드")
    @Column(name="stck_shrn_iscd")
    private String stckShrnIscd;

    @Comment("보유 수량")
    @Column(name="hold_count")
    private Integer holdCount;

    @Comment("보유 총액")
    @Column(name="hold_value")
    private Integer holdValue;

    @Comment("평균 단가")
    @Column(name="average_price")
    private Integer averagePrice;

    @Comment("보유 현금")
    @Column(name = "hold_money")
    private Integer holdMoney;
}
