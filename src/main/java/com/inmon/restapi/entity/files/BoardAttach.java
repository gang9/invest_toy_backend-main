package com.inmon.restapi.entity.files;

import lombok.*;
import org.hibernate.annotations.Comment;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class BoardAttach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="attach_seq")
    private long attachSeq;

    @Comment("파일정보")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="file_seq")
    private AllFiles files;

    @Comment("파일접근가능여부")
    @Column(name="is_active")
    private Boolean isActive;
}
