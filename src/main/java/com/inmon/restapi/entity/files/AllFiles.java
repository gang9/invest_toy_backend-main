package com.inmon.restapi.entity.files;

import com.inmon.restapi.entity.board.TotalReply;
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
@Entity(name = "files")
public class AllFiles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="fileSeq")
    private long file_seq;

    @Comment("업로드 사용자 정보")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_seq")
    private Member member;

    @Comment("파일이름")
    @Column(name="file_name")
    private String fileName;

    @Comment("파일원본이름")
    @Column(name="file_org_name")
    private String fileOrgName;

    @Comment("파일경로")
    @Column(name="file_path")
    private String filePath;

    @Comment("파일생성일")
    @Column(name="regdate")
    private Date regDate;

    @Comment("파일삭제여부")
    @Column(name="is_delete")
    private Boolean isDelete;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "files")
    List<InvestBoardAttach> investBoardAttaches = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "files")
    List<TotalBoardAttach> totalBoardAttaches = new ArrayList<>();
}
