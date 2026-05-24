package web.mvc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import web.mvc.domain.FreeBoard;
import web.mvc.domain.Reply;
import web.mvc.domain.User;
import web.mvc.repository.FreeBoardRepository;
import web.mvc.repository.ReplyRepository;
import web.mvc.repository.UserRepository;

@SpringBootTest
class UserBoardApplicationTests {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FreeBoardRepository freeBoardRepository;

    @Autowired
    private ReplyRepository replyRepository;

    @Test
    void contextLoads() {
    }

    @Test
    @DisplayName("회원가입 테스트")
    void registerTest() {
        userRepository.save(User.builder()
                .userId("user1")
                .pwd("pass1")
                .name("홍길동")
                .build());
    }

    @Test
    @DisplayName("게시물 등록 테스트")
    void boardPostTest() {
        for (int i = 1; i <= 200; i++) {
            freeBoardRepository.save(FreeBoard.builder()
                    .subject("게시물 제목 " + i)
                    .content("게시물 내용 " + i)
                    .writer("작성자 " + i)
                    .password("pass" + i)
                    .build());
        }
    }

    @Test
    @DisplayName("댓글 등록 테스트")
    void replyPostTest() {
        for (int i = 1; i <= 10; i++) {
            replyRepository.save(Reply.builder()
                    .content("댓글 내용 " + i)
                    .freeBoard(new FreeBoard(1L)) // 1번 게시물에 댓글 등록
                    .build());
        }
    }

}
