package com.atguigu.webflux.handler;

import com.atguigu.webflux.entity.Member;
import com.atguigu.webflux.service.MemberService;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.EntityResponse;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 用户控制层：使用函数式编程模型方式
 * @author 李尚兴
 * @version 1.0
 * @create 2021/6/17 23:21
 */
public class MemberHandler {
    private MemberService memberService;

    public MemberHandler(MemberService memberService) {
        this.memberService = memberService;
    }

    // 根据id查询
    public Mono<ServerResponse> getMemberById(ServerRequest request) {
        Integer userId = Integer.valueOf(request.pathVariable("id")); // 获取id参数
        Mono<ServerResponse> notFoundBuild = ServerResponse.notFound().build(); // 空值处理
        Mono<Member> memberMono = this.memberService.getMemberById(userId);
        // 将memberMono转换返回，使用Reactor操作符
        // return memberMono.flatMap(member -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(BodyInserters.fromObject(member))).switchIfEmpty(notFoundBuild);
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(memberMono, Member.class); // 与上面等价
    }

    // 查询所有
    public Mono<ServerResponse> getAllMember(ServerRequest request) {
        Flux<Member> members = this.memberService.getAllMember();
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(members, Member.class);
    }

    // 添加用户
    public Mono<ServerResponse> saveMember(ServerRequest request) {
        Mono<Member> memberMono = request.bodyToMono(Member.class);
        return ServerResponse.ok().build(this.memberService.saveMemberInfo(memberMono));
    }
}
