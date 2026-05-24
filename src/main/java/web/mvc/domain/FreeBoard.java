package web.mvc.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
//@Table(name = "이름설정..")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString//(exclude = "repliesList")
public class FreeBoard { //db에 free_board
    @Id //pk
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "free_bno_seq")
    @SequenceGenerator(name = "free_bno_seq", allocationSize = 1, sequenceName = "free_bno_seq")
    private Long bno;
    private String subject;
    private String writer;

    @Column(length = 500)
    private String content;
    private String password;
    private int readnum; //조회수

    @CreationTimestamp
    private LocalDateTime insertDate; //등록일

    @UpdateTimestamp
    private LocalDateTime updateDate; //수정


    //부모글 한개에 딸린 댓글 정보
    /**
     * cascade sms  Entity 의 상태변화가 생기면 연관관계 있는
     * Entity도 상태변화를 전이시키는 옵션
     *
     */
    //@OneToMany(mappedBy = "freeBoard" , cascade = CascadeType.ALL) //  지연로딩
    @OneToMany(mappedBy = "freeBoard", fetch = FetchType.LAZY) //  지연로딩
    private List<Reply> repliesList;


    public FreeBoard(Long bno) {
        this.bno = bno;
    }


}











