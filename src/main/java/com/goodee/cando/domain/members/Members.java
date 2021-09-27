package com.goodee.cando.domain.members;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Getter
@NoArgsConstructor
@Entity // 멤버 테이블
public class Members {

    @Id // pk
    @Column(length = 60)
    private String member_id;

    // nullable DDL에서 not null이 설정되어 테이블이 생성
    @Column(length = 60, nullable = false)
    private String member_pwd;

    @Column(length = 60, nullable = false)
    private String member_name;

    @Column(length = 150, nullable = false)
    private String member_email;

    @Column(length = 40, nullable = false)
    private String member_phone;

    @Builder
    public Members(String member_id, String member_pwd, String member_name, String member_email, String member_phone){
        this.member_id = member_id;
        this.member_pwd = member_pwd;
        this.member_name = member_name;
        this.member_email = member_email;
        this.member_phone = member_phone;
    }
}
