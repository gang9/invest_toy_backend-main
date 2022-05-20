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
@Entity(name = "asset_summary")
public class AssetSummary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="asset_seq")
    private Long assetSeq;

    @Comment("사용자정보")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_seq")
    private Member member;

    @Comment("자산 총액")
    @Column(name="asset_stock_total")
    private Integer assetStockTotal;

    @Comment("집계날짜")
    @Column(name = "asset_summary_date")
    private Date assetSummaryDate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "asset")
    List<AssetSummaryLog> assetSummaryLogs = new ArrayList<>();
}
