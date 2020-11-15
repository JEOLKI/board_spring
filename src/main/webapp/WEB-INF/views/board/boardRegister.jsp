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

		cnt = 1;
		
		$("#atchBtn").on('click', function(){

			if($(".fileinput").length < 5){
				
				var input = '<input class="fileinput" id="file'+cnt+'" type="file" name="file'+cnt+'"/>';
				$('#filediv').append(input)

				cnt = cnt + 1;
			}
		})
	});

</script>

<form id="boardRegFrm" action="${cp }/boardRegist" method="POST" enctype="multipart/form-data">
	<input class="form-control" type="text" placeholder="글제목" id="board_title" name="board_title"><br>
	<textarea id="summernote" name="editordata"></textarea>
	<div id="filediv">
		<button id="atchBtn" type="button">첨부파일추가</button>
	</div>
	<input id="boardRegBtn" type="button" value="저장">
</form>

