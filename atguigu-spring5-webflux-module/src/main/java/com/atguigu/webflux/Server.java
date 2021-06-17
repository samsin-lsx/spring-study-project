package com.atguigu.webflux;

import com.atguigu.webflux.handler.MemberHandler;
import com.atguigu.webflux.service.MemberService;
import com.atguigu.webflux.service.impl.MemberServiceImpl;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.reactive.function.server.*;
import reactor.netty.http.server.HttpServer;

import java.io.IOException;

import static org.springframework.http.MediaType.APPLICATION_JSON;

/**
 * 设置路由服务
 * @author 李尚兴
 * @version 1.0
 * @create 2021/6/17 23:42
 */
public class Server {
    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.createReactorServer();
        System.out.println("服务器正在开启中……");
        System.in.read();
    }

    // 创建路由配置
    public RouterFunction<ServerResponse> routerFunction() {
        MemberService memberService = new MemberServiceImpl();
        MemberHandler memberHandler = new MemberHandler(memberService);
        return RouterFunctions.route(RequestPredicates.GET("/members/{id}").and(RequestPredicates.accept(APPLICATION_JSON)), memberHandler::getMemberById)
                .andRoute(RequestPredicates.GET("/members").and(RequestPredicates.accept(APPLICATION_JSON)), memberHandler::getAllMember);
    }

    // 创建服务器完成适配
    public void createReactorServer() {
        // 设置路由和handler适配
        RouterFunction<ServerResponse> routerFunction = routerFunction();
        HttpHandler httpHandler = RouterFunctions.toHttpHandler(routerFunction);
        ReactorHttpHandlerAdapter reactorHttpHandlerAdapter = new ReactorHttpHandlerAdapter(httpHandler);
        // 创建服务
        HttpServer httpServer = HttpServer.create();
        httpServer.handle(reactorHttpHandlerAdapter).bindNow();
    }
}
