<%@ include file="../includes/topbar.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.nio.file.Path"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<title>장비 게시판(글작성)</title>
<style>
.align-center { text-align: center; } 
</style>

<script type="text/javascript"
	src="../../../resources/CKEditorSample/ckeditor/ckeditor.js"></script>
	 <script src="http://code.jquery.com/jquery-latest.min.js"></script>
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script type="text/javascript">
  	function check_fn(e){
  		var type = $('select[name=li_type]').val()
  		var type_check = "종목선택"
  		var category = $('select[name=li_category]').val()
  		var category_check = "장비선택"

  		var title = $('input[name=li_title]').val()
  		if(title == ''){
  			alert('제목을 입력해주세요.')
  			return false
  		}else if(title.length >30){
  			alert('제목을 줄여주세요.')
  		}
  		
  		if(type == type_check || category == category_check){
  			alert('카테고리를 골라주세요.')
  			return false
  		}
  		return true
  	}
  	
  	//수정하는 폼
	function modify(){
  		$('input[name=status]').val(2)
  		alert('수정')
  		$('form').attr('action','modify')
  		//$('form').submit()
  	}
  	
  	

  </script>
	<div class="container">
	
		 <form id="form" method="post" onsubmit="return check_fn()" >
			<c:forEach var="board" items="${page }">
				<input type="hidden" name="li_index" value="${board.li_index }"/>
				<input type="hidden" name="li_b_type" value="${board.li_b_type }"/>
			</c:forEach>
			 <!--	<c:forEach var="board" items="${page }">
					<c:choose>
						<c:when test="${board.li_index ne null}">
							action="/li/modify"
						</c:when>
						<c:otherwise>
							action="/li/insert"
						</c:otherwise>
					</c:choose>
				</c:forEach>  -->	
			
					<div class="col-sm-12">
					
						<h1>커뮤니티 <small> 
								<%-- <c:when test="${b_type eq '후기게시판'}">장비평가</c:when> --%>
						글작성 </small></h1>
						<br>
							<div class="input-group mb-1" style="width: 75%;">
								<div class="input-group-prepend align-center">
									<label class="input-group-text">제목</label>
								</div>
								<!-- 상세페이지에서 데이터를 불러왔다면 value값에  값저장  -->
								<input name="li_title" type="text" class="form-control"
									<c:forEach var="board" items="${page }">
										<c:choose>
											<c:when test="${board.li_title ne null}">
												value="${board.li_title}"
											</c:when>
										</c:choose>
									</c:forEach>
								>
							</div>
					</div>
				<br>
				<div>
					<div class="col-sm-12" style="text-align: center;">
						<div class="input-group mb-12">
							<label class="input-group-text">카테고리 
							<select
								name="li_type" class="custom-select custom-select-sm"
								style="margin-left: 10px">
									<option>종목선택</option>
									<option value="all">모두</option>
									<option value="육상"
									<c:forEach var="load" items="${page }">
									
					<c:out value="${load.li_type eq '육상'?'selected':''}"/>
					</c:forEach>
									>육상</option>
									<option value="자전거"
									<c:forEach var="load" items="${page }">
					<c:out value="${load.li_type eq '자전거'?'selected':''}"/>
					</c:forEach>
									>자전거</option>
							</select> 
							<select name="li_category" class="custom-select custom-select-sm"
								style="margin-left: 10px">
									<option>장비선택</option>
									<option value="운동복"
									<c:forEach var="load" items="${page }">
					<c:out value="${load.li_category eq '운동복'?'selected':''}"/>
					</c:forEach>
									>운동복</option>
									<option value="안전장비"
									<c:forEach var="load" items="${page }">
					<c:out value="${load.li_category eq '안전장비'?'selected':''}"/>
					</c:forEach>
									>안전장비</option>
									<option value="신발"
									<c:forEach var="load" items="${page }">
					<c:out value="${load.li_category eq '신발'?'selected':''}"/>
					</c:forEach>
									>신발</option>
									<option value="기타"
									<c:forEach var="load" items="${page }">
					<c:out value="${load.li_category eq '기타'?'selected':''}"/>
					</c:forEach>
									>기타</option>
									<%-- <c:forEach items=”${사용할변수}” var=”넘어온데이터”>
									<option value=”${사용할변수.값}”
										${아이템.변수}
									</option> 
								</c:forEach>--%>
							</select>
							</label>
						</div>
					</div>
				</div>
	
				<hr>
			
				<div class="row justify-content-md-center">
					<div class="col_c" style="margin-bottom: 30px">
						<div class="input-group">
							<p><textarea class="textarea" name="li_text" id="li_place">
									<c:forEach var="board" items="${page }">
										<c:choose>
											<c:when test="${board.li_text ne null}">
												${board.li_text}
											</c:when>
										</c:choose>
									</c:forEach>
								</textarea>
							</p>
							<script type="text/javascript">
								CKEDITOR.replace('li_place');
							</script>
						</div>
					</div>
				</div>
			
	<!--  썸네일 -->
			<!-- 	      <div class="row justify-content-md-center">
		            <div class="input-group mb-3">
		              <div class="input-group-prepend">
		                <span class="input-group-text" id="inputGroupFileAddon01">썸네일</span>
		              </div>
		              <div class="custom-file">
		                  &nbsp;<input name="li_thumbnail" type="file" class="form-control-file" id="exampleFormControlFile1">
		              </div>
		            </div>
		      </div> -->
	
				<div class="row justify-content-md-center">
					<button type="submit" id="btnsave" class="btn btn-outline-secondary"
						style="width: 10%; font-weight: bold; margin-bottom: 30px; margin-left: 10px"
													<c:forEach var="board" items="${page }">
										<c:choose>
											<c:when test="${board.li_index ne null}">
												onclick="modify()"
											</c:when>
										</c:choose>
									</c:forEach>
						>등록</button>
				</div>
			
			</form>
		</div>
<%@ include file="../includes/footer.jsp"%>