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
@Entity(name = "login_history")
public class LoginHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="history_seq")
    private Long historySeq;

    @Comment("사용자정보")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_seq")
    private Member member;

    @Comment("접속시도발생일자")
    @Column(name="history_date")
    private Date historyDate;

    @Comment("접속시도결과")
    @Column(name="login_result")
    private String loginResult;

    @Comment("접속시도IP")
    @Column(name="login_ip")
    private String loginIP;

    @Comment("접속특이사항")
    @Column(name="login_log")
    private String loginLog;
}
