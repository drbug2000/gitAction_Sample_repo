package space.space_spring.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import space.space_spring.argument_resolver.JwtPreAuth;
import space.space_spring.config.testConfig;
import space.space_spring.response.BaseResponse;

@RestController
@Slf4j
public class TestController {
    private testConfig testEnv;
    @Autowired
    public TestController(testConfig testEnv) {
        this.testEnv = testEnv;
    }
    @Value("${secret.jwt-secret-key}")
    private String JWT_SECRET_KEY;
    @Value("${secret.jwt-expired-in}")
    private Long JWT_EXPIRED_IN;


    @Value("${spring.datasource.url}")
    private String DB_URL;

    @GetMapping("/testEnv")
    public String testEndpoint() {
        return "Test Environment Value: "+testEnv.getEnv() ;
    }

    @GetMapping("/testEnvSec")
    public String testSecretENVEndpoint() {
        return "Test <br>JWT_SECRET_KEY: "+JWT_SECRET_KEY
                +"<br>JWT_EXPIRED_IN: "+JWT_EXPIRED_IN+
                "<br>DB URL: "+DB_URL;
    }
    @GetMapping("/test")
    public String test(){
        return "CI/CD 환경 구축 테스트 중. 이 메세지가 보인다면 성공입니다";
    }

    @GetMapping("/test/jwt")
    public BaseResponse<String> jwtTest(@JwtPreAuth Long userId) {
        //Test 주석
        log.info("userId = {}", userId);
        return new BaseResponse<>("jwt test 성공");
    }

    @GetMapping("/test/chore")
    public BaseResponse<String> choreBranchTest(@JwtPreAuth Long userId) {
        log.info("userId = {}", userId);
        return new BaseResponse<>("이 글자가 보인다면, chore branch 가 배포 된 것입니다. 수정 되었습니다. 한번 더 되었습니다");
    }
}
