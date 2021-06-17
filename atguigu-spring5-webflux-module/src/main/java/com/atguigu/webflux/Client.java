package com.atguigu.webflux;

import com.atguigu.webflux.entity.Member;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 服务调用客户端
 * @author 李尚兴
 * @version 1.0
 * @create 2021/6/18 0:30
 */
public class Client {
    public static void main(String[] args) {
        WebClient webClient = WebClient.create("http://127.0.0.1:59386");
        // 根据id=1查询
        Member member = webClient.get().uri("/members/{id}", "1").accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(Member.class).block();
        System.out.println(member);
        // 查询所有用户
        Flux<Member> memberFlux = webClient.get().uri("/members").accept(MediaType.APPLICATION_JSON).retrieve().bodyToFlux(Member.class);
        memberFlux.map(member1 -> member1).buffer().doOnNext(System.out::println).blockFirst();
    }
}
