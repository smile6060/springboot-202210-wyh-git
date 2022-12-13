package IocAndDi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IocController {

    //    @Autowired(required = false) 기본값은 true임
    @Autowired
    @Qualifier("usi2")
    private UserService userService;

    @ResponseBody
    @GetMapping("/ioc")
    public String iocTest() {
        userService.createUser();
        userService.getUser();
        userService.updateUser();
        userService.deleteUser();
        return null;
    }
}