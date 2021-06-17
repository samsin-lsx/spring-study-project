package com.atguigu.webflux.service.impl;

import com.atguigu.webflux.entity.Member;
import com.atguigu.webflux.service.MemberService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户业务层实现类
 * @author 李尚兴
 * @version 1.0
 * @create 2021/6/15 23:31
 */
@Service
public class MemberServiceImpl implements MemberService {
    private final Map<Integer, Member> membersMap = new HashMap<>();

    public MemberServiceImpl() {
        this.membersMap.put(1, new Member(1001, "samsin", "男", 26));
        this.membersMap.put(2, new Member(1002, "samlin", "女", 27));
        this.membersMap.put(3, new Member(1003, "sambao", "男", 1));
    }

    @Override
    public Mono<Member> getMemberById(Integer id) {
        return Mono.justOrEmpty(this.membersMap.get(id));
    }

    @Override
    public Flux<Member> getAllMember() {
        return Flux.fromIterable(this.membersMap.values());
    }

    @Override
    public Mono<Void> saveMemberInfo(Mono<Member> memberMono) {
        return memberMono.doOnNext(member -> {
            int memberId = this.membersMap.size();
            this.membersMap.put(memberId, member);
        }).thenEmpty(Mono.empty());
    }
}
