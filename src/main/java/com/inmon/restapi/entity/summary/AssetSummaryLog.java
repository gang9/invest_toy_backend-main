package com.inmon.restapi.entity.summary;

import com.inmon.restapi.entity.member.Member;
import lombok.*;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Entity(name = "asset_summary_log")
public class AssetSummaryLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="asset_log_seq")
    private Long assetLogSeq;

    @Comment("집계정보")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "asset_seq")
    private AssetSummary asset;

    @Comment("사용자정보")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_seq")
    private Member member;

    @Comment("거래주가 코드")
    @Column(name="stck_shrn_iscd")
    private String stckShrnIscd;

    @Comment("보유수량")
    @Column(name="asset_hold_count")
    private Integer assetHoldCount;

    @Comment("평균단가")
    @Column(name="average_price")
    private Integer averagePrice;

    @Comment("집계날짜")
    @Column(name = "asset_log_summary_date")
    private Date assetLogSummaryDate;

}
