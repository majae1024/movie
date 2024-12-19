package org.zerock.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FaviconController {
    @GetMapping("/favicon.ico")
    public void favicon() {
        // 브라우저의 자동 요청을 무시하거나 빈 응답 처리
    }
}
