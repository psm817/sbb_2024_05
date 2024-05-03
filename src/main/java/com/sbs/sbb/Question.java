package com.sbs.sbb;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

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
}