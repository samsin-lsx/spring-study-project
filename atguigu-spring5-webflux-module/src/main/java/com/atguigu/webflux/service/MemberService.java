package com.atguigu.webflux.service;

import com.atguigu.webflux.entity.Member;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author 李尚兴
 * @version 1.0
 * @create 2021/6/15 23:25
 */
public interface MemberService {
    /**
     * 根据ID查询用户数据
     * @param id 编号
     * @return 用户对象
     */
    Mono<Member> getMemberById(Integer id);

    /**
     * 查询所有用户数据
     * @return 用户集合对象
     */
    Flux<Member> getAllMember();

    /**
     * 添加用户数据
     * @param memberMono 用户对象
     * @return 添加成功返回Mono对象
     */
    Mono<Void> saveMemberInfo(Mono<Member> memberMono);
}
