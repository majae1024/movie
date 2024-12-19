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

	//���޹��� CODE�� OauthToken���� �޾Ƽ� Access_Token������ ������
	public String getAccessToken(String code) throws IOException {
		String access_Token = "";
		String refresh_Token = "";

		// POST ������� key=value �����͸� ��û (īī��������)
		// �� �� �ʿ��� ���̺귯���� RestTemplate, �긦 ���� http ��û�� ���ϰ� �� �� �ִ�.
		RestTemplate rt = new RestTemplate();

		// �ΰ��ڵ�� ��ū �ޱ�
		String host = "https://kauth.kakao.com/oauth/token";// https://{��û�� ���� �ּ�}
		ResponseEntity<String> response;
		
		try {
			// HTTP POST�� ��û�� �� ������ ������(body)�� �������ִ� ����� ����� ���� ������� �Ѵ�.
			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

			// body �����͸� ���� ������Ʈ�� MultiValueMap�� ������
			// body�� ���� key, value�� ������ �̷������ ������ �ڹٿ��� �������ִ� MultiValueMap Ÿ���� ����Ѵ�.
			MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
			params.add("grant_type", "authorization_code");
			params.add("client_id", "4634c3bd6faa25ee28811c030aae1842");
			params.add("redirect_uri", "http://localhost:8001/auth/kakao/callback");
			params.add("code", code);

			// ��û�ϱ� ���� ���(Header)�� ������(Body)�� ��ģ��.
			// kakaoTokenRequest�� ������(Body)�� ���(Header)�� Entity�� �ȴ�.
			HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest = new HttpEntity<>(params, headers);

			// POST ������� Http ��û�Ѵ�. �׸��� response ������ ���� �޴´�.
			response = rt.exchange(host, HttpMethod.POST, // ��û�� ���
					kakaoTokenRequest, // ��û�� �� ���� ������
					String.class // ��û �� ��ȯ�Ǵ� ������ Ÿ��
			);
			log.info("�������� ������� ��ū����: " + response);

			ObjectMapper objectMapper = new ObjectMapper();

			OAuthToken oauthToken = null;

			oauthToken = objectMapper.readValue(response.getBody(), OAuthToken.class);

			access_Token = oauthToken.getAccess_token();
			refresh_Token = oauthToken.getRefresh_token();
			System.out.println("īī�� ������ ��ū:" + access_Token);
			System.out.println("�������� ��ū:" + refresh_Token);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return access_Token;
	}

	public KakaoVO getUserInfo(String access_Token, HttpSession session) throws IOException {
//�޾ƿ� access_Token���� ����� ���� ��û īī�� ������.
		
		RestTemplate rt = new RestTemplate();
		String host = "https://kapi.kakao.com/v2/user/me";
		ResponseEntity<String> response;
		KakaoVO kakaoUser = new KakaoVO();
		// HTTP POST�� ��û�� �� ������ ������(body)�� �������ִ� ����� ����� ���� ������� �Ѵ�.
		try {
			HttpHeaders headers = new HttpHeaders();
			// ����� �ϳ� �� �߰�(��ū��)
			headers.add("Authorization", "bearer " + access_Token);
			headers.add("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

			HttpEntity<MultiValueMap<String, String>> kakaoProfileRequest = new HttpEntity<>(headers);

			// POST ������� Http ��û�Ѵ�. �׸��� response2 ������ ���� �޴´�.
			// exchange(): ��� HTTP��û �޼ҵ带 �����ϸ� ���ϴ� ������ ��û�����ִ� �޼ҵ�
			response = rt.exchange(host, // https://{��û�� ���� �ּ�}
					HttpMethod.POST, // ��û�� ���
					kakaoProfileRequest, // ��û�� �� ���� ������
					String.class // ��û �� ��ȯ�Ǵ� ������ Ÿ��
			);
			String userInfo = response.getBody();
			
			System.out.println(userInfo);// ����� ����: ���̵�, �̸���

			JsonElement element = JsonParser.parseString(userInfo);

			JsonObject properties = element.getAsJsonObject().get("properties").getAsJsonObject();
			JsonObject kakao_account = element.getAsJsonObject().get("kakao_account").getAsJsonObject();

			String nickname = properties.getAsJsonObject().get("nickname").getAsString();
			String email = kakao_account.getAsJsonObject().get("email").getAsString();

			kakaoUser.setNickname(nickname);
			kakaoUser.setKakaoEmail(email);
			System.out.println("userInfo���� ������ ���� ��ü : " + kakaoUser);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// JSP�� ����� ���� ����

		return kakaoUser; // VO��ü�� ��ȯ�ؼ� ��ȯ
	}

}
