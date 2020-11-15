<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<script type="text/javascript">
	$(function(){
		$.ajax({url : "/boardGu/list",
			method : "get",
			success : function(data){
				var html = "";
				for(var i = 0; i< data.boardGubunList.length ; i++){
					var gubun = data.boardGubunList[i];
					if(gubun.gubun_yn == "y"){
						
					html += '<li class="active"><a href="/board/list?gubun_sq='+ gubun.gubun_sq +'&gubun_nm='+gubun.gubun_nm+'">'+gubun.gubun_nm+'</a></li>';

					}
				};
				$('#boardGuList').append(html);
			}
		});	
	});
</script>


<ul class="nav nav-sidebar" id="boardGuList">
	<li class="active"><a href="${cp }/boardGu/regist">게시판생성</a></li><br>
</ul>