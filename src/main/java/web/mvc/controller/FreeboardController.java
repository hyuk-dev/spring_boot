package web.mvc.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.mvc.domain.FreeBoard;
import web.mvc.service.FreeBoardService;

import java.util.List;

@Controller
@RequestMapping("/board")
public class FreeboardController {
    @Autowired
    private FreeBoardService freeBoardService;

    @GetMapping("/{url}")
    public String getBoardForm(HttpSession httpSession, @PathVariable("url") String url) {
        if (httpSession.getAttribute("loginUser") == null) {
            return "redirect:/user/login"; // 로그인 페이지로 리다이렉트
        }

        return "board/" + url;
    }

    @GetMapping("/list")
    public String getBoardList(Model model, HttpSession httpSession) {
        if (httpSession.getAttribute("loginUser") == null) {
            return "redirect:/user/login";
        }
        List<FreeBoard> freeList = freeBoardService.selectAll();

        model.addAttribute("freeList", freeList);
        return "board/list";
    }

    @GetMapping("/read/{bno}")
    public String getBoardDetail(@PathVariable("bno") Long bno, Model model) {
        FreeBoard board = freeBoardService.selectBy(bno, true);
        model.addAttribute("board", board);

        return "board/read";
    }

    @PostMapping("/insert")
    public String insertBoard(FreeBoard board) {
        freeBoardService.insert(board);
        return "redirect:/board/list";
    }

    @PostMapping("/updateForm")
    public String updateForm(@RequestParam("bno") Long bno, Model model) {
        FreeBoard board = freeBoardService.selectBy(bno, false);
        model.addAttribute("board", board);
        return "board/update";
    }

    @PostMapping("/update")
    public String updateBoard(FreeBoard board) {
        freeBoardService.update(board);
        return "redirect:/board/read/" + board.getBno();
    }

    @PostMapping("/delete")
    public String deleteBoard(@RequestParam("bno") Long bno, @RequestParam("password") String password) {
        freeBoardService.delete(bno, password);
        return "redirect:/board/list";
    }
}
