package com.inmon.restapi.entity.member;

import lombok.*;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "trade_log")
public class TradeLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="trade_seq")
    private Long tradeSeq;

    @Comment("사용자정보")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_seq")
    private Member member;

    @Comment("거래주가 코드")
    @Column(name="stck_shrn_iscd")
    private String stckShrnIscd;

    @Comment("거래 행위 타입")
    @Column(name="trade_type")
    private String tradeType;

    @Comment("거래수량")
    @Column(name="trade_count")
    private Integer tradeCount;

    @Comment("거래 액수")
    @Column(name="trade_price")
    private Integer tradePrice;

    @Comment("거래 시간")
    @Column(name="trade_date")
    private Date tradeDate;
}
