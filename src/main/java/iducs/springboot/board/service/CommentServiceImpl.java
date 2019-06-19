package iducs.springboot.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iducs.springboot.board.domain.Comment;
import iducs.springboot.board.entity.AnswerEntity;
import iducs.springboot.board.repository.AnswerRepository;

@Service("answerService")
public class CommentServiceImpl implements CommentService {
	@Autowired 
	private AnswerRepository repository;
	
	@Override
	public Comment getAnswerById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Comment> getAnswers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveAnswer(Comment answer) {
		AnswerEntity entity = new AnswerEntity();
		entity.buildEntity(answer);
		repository.save(entity);
	}

	@Override
	public void updateAnswer(Comment question) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAnswer(Comment question) {
		// TODO Auto-generated method stub

	}

}
