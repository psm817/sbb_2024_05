package com.sbs.sbb.Answer;

import com.sbs.sbb.Question.Question;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity                                                     // answer 테이블
public class Answer {
    @Id                                                     // Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // auto_increment
    private Integer id;

    @Column(columnDefinition = "TEXT")                      // TEXT 타입
    private String content;

    private LocalDateTime createDate;

//    private Integer qusetionId;
//    ManyToOne은 필수로 작성
//    Question 하나(One)에 여러개 Answer(Many)
    @ManyToOne
    private Question question;
}
