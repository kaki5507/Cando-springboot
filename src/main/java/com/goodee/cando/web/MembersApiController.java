package com.goodee.cando.web;

import com.goodee.cando.service.members.MembersService;
import com.goodee.cando.web.dto.MembersSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController // Controller는 화면을 return, RestController는 주로 데이터를 리턴
public class MembersApiController {
    private final MembersService membersService;

    @PostMapping("/api/v1/members")
    public String save(@RequestBody MembersSaveRequestDto requestDto){
        return membersService.save(requestDto);
    }
}
