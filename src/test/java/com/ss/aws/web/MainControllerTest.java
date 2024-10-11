package com.ss.aws.web;

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

/* 배포 
 * 1. EC2 고정 ip 할당 받기
 * 2. 모바텀으로 ssh 연결하기 
 * 3. git EC2 (내 컴퓨터에 다운로드 되어있는지 확인)
 *    git --version
 *    git 버전이 나올 시에는 설치 안해도됨!
 *    만약 버전이 안나오면!
 *    git 을 apt를 이용해서 git을 다운 받으면 됨
 *    
 *    apt 사용시 apt목록을 업데이트!
 *    
 *    실제 파일을 다운로드 받으면 폴더 안으로 들어가서
 *    그래들과 관련된 파일을 찾는다.
 *    그래들을 실행할수 있도록 권한을 설정!
 *    chmod u+x 파일명
 * 
 *    폴더 삭제 
 *    rm -rf aws(파일명)
 *    -r 폴더와 폴더 하위 폴더 모두 삭제
 *    -f 강제 삭제(파일 삭제시 확인안함)
 *    
 *    다시 클론해서 실행파일로 변경! gradlew
 *    
 *    그래들을 이용해서 빌드를 하게 되면 java파일을
 *    컴파일할 JDK가 없다고 뜬다.
 *    
 *    apt를 이용해서 자바JDK설치
 * 		sudo apt-cache search jdk
 *      sudo apt-cache search jdk | grep openjdk-11
 *      sudo apt install openjdk-11-jdk
 *      다운 완료시 확인
 *      java --version 
 * 
 */