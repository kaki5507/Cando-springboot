package com.goodee.cando.web.dto;

import com.goodee.cando.domain.members.Members;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MembersSaveRequestDto {
    private String member_id;
    private String member_pwd;
    private String member_name;
    private String member_email;
    private String member_phone;

    @Builder
    public MembersSaveRequestDto(String member_id, String member_pwd, String member_name, String member_email, String member_phone) {
        this.member_id = member_id;
        this.member_pwd = member_pwd;
        this.member_name = member_name;
        this.member_email = member_email;
        this.member_phone = member_phone;
    }

    public Members toEntity() {
        return Members.builder()
                .member_id(member_id)
                .member_pwd(member_pwd)
                .member_name(member_name)
                .member_email(member_email)
                .member_phone(member_phone)
                .build();
    }
}
