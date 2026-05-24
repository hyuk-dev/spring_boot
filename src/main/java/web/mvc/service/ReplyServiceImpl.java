package web.mvc.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.mvc.domain.Reply;
import web.mvc.exception.BasicException;
import web.mvc.exception.ErrorCode;
import web.mvc.repository.ReplyRepository;

@Service
@Slf4j
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService {
    private final ReplyRepository replyRepository;

    @Override
    @Transactional
    public void insert(Reply reply) {
        replyRepository.save(reply);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        replyRepository.findById(id).orElseThrow(() -> new BasicException(ErrorCode.NOTFOUND_ID));
        replyRepository.deleteById(id);
    }
}
