package com.goodee.cando.service.members;

import com.goodee.cando.domain.members.MembersRepository;
import com.goodee.cando.web.dto.MembersSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MembersService {
    private final MembersRepository membersRepository;

    @Transactional
    public String save(MembersSaveRequestDto requestDto){
        return membersRepository.save(requestDto.toEntity()).getMember_id();
    }

}
