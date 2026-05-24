package web.mvc.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.mvc.domain.User;
import web.mvc.service.UserService;

@Controller
@RequestMapping("/user")
@Slf4j
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("/{url}")
    public void getUserForm() {
    }

    @PostMapping("/loginCheck")
    public String loginCheck(HttpSession httpSession, @ModelAttribute User user) {
        log.info("user : {}", user);
        User verifiedUser = userService.loginCheck(user);
        httpSession.setAttribute("loginUser", verifiedUser);

        log.info("loginCheck verifiedUser : {}", verifiedUser);
        return "index";
    }

    @GetMapping("/logout")
    public String logout(HttpSession httpSession) {
        httpSession.removeAttribute("loginUser");
        return "redirect:/";
    }


}
