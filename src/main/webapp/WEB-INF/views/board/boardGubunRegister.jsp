<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>

	$(document).ready(function(){

		$.ajax({url : "/boardGu/list",
			method : "get",
			success : function(data){
				for(var i = 0; i< data.boardGubunList.length ; i++){
					var gubun = data.boardGubunList[i];

					html = "";

					html += '<form action="${cp }/boardGu/update" method="POST">';
					html += '<label for="gubun_nm">게시판 이름</label>';
					html += '<input type="text" name="gubun_nm" value="'+gubun.gubun_nm+'">';
					html += '<input HIDDEN type="text" name="gubun_sq" value="'+gubun.gubun_sq+'">';
					html += '<select name="gubun_yn">';

					if(gubun.gubun_yn == "y"){

					html += '			<option selected="selected">사용</option>';
					html += '			<option>미사용</option>';

					} else if (gubun.gubun_yn == "n"){

					html += '			<option>사용</option>';
					html += '			<option selected="selected">미사용</option>';

					}
					
					html += '</select>';
					html += '<button id="updateBtn" data-gubun_sq="'+gubun.gubun_sq+'" type="summit">수정</button> <br>';
					html += '</form>';

					$("#updateFrm").append(html);
				};

				
			}
		});	
		
		$("#regBtn").on('click', function(){
			$("#frm").submit();
		});
			
	});

</script>


<form id="frm" role="form" action="${cp }/boardGu/regist" method="POST">
	
	<label for="gubun_nm">게시판 이름</label>
	
	<input type="text" id="gubun_nm" name="gubun_nm" placeholder="게시판 이름">

	<select id="gubun_yn" name="gubun_yn">
		<option>사용</option>
		<option>미사용</option>
	</select>

	<button id="regBtn" type="button">생성</button>
	
</form>

<div id="updateFrm">


</div>

				

