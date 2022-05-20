package com.inmon.restapi.entity.member;

import com.inmon.restapi.entity.board.InvestBoard;
import com.inmon.restapi.entity.board.TotalBoard;
import com.inmon.restapi.entity.summary.AssetSummary;
import com.inmon.restapi.entity.summary.HoldStock;
import lombok.*;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicInsert
@DynamicUpdate
@Entity(name = "member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_seq")
    private Long userSeq;

    @Comment("사용자ID")
    @Column(name="user_id", unique = true, nullable = false)
    private String userId;

    @Comment("사용자비밀번호")
    @Column(name="user_pass", nullable = false)
    private String userPass;

    @Comment("사용자이름")
    @Column(name="user_name")
    private String userName;

    @Comment("사용자전화번호")
    @Column(name="user_phone")
    private String userPhone;

    @Comment("타 도메인연동 로그인 여부")
    @Column(name="id_type")
    private String idType;

    @Comment("가입일")
    @Column(name="regdate")
    private Date regDate;

    @Comment("마지막 접속일")
    @Column(name="lastlogin")
    private Date lastLogin;

    @Comment("계정 활성 여부")
    @Column(name="is_active")
    private Boolean isActive;

    @Comment("계정권한")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_role_seq")
    private MemberRole memberRole;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "member")
    List<LoginHistory> loginHistories = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "member")
    List<TradeLog> tradeLogs = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "member")
    List<AssetSummary> assetSummaries = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "member")
    List<HoldStock> holdStocks = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "member")
    List<InvestBoard> investBoards = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "member")
    List<TotalBoard> totalBoards = new ArrayList<>();

    @PrePersist
    public void prePersist(){
        regDate = new Date();
        isActive = true;
    }
}
