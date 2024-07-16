package space.space_spring.Controller;

import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import space.space_spring.config.testConfig;

@RestController
public class TestController {
    private testConfig testEnv;
    @Autowired
    public TestController(testConfig testEnv) {
        this.testEnv = testEnv;
    }
//    @Autowired
//    private testConfig testEnv;
//    @Value("${test.env}")
//    private String testEnv;
    @Value("${secret.jwt-secret-key}")
    private String gwtKey;

    @GetMapping("/test")
    public String testEndpoint() {
        return "Test Environment Value: " + testEnv;
    }
    @GetMapping("/test")
    public String test(){
        return "CI/CD 환경 구축 테스트 중. 이 메세지가 보인다면 성공입니다";
    }


    @GetMapping("/cdtest")
    public String cdtest(){
        return "CD 환경 구축 테스트 중. \n새로운 컨트롤러가 업데이트 되었습니다." +
                "\n이 메세지가 보인다면 성공입니다.";
    }
}
