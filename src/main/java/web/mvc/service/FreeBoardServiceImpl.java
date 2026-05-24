package web.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.mvc.domain.FreeBoard;
import web.mvc.exception.BasicException;
import web.mvc.exception.ErrorCode;
import web.mvc.repository.FreeBoardRepository;

import java.util.List;

@Service
public class FreeBoardServiceImpl implements FreeBoardService {
    @Autowired
    private FreeBoardRepository freeBoardRepository;

    @Override
    public List<FreeBoard> selectAll() {
        return freeBoardRepository.findAll(PageRequest.of(0, 5, Sort.by("insertDate").descending())).getContent();
    }

    @Override
    public Page<FreeBoard> selectAll(Pageable pageable) {

        return freeBoardRepository.findAll(pageable);
    }

    @Override
    public void insert(FreeBoard board) {
        freeBoardRepository.save(board);
    }

    /**
     * 글번호 검색
     * : 조회수 증가....
     * - state가 true이면 조회수 증가한다.
     * <p>
     * :  bno에 해당하는 게시물을 조회 호출한다.
     * <p>
     * 힌트 : freeRep.findById(bno).orElseThrow(()-> new BasicException(ErrorCode.FAILED_DETAIL));
     *
     */
    @Override
    public FreeBoard selectBy(Long bno, boolean state) {
        FreeBoard board = freeBoardRepository.findById(bno).orElseThrow();
        board.getRepliesList().size(); //댓글목록을 조회해서 가져오는 시점에 db에서 조회해온다. (지연로딩)
        if (state) {
            board.setReadnum(board.getReadnum() + 1);
            freeBoardRepository.save(board);
        }
        return board;
    }

    @Override
    @Transactional
    public FreeBoard update(FreeBoard board) {
        FreeBoard existedBoard = freeBoardRepository.findById(board.getBno()).orElseThrow(() -> new BasicException(ErrorCode.FAILED_UPDATE));
        if (existedBoard.getPassword() == null || !existedBoard.getPassword().equals(board.getPassword())) {
            throw new BasicException(ErrorCode.WRONG_PASS);
        }
        FreeBoard updateBoard = freeBoardRepository.save(board);
        return updateBoard;
    }

    @Override
    @Transactional
    public void delete(Long bno, String password) {
        FreeBoard existedBoard = freeBoardRepository.findById(bno).orElseThrow(() -> new BasicException(ErrorCode.FAILED_DELETE));
        if (existedBoard.getPassword() == null || !existedBoard.getPassword().equals(password)) {
            throw new BasicException(ErrorCode.WRONG_PASS);
        }
        freeBoardRepository.deleteById(bno);
    }
}
