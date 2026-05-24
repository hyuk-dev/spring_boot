package web.mvc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.mvc.domain.FreeBoard;
import web.mvc.domain.Reply;
import web.mvc.service.FreeBoardService;
import web.mvc.service.ReplyService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/reply")
public class ReplyController {
    private final ReplyService replyService;

    private final FreeBoardService freeBoardService;

    @PostMapping("/writeForm")
    public String writeForm(@RequestParam("bno") Long bno, Model model) {
        model.addAttribute("bno", bno);
        return "reply/write";
    }

    @PostMapping("/insert")
    public String insert(@RequestParam("bno") Long bno, Reply reply) {
        //댓글이 달릴 게시물이 존재하는지 확인
        FreeBoard freeboard = freeBoardService.selectBy(bno, false);
        reply.setFreeBoard(freeboard);
        replyService.insert(reply);
        return "redirect:/board/read/" + bno;
    }

    @GetMapping("/delete/{rno}/{bno}")
    public String delete(@PathVariable("rno") Long rno, @PathVariable("bno") Long bno) {
        replyService.delete(rno);
        return "redirect:/board/read/" + bno;
    }
}
