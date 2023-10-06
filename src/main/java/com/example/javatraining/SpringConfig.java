package com.example.javatraining;

import com.example.javatraining.aop.TimeTraceAop;
import com.example.javatraining.service.MemberService;
import com.example.javatraining.repository.MemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

//    Bean을 이용해 선언할 경우 순환 참조가 발생되어 오류가 발생한다 전체 폴더를 스캔하는데 그중 AOP 파일도 같이 참조하기 때문이다
//    해당 오류를 방지하기 위해서는 코드상에서 AOP 파일을 제외시키는 코드를 작성하여야 한다.
    @Bean
    public TimeTraceAop TimeTraceAop() {
        return new TimeTraceAop();
    }

}
