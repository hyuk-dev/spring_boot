package web.mvc.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import web.mvc.domain.FreeBoard;

public interface FreeBoardService {
   /**
    * 전체검색
    * */
	List<FreeBoard> selectAll();
	
	/**
	 * 전체검색 - Page처리
	 * */
	Page<FreeBoard> selectAll(Pageable pageable);
	
	/**
	 * 등록
	 * */
	void insert(FreeBoard board);
	
	/**
	 * 글번호 검색 
	 *   : 조회수 증가....
	 *      - state가 true이면 조회수 증가한다.

	     :  bno에 해당하는 게시물을 조회 호출한다.
		  
		    힌트 : freeRep.findById(bno).orElseThrow(()-> new BasicException(ErrorCode.FAILED_DETAIL));
	 * */
	FreeBoard selectBy(Long bno , boolean state);
	
	/**
	 * 수정하기
	    :1)수정전에 비번 일치를 확인하기 위해서 bno에 해당하는 정보를 조회한다.

		2) 조회된 게시물이 없으면 ErrorCode.FAILED_UPDATE 예외 발생

		3) 조회된 게시물이 있으면 비밀번호 일치여부를 확인한다.
		      비번이 일치하지 않으면 ErrorCode.WRONG_PASS 예외 발생
			  비번이 일치하면  content와 subject을 수정한다. 
			  수정된 객체를 리턴한다.
	 * */
	
    FreeBoard update(FreeBoard board);

    
    /**
     * 삭제하기
	    : 삭제전에 bno에 해당하는 게시물을 조회한다.
		 조회된 게시물이 없으면 ErrorCode.FAILED_DELETE 예외발생
		조회된 게시물이 있으면 비밀번호 일치를 확인한다 

		비번이 틀리면 ErrorCode.FAILED_DELETE 예외발생
		비번이 일치하면 삭제한다.
     * */
    void delete(Long bno,String password);
}










