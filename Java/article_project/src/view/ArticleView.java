package view;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import dto.ArticleDTO;
import dto.CommentDTO;
import repository.ArticleRepository;
import service.ArticleService;
import service.CommentService;

public class ArticleView implements ViewInterface{
	public Scanner sc = new Scanner(System.in);
	public ArticleService articleService = new ArticleService();
	public CommentService commentService = new CommentService();
	
	@Override
	public void showAll() {
		System.out.println("전체 게시글 목록");
		List<ArticleDTO> dtoLists = articleService.findAll();
		
		printHeader();
		if(dtoLists.size() == 0) {
			System.out.println("게시글이 없습니다.");
		} else {
			for(ArticleDTO dto : dtoLists) {
				// 날짜 포맷을 변환해서 전달
				String insertDate = dto.getInsertedDate()
										.format(DateTimeFormatter
										.ofPattern("yyyy-MM-dd HH:mm:ss"));
				
				System.out.println(dto.getId() + "\t" + 
									dto.getName() + "\t" +
									dto.getTitle() + "\t" +
									insertDate);  
				// 해당 게시글의 댓글을 출력하는 부분
				for(CommentDTO comment : dto.getCommentLists()) {
					System.out.println(comment);
				}
			}	
		}
		
		printLine();
	}

	void printHeader() {
		System.out.println("=========================");
		System.out.println("ID      작성자         제목         작성일");
		System.out.println("----------------------------------------------");
	}
	void printLine() {
		System.out.println("=========================");
	}
	
	
	@Override
	public void showNewArticle() {
		while(true) {
			System.out.println("✒ 새글 입력창입니다.");
			System.out.println("작성자 : ");
			String name = sc.next();
			
			System.out.println("제목 : ");
			String title = sc.next();
			
			System.out.println("내용 : ");
			String content = sc.next();
			
			ArticleDTO dto = ArticleDTO
					.makeArticleDto(
							ArticleRepository.articleId, 
							name, 
							title, 
							content);
			// 다음 입력 아이디 생성
			ArticleRepository.articleId ++;
			int result = articleService.newArticle(dto);
			if(result > 0) {
				System.out.println("게시글이 등록되었습니다.");
			} else {
				System.out.println("게시글 등록이 실패하었습니다.");
			}
			
			return;
		}
	}

	@Override
	public void showDetail() {
		System.out.println("게시글 상세보기 패이지");
		System.out.println("상세보기 아이디 입력 : ");
		Long id = sc.nextLong();
		
		ArticleDTO dto = ArticleDTO.fromEntity(articleService.findById(id)) ;
		viewDetail(dto);
	}

	private void viewDetail(ArticleDTO dto) {
		System.out.println("✨ id : " + dto.getId());
		System.out.println("✨ name : " + dto.getName());
		System.out.println("✨ title : " + dto.getTitle());
		System.out.println("✨ content : " + dto.getContent());
		System.out.println("✨ createdDate : " + dto.getInsertedDate()
									.format(DateTimeFormatter
									.ofPattern("yyyy-MM-dd HH:mm:ss")));
		if(dto.getUpdatedDate() != null) {
			System.out.println("✨ updatedDate : " + dto.getUpdatedDate()
			.format(DateTimeFormatter
			.ofPattern("yyyy-MM-dd HH:mm:ss")));
		}
		
		showArticleCommentsMenu(dto);
	}

	private void showArticleCommentsMenu(ArticleDTO dto) {
		System.out.println("◈◈◈  댓글 리스트  ◈◈◈");
		if(dto.getCommentLists().size() == 0) {
			System.out.println("해당 게시글의 댓글은 없습니다.");
		} else {
			for(CommentDTO comment : dto.getCommentLists()) {
				System.out.println(comment);
			}
		}
		
		// 댓글관련 메뉴 보이기
		
		while(true) {
			System.out.println("1. 댓글입력 2. 댓글수정 3. 댓글삭제 4. 돌아가기");
			int num = sc.nextInt();
			switch(num) {
			case 1 : 
				System.out.println("새로운 댓글을 추가합니다.");
				System.out.println("댓글 작성자 : ");
				String name = sc.next();
				System.out.println("댓글 내용 : ");
				String content = sc.next();
				CommentDTO comment = new CommentDTO(
						null,
						dto.getId(),
						name,
						content,
						LocalDateTime.now(),
						null
						);
				commentService.addComment(comment);
				break;
			case 2 : 
				System.out.println("댓글을 수정합니다.");
				System.out.println("수정할 댓글 번호 입력 : ");
				Long updateNum = sc.nextLong();
				System.out.println("수정할 댓글 내용 : ");
				String updateContent = sc.next();
				
				// 수정 내용 입력받아서 DTO 저장
				CommentDTO updateComment = new CommentDTO(
						updateNum,
						dto.getId(),
						"",
						updateContent,
						null,
						LocalDateTime.now()
						);
				commentService.updateComment(updateComment);
				break;
			case 3 : 
				System.out.println("댓글을 삭제합니다.");
				System.out.println("삭제할 댓글 번호 입력 : ");
				Long deleteNum = sc.nextLong();
				commentService.deleteComment(deleteNum);
				break;
			case 4 : 
				return;
			default :
				System.out.println("잘못 입력했습니다.");
				break;
			}
		}
	}

	@Override
	public void showDelete() {
		System.out.println("게시글 삭제 페이지");
		System.out.println("삭제할 ID를 입력하세요");
		Long id = sc.nextLong();
		int result = articleService.delete(id);
		if(result > 0) {
			System.out.println("정상적으로 삭제되었습니다.");
		} else {
			System.out.println("삭제에 실패하였습니다.");
		}
	}

	@Override
	public void showUpdate() {
		System.out.println("게시글 수정 페이지");
		System.out.println("수정할 게시글 ID 입력");
		Long id = sc.nextLong();
		ArticleDTO dto = ArticleDTO.fromEntity(articleService.findById(id)) ;
		viewDetail(dto);
		System.out.println("수정할 제목 : ");
		String updateTitle = sc.next();
		System.out.println("수정할 내용 : ");
		String updateContent = sc.next();
		
		ArticleDTO updateDto = new ArticleDTO();
		updateDto.setId(id);
		updateDto.setName(dto.getName());
		updateDto.setTitle(updateTitle);
		updateDto.setContent(updateContent);
		updateDto.setInsertedDate(dto.getInsertedDate());
		updateDto.setUpdatedDate(LocalDateTime.now());
		int result = articleService
				.update(ArticleDTO.makeNewArticle(updateDto));
		System.out.println("수정 완료");
	}

}
