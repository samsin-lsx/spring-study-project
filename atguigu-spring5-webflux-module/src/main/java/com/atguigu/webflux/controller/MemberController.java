package com.atguigu.webflux.controller;

import com.atguigu.webflux.entity.Member;
import com.atguigu.webflux.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 用户控制层：使用注解编程方式
 * @author 李尚兴
 * @version 1.0
 * @create 2021/6/15 23:25
 */
@RestController
public class MemberController {
    @Autowired
    private MemberService memberService;

    @GetMapping("/member/{id}")
    public Mono<Member> getMemberById(@PathVariable Integer id) {
        return this.memberService.getMemberById(id);
    }

    @GetMapping("/member")
    public Flux<Member> getAllMember() {
        return this.memberService.getAllMember();
    }

    @PostMapping("/saveUser")
    public Mono<Void> saveMember(@RequestBody Member member) {
        return this.memberService.saveMemberInfo(Mono.just(member));
    }
}
