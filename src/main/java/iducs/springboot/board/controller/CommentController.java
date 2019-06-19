package iducs.springboot.board.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import iducs.springboot.board.domain.Comment;
import iducs.springboot.board.domain.Question;
import iducs.springboot.board.domain.User;
import iducs.springboot.board.exception.ResourceNotFoundException;
import iducs.springboot.board.repository.UserRepository;
import iducs.springboot.board.service.CommentService;
import iducs.springboot.board.service.QuestionService;
import iducs.springboot.board.service.UserService;
import iducs.springboot.board.utils.HttpSessionUtils;

@Controller
@RequestMapping("/questions/{questionId}/answers")
public class CommentController {
	@Autowired CommentService answerService; // 의존성 주입(Dependency Injection) 
	@Autowired QuestionService questionService;

	@PostMapping("")
	// public String createUser(Answer answer, Model model, HttpSession session) {
	public String createAnswer(@PathVariable Long questionId, String contents,HttpSession session) {
		User sessionUser = (User) session.getAttribute("user");
		Question question = questionService.getQuestionById(questionId);
		Comment newAnswer = new Comment(sessionUser, question, contents);
		answerService.saveAnswer(newAnswer);
		return String.format("redirect:/questions/%d", questionId);
	}
	

}
