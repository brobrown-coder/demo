package com.example.demo.common.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.common.domain.Messenger;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Home", description = "홈 컨트롤러 API")
@RestController
public class HomeController {

    @Operation(summary = "홈 페이지", description = "애플리케이션의 홈 엔드포인트를 반환합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공적으로 응답을 반환했습니다.")
    })
    @GetMapping("/")
    public ResponseEntity<Messenger> home() {
        return ResponseEntity.ok(
                Messenger.builder()
                        .code(200)
                        .message("success")
                        .build());
    }

    @Operation(summary = "헬스 체크", description = "애플리케이션의 상태를 확인합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "애플리케이션이 정상적으로 작동 중입니다.")
    })
    @GetMapping("/health")
    public ResponseEntity<Messenger> health() {
        return ResponseEntity.ok(
                Messenger.builder()
                        .code(200)
                        .message("success")
                        .build());
    }
}
