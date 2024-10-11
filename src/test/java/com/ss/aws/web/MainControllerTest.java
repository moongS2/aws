package com.ss.aws;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class MainControllerTest {

	@Autowired
	private TestRestTemplate rest;

	@Test
	public void test_main() {
		ResponseEntity<String> resp = rest.getForEntity("/aws/v1", String.class);

		assertEquals("<h1>aws v1 </h1>", resp.getBody());
	}

}

/*
 * 배포
 * 1. EC2 고정 ip 할당받기
 * 2. 모바텀으로 ssh 연결하기
 * 3. git EC2 ( 내 컴퓨터에 다운로드 되어있는지 확인)
 * 		git --version
 * /
 */