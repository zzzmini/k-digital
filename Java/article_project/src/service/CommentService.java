package service;

import crudInterface.CRUDInterface;
import dao.ArticleDAO;
import dto.CommentDTO;

public class CommentService {
	CRUDInterface commentDAO = new ArticleDAO();

	public void updateComment(CommentDTO comment) {
		commentDAO.updateComment(CommentDTO.fromDTO(comment));
	}

	public void addComment(CommentDTO comment) {
		commentDAO.insertComment(CommentDTO.fromDTO(comment));
	}

	public void deleteComment(Long deleteNum) {
		commentDAO.deleteComment(deleteNum);
	}

}
