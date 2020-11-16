<%@page import="kr.or.ddit.member.model.MemberVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<script>
	$(document).ready(function(){
		$(".y_board").on("click", function(){
			//console.log("click");
			
			// data-board_sq
			var board_sq = $(this).data("board_sq");
			console.log("board_sq : " + board_sq);

			document.location="/board/detail?board_sq=" + board_sq; 
			
		});
	});
</script>

<div class="row">
	<div class="col-sm-8 blog-main">
		<h2 class="sub-header">${param.gubun_nm }</h2>
		<div class="table-responsive">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>게시글 번호</th>
						<th>제목</th>
						<th>작성자 아이디</th>
						<th>작성일시</th>
					</tr>
				</thead>
				<tbody id="boardList">
					<c:forEach items="${boardList }" var="board">
						<c:choose>
							<c:when test="${board.board_yn =='n' }">
								<tr>
							</c:when>
							<c:otherwise>
								<tr class="y_board" data-board_sq="${board.board_sq }">
							</c:otherwise>
						</c:choose>
						
							<td>${board.rn }</td>	
						
						<c:choose>
							<c:when test="${board.board_yn =='n' }">
								<td>[삭제된 게시글 입니다.]</td>
							</c:when>
							<c:otherwise>
								<td>${board.board_title } </td>
							</c:otherwise>
						</c:choose>
						
							<td>${board.userid } </td>
							
							<!-- format : yyyy-MM-dd -->
							<td><fmt:formatDate value="${board.board_date }" pattern="yyyy-MM-dd"/></td>
						
						</tr>
						
					</c:forEach>
					
				</tbody>
			</table>
		</div>

		<a class="btn btn-default pull-right" href="${cp }/board/regist?gubun_sq=${param.gubun_sq }&userid=${S_MEMBER.userid }">새글 등록</a>
		
		<div class="text-center">
			<ul class="pagination">
				<c:choose>
					<c:when test="${cpage == 1 }">
						<li class="active"><span>&lt;&lt;</span></li>								
						<li class="active"><span>&lt;</span></li>								
					</c:when>
					<c:otherwise>
						<li><a href="${cp }/board/list?gubun_sq=${gubun_sq }&page=1">&lt;&lt;</a></li>
						<li><a href="${cp }/board/list?gubun_sq=${gubun_sq }&page=${cpage-1}">&lt;</a></li>
					</c:otherwise>
				</c:choose>
				
				<c:forEach var="i" begin="1" end="${pages }" step="1">
					<c:choose>
						<c:when test="${i == page }">
							<li class="active"><span>${i }</span></li>								
						</c:when>
						<c:otherwise>
							<li><a href="${cp }/board/list?gubun_sq=${gubun_sq }&page=${i }">${i }</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				
				<c:choose>
					<c:when test="${cpage == pages }">
						<li class="active"><span>&gt;</span></li>								
						<li class="active"><span>&gt;&gt;</span></li>								
					</c:when>
					<c:otherwise>
						<li><a href="${cp }/board/list?gubun_sq=${gubun_sq }&page=${cpage+1}">&gt;</a></li>
						<li><a href="${cp }/board/list?gubun_sq=${gubun_sq }&page=${pages}">&gt;&gt;</a></li>
					</c:otherwise>
				</c:choose>
				
			</ul>
		</div>
	</div>
</div>

