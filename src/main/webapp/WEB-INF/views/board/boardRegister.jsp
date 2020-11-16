<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!-- include summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>

<script>
	$(document).ready(function(){

		$('#summernote').summernote({
				 height: 600
		});

		$('#boardRegBtn').on('click', function(){
			
			$("#boardRegFrm").submit();
			
		});

		$("#atchBtn").on('click', function(){

			if($(".fileinput").length < 5){
				
				var input = '<input class="fileinput" type="file" name="file"/>';
				$('#filediv').append(input)

			}
		})
	});

</script>

<form id="boardRegFrm" action="${cp }/board/regist" method="POST" enctype="multipart/form-data">
	<input class="form-control" type="text" placeholder="글제목" id="board_title" name="board_title"><br>
	<textarea id="summernote" name="board_content"></textarea>
	<input hidden="hidden" type="text" value="${userid }" name="userid" id="userid"/>
	<input hidden="hidden" type="text" value="${board_p_sq }" name="board_p_sq" id="board_p_sq"/>
	<input hidden="hidden" type="text" value="${gubun_sq }" name="gubun_sq" id="gubun_sq"/>
	<input hidden="hidden" type="text" value="${group_no }" name="group_no" id="group_no"/>
	<div id="filediv">
		<button id="atchBtn" type="button">첨부파일추가</button>
	</div>
	<input id="boardRegBtn" type="button" value="저장">
</form>

