package com.sbs.sbb;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
//@Transactional                  // Transactional 어노테이션을 사용하면 자동으로 Rollback이 적용
//@Rollback                       // Rollback 어노테이션을 사용하면 실제 DB에 적용되지 않음
class SbbApplicationTests {
	@Autowired
	private QuestionRepository questionRepository;
    @Autowired
    private AnswerRepository answerRepository;

    @Transactional
	@Test
	void testJpa() {
        // 데이터 추가
        // insert into question set ~~ 과 같은 역할
//		Question q1 = new Question();
//		q1.setSubject("sbb가 무엇인가요?");
//		q1.setContent("sbb에 대해서 알고 싶습니다.");
//		q1.setCreateDate(LocalDateTime.now());
//		this.questionRepository.save(q1);  // 첫번째 질문 저장
//
//		Question q2 = new Question();
//		q2.setSubject("스프링부트 모델 질문입니다.");
//		q2.setContent("id는 자동으로 생성되나요?");
//		q2.setCreateDate(LocalDateTime.now());
//		this.questionRepository.save(q2);  // 두번째 질문 저장

		// findAll
		// expected 기댓값에 맞지 않으면 테스트 실패처리가 된다.
		// SELECT * FROM question 과 같은 결과
//		List<Question> all = this.questionRepository.findAll();
//		assertEquals(2, all.size());
//
//		Question q = all.get(0);
//		assertEquals("sbb가 무엇인가요?", q.getSubject());

		// findById
		// Optional은 무조건 0 또는 1이다.
		// SELECT * FROM question WHERE id = 1 과 같은 결과
		// Optional을 사용하면 우아한 처리가 가능한데, 우아한 처리란 null safe를 의미
		// nullpointerException이 있을 때 안전한 처리가 가능하다는 뜻
//		Optional<Question> oq = this.questionRepository.findById(1);
//		if(oq.isPresent()) {
//			Question q = oq.get();
//			assertEquals("sbb가 무엇인가요?", q.getSubject());
//		}

		// findBySubject
		// Optional을 사용하지 않고, findBySubject 메서드는 QuestionRepository에서 추가하면 된다.
		// SELECT * FROM question WHERE subject = 'sbb가 무엇인가요?' 와 같은 결과
//		Question q = this.questionRepository.findBySubject("sbb가 무엇인가요?");
//		assertEquals(1, q.getId());

		// findBySubjectAndContent
		// SELECT * FROM question WHERE subject = 'sbb가 무엇인가요?' AND content = 'sbb에 대해서 알고 싶습니다.' 와 같은 결과
//		Question q = this.questionRepository.findBySubjectAndContent(
//				"sbb가 무엇인가요?", "sbb에 대해서 알고 싶습니다.");
//		assertEquals(1, q.getId());

        // 데이터 수정하기
        // Optional을 사용했기 때문에 oq.get()으로 한 번 더 가져와야한다.
        // findById(1)을 통해 id가 1인 question을 가져오고, 가져온 question의 값을 변경
        // UPDATE question SET subject = '수정된 제목' WHERE id = 1 과 같은 역할
//        Optional<Question> oq = this.questionRepository.findById(1);
//        assertTrue(oq.isPresent());
//        Question q = oq.get();
//        q.setSubject("수정된 제목");
//        this.questionRepository.save(q);

        // 데이터 삭제하기
        // findById(1)을 통해 id가 1인 question을 가져오고, 가져온 question을 삭제
        // DELETE FROM question WHERE id = 1 와 같은 역할
//        assertEquals(2, this.questionRepository.count());
//        Optional<Question> oq = this.questionRepository.findById(1);
//        assertTrue(oq.isPresent());
//        Question q = oq.get();
//        this.questionRepository.delete(q);
//        assertEquals(1, this.questionRepository.count());

        // 답변 저장하기
        // Autowired를 통해 answerRepository 객체를 생성
        // INSERT INTO answer SET ~~ 과 같은 역할
//        Optional<Question> oq = this.questionRepository.findById(2);
//        assertTrue(oq.isPresent());
//        Question q = oq.get();
//
//        Answer a = new Answer();
//        a.setContent("네 자동으로 생성됩니다.");
//        a.setQuestion(q);  // 어떤 질문의 답변인지 알기위해서 Question 객체가 필요하다.
//        a.setCreateDate(LocalDateTime.now());
//        this.answerRepository.save(a);

        // 답변 조회하기
        // left join을 활용하여 조회한 결과와 같음.
//        Optional<Answer> oa = this.answerRepository.findById(1);
//        assertTrue(oa.isPresent());
//        Answer a = oa.get();
//        assertEquals(2, a.getQuestion().getId());

        // 질문을 통해 답변을 조회하기
        // id가 2인 질문을 찾고, 답변은 여러개일 수도 있기 떄문에 List로 답변을 찾는다.
        // id가 2인 질문을 찾고, 해당 세션이 끝나기 때문에 이럴 경우는 @Transactional 어노테이션을 사용한다.
        Optional<Question> oq = this.questionRepository.findById(2);
        assertTrue(oq.isPresent());
        Question q = oq.get();

        List<Answer> answerList = q.getAnswerList();

        assertEquals(1, answerList.size());
        assertEquals("네 자동으로 생성됩니다.", answerList.get(0).getContent());
	}

}
