package com.sbs.sbb.Question;

import com.sbs.sbb.Answer.Answer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity                                                         // Question 테이블
public class Question {
    @Id                                                         // Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY)         // auto_increment
    private Integer id;

    @Column(length = 200)                                       // VARCHAR(200) 타입
    private String subject;

    @Column(columnDefinition = "TEXT")                          // TEXT 타입
    private String content;

    private LocalDateTime createDate;

//  mappedBy에 적힌 question은 Answer에 있는 question과 이름이 같아야한다.
//  CascadeType.REMOVE를 하면 Question을 삭제할 때 답변도 함께 삭제된다.
//  OneToMany는 테이블의 컬럼으로 생성되지 않는다.
//  OneToMany는 선택적이다.
    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    private List<Answer> answerList;
}