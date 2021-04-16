package com.example.gateway.config;

import com.alibaba.csp.sentinel.adapter.gateway.sc.callback.BlockRequestHandler;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;

/**
 * @Description:
 *  自定义返回异常
 * @Author HeSuiJin
 * @Date 2021/4/15
 */
public class MyBlockRequestHandler implements BlockRequestHandler {

    private static final String DEFAULT_BLOCK_MSG_PREFIX = "Blocked by Sentinel: ";

    @Override
    public Mono<ServerResponse> handleRequest(ServerWebExchange exchange, Throwable ex) {
        // 返回http状态码为200
        return ServerResponse.status(200).contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(fromObject(buildErrorResult(ex)));
    }

    private ErrorResult buildErrorResult(Throwable ex) {
        return new ErrorResult(200,
                DEFAULT_BLOCK_MSG_PREFIX + ex.getClass().getSimpleName());
    }

    private static class ErrorResult {
        private final int code;
        private final String message;

        ErrorResult(int code, String message) {
            this.code = code;
            this.message = message;
        }

        public int getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }
    }
}
