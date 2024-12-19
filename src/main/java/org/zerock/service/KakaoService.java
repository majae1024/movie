package org.zerock.service;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.zerock.domain.KakaoVO;
import org.zerock.domain.OAuthToken;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class KakaoService {

	//전달받은 CODE로 OauthToken정보 받아서 Access_Token정보만 빼오기
	public String getAccessToken(String code) throws IOException {
		String access_Token = "";
		String refresh_Token = "";

		// POST 방식으로 key=value 데이터를 요청 (카카오쪽으로)
		// 이 때 필요한 라이브러리가 RestTemplate, 얘를 쓰면 http 요청을 편하게 할 수 있다.
		RestTemplate rt = new RestTemplate();

		// 인가코드로 토큰 받기
		String host = "https://kauth.kakao.com/oauth/token";// https://{요청할 서버 주소}
		ResponseEntity<String> response;
		
		try {
			// HTTP POST를 요청할 때 보내는 데이터(body)를 설명해주는 헤더도 만들어 같이 보내줘야 한다.
			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

			// body 데이터를 담을 오브젝트인 MultiValueMap를 만들어보자
			// body는 보통 key, value의 쌍으로 이루어지기 때문에 자바에서 제공해주는 MultiValueMap 타입을 사용한다.
			MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
			params.add("grant_type", "authorization_code");
			params.add("client_id", "4634c3bd6faa25ee28811c030aae1842");
			params.add("redirect_uri", "http://localhost:8001/auth/kakao/callback");
			params.add("code", code);

			// 요청하기 위해 헤더(Header)와 데이터(Body)를 합친다.
			// kakaoTokenRequest는 데이터(Body)와 헤더(Header)를 Entity가 된다.
			HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest = new HttpEntity<>(params, headers);

			// POST 방식으로 Http 요청한다. 그리고 response 변수의 응답 받는다.
			response = rt.exchange(host, HttpMethod.POST, // 요청할 방식
					kakaoTokenRequest, // 요청할 때 보낼 데이터
					String.class // 요청 시 반환되는 데이터 타입
			);
			log.info("서버에서 응답받은 토큰정보: " + response);

			ObjectMapper objectMapper = new ObjectMapper();

			OAuthToken oauthToken = null;

			oauthToken = objectMapper.readValue(response.getBody(), OAuthToken.class);

			access_Token = oauthToken.getAccess_token();
			refresh_Token = oauthToken.getRefresh_token();
			System.out.println("카카오 엑세스 토큰:" + access_Token);
			System.out.println("리프레쉬 토큰:" + refresh_Token);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return access_Token;
	}

	public KakaoVO getUserInfo(String access_Token, HttpSession session) throws IOException {
//받아온 access_Token으로 사용자 정보 요청 카카오 서버에.
		
		RestTemplate rt = new RestTemplate();
		String host = "https://kapi.kakao.com/v2/user/me";
		ResponseEntity<String> response;
		KakaoVO kakaoUser = new KakaoVO();
		// HTTP POST를 요청할 때 보내는 데이터(body)를 설명해주는 헤더도 만들어 같이 보내줘야 한다.
		try {
			HttpHeaders headers = new HttpHeaders();
			// 헤더값 하나 더 추가(토큰값)
			headers.add("Authorization", "bearer " + access_Token);
			headers.add("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

			HttpEntity<MultiValueMap<String, String>> kakaoProfileRequest = new HttpEntity<>(headers);

			// POST 방식으로 Http 요청한다. 그리고 response2 변수의 응답 받는다.
			// exchange(): 모든 HTTP요청 메소드를 지원하며 원하는 서버에 요청시켜주는 메소드
			response = rt.exchange(host, // https://{요청할 서버 주소}
					HttpMethod.POST, // 요청할 방식
					kakaoProfileRequest, // 요청할 때 보낼 데이터
					String.class // 요청 시 반환되는 데이터 타입
			);
			String userInfo = response.getBody();
			
			System.out.println(userInfo);// 사용자 정보: 아이디, 이메일

			JsonElement element = JsonParser.parseString(userInfo);

			JsonObject properties = element.getAsJsonObject().get("properties").getAsJsonObject();
			JsonObject kakao_account = element.getAsJsonObject().get("kakao_account").getAsJsonObject();

			String nickname = properties.getAsJsonObject().get("nickname").getAsString();
			String email = kakao_account.getAsJsonObject().get("email").getAsString();

			kakaoUser.setNickname(nickname);
			kakaoUser.setKakaoEmail(email);
			System.out.println("userInfo에서 추출한 유저 객체 : " + kakaoUser);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// JSP로 사용자 정보 전달

		return kakaoUser; // VO객체로 변환해서 반환
	}

}
