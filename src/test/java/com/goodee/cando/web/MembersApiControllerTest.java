package com.goodee.cando.web;

import com.goodee.cando.domain.members.Members;
import com.goodee.cando.domain.members.MembersRepository;
import com.goodee.cando.web.dto.MembersSaveRequestDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

@ExtendWith(SpringExtension.class) // Spring TestContext Framework를 Junit5에 포함
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // 통합 테스트
public class MembersApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired // 주입
    private TestRestTemplate restTemplate;

    @Autowired
    private MembersRepository membersRepository;

    @AfterEach // 맨 마지막에 실행 되는 것 @After | tearDown 분해 테스트 끝나면 종료 시키겠다는 것.
    public void tearDown() throws Exception{
        membersRepository.deleteAll();
    }

    @Test
    public void Members_register() throws Exception{
        //given
        String member_id = "member_id";
        String member_pwd = "member_pwd";
        String member_name = "member_name";
        String member_email = "member_email";
        String member_phone = "member_phone";
        MembersSaveRequestDto requestDto = MembersSaveRequestDto.builder()
                .member_id(member_id)
                .member_pwd(member_pwd)
                .member_name(member_name)
                .member_email(member_email)
                .member_phone(member_phone)
                .build();

        String url = "http://localhost:" + port + "/api/v1/members";

        //when
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url,requestDto,String.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan("0L");

        List<Members> all = membersRepository.findAll();
        assertThat(all.get(0).getMember_id()).isEqualTo(member_id);
        assertThat(all.get(0).getMember_pwd()).isEqualTo(member_pwd);
        assertThat(all.get(0).getMember_name()).isEqualTo(member_name);
        assertThat(all.get(0).getMember_email()).isEqualTo(member_email);
        assertThat(all.get(0).getMember_phone()).isEqualTo(member_phone);

    }

}
