package org.zerock.service;


import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.zerock.domain.KakaopayDTO;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class KakaoPayService {

    private static final String KAKAO_API_URL = "https://kapi.kakao.com/v1/payment";
    private static final String ADMIN_KEY = "3c77066f4ecba5612383d0dafbbb9ed8";

    public Map<String, Object> preparePayment(KakaopayDTO kakaopayDTO) throws Exception {
        String url = KAKAO_API_URL + "/ready";

        // 준비 요청 파라미터 설정
        Map<String, String> params = Map.of(
            "cid", "TC0ONETIME", // 가맹점 코드
            "partner_order_id", kakaopayDTO.getPartner_order_id(), // 가맹점 주문번호
            "partner_user_id", kakaopayDTO.getUserId(), // 가맹점 회원 ID
            "item_name", kakaopayDTO.getMovieName(), // 상품명
            "quantity", String.valueOf(kakaopayDTO.getQuantity()), // 수량
            "total_amount", String.valueOf(kakaopayDTO.getPrice()), // 총액
            "tax_free_amount", "0", // 비과세 금액
            "approval_url", "http://localhost:8001/payment/success", // 결제 성공 URL
            "cancel_url", "http://localhost:8001/payment/cancel", // 결제 취소 URL
            "fail_url", "http://localhost:8001/payment/fail" // 결제 실패 URL
        );

        // HTTP 클라이언트 생성 및 요청 준비
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .header("Authorization", "KakaoAK " + ADMIN_KEY)
            .header("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8")
            .POST(HttpRequest.BodyPublishers.ofString(
                params.entrySet()
                    .stream()
                    .map(entry -> entry.getKey() + "=" + entry.getValue())
                    .collect(Collectors.joining("&"))
            ))
            .build();

        // HTTP 요청 보내기 및 응답 처리
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // 응답 상태 코드 검사
        if (response.statusCode() != 200) {
            throw new RuntimeException("카카오 API 호출 실패: " + response.body());
        }

        // JSON 응답을 Map으로 파싱
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(response.body(), Map.class);
    }

    public Map<String, Object> approvePayment(KakaopayDTO kakaopayDTO) throws Exception {
        String url = KAKAO_API_URL + "/approve";

        // 승인 요청 파라미터 설정
        Map<String, String> params = Map.of(
            "cid", "TC0ONETIME", // 가맹점 코드
            "tid", kakaopayDTO.getTid(), // 거래 ID
            "partner_order_id",kakaopayDTO.getPartner_order_id(), // 가맹점 주문번호
            "partner_user_id", kakaopayDTO.getUserId(), // 가맹점 회원 ID
            "item_name", kakaopayDTO.getMovieName(),
            "quantity", String.valueOf(kakaopayDTO.getQuantity()),
            "total_amount", String.valueOf(kakaopayDTO.getPrice()),
            "pg_token", kakaopayDTO.getPgToken() // 결제 승인 토큰
        );

        // HTTP 클라이언트 생성 및 요청 준비
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .header("Authorization", "KakaoAK " + ADMIN_KEY)
            .header("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8")
            .POST(HttpRequest.BodyPublishers.ofString(
                params.entrySet()
                    .stream()
                    .map(entry -> entry.getKey() + "=" + entry.getValue())
                    .collect(Collectors.joining("&"))
            ))
            .build();

        // HTTP 요청 보내기 및 응답 처리
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // 응답 상태 코드 검사
        if (response.statusCode() != 200) {
            throw new RuntimeException("결제 승인 API 호출 실패: " + response.body());
        }

        // JSON 응답을 Map으로 파싱
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(response.body(), Map.class);
    }
}