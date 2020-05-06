<%@ include file="../includes/topbar.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<title>회원가입</title>

</head>
<body>
  <div class="container">
    <div class="row">
      <div class="col-lg-10 col-xl-9 mx-auto">
        <div class="card card-signin flex-row my-5">
          <div class="card-img-left d-none d-md-flex">
                       <!-- Background image for card set in CSS! -->
          </div>
      <div class="card-body">
		<h5 class="card-title text-center">Register</h5>
		<hr>
		<form id="form" action="/ms/regist" class="form-signin"
		 enctype="multipart/form-data" method="post" onSubmit="return sub()">
			<div class="input-group">
				<input type="text" class="form-control" id="m_id"
					placeholder="User ID" name="m_id" required autofocus> 
				<button type="submit" class="btn btn-secondary" id="idSearch" onclick='idNickCheck()'>
					중복확인
				</button>
			</div>
			<span id="idChk"></span>
			<div class="input-group" style="margin-top: 15px">
				<input type="text" class="form-control" id="m_nickName"
					placeholder="User NickName" name="m_nickName" required> 
				<button type="submit" class="btn btn-secondary" id="nickSearch" onclick='idNickCheck()'>
					중복확인
				</button>
			</div>
			<span id="nickChk"></span>
			<div id="password">
			<div class="input-group" style="margin-top: 15px">
				<input type="password" class="form-control" id="m_pw1" onkeyup="passwordCheck(this.value)"
					placeholder="password" name="m_pw1" required> 
			</div>
			<div class="input-group" style="margin-top: 5px">
				<input type="password" class="form-control" id="m_pw2" onkeyup="passwordCheck(this.value)"
					placeholder="password confirm" name="m_pw2" required> 
			</div>
			<div class="alert alert-success" id="alert-success" style="display:none">
				비밀번호가 일치합니다.
			</div> 
			<div class="alert alert-danger" id="alert-danger" style="display:none">
				비밀번호가 일치하지 않습니다.
			</div>
			</div>


			
			<div class="input-group" style="margin-top: 15px">
				<input type="text" class="form-control" id="m_name"
					placeholder="User Name" name="m_name" required> 
			</div>
			<div class="input-group" style="margin-top: 15px; ">
				<input type="radio" name="m_gender" value="남" checked>남
				&nbsp;&nbsp;&nbsp;
				<input type="radio" name="m_gender" value="여">여
			</div>
			
			<div class="input-group" style="margin-top: 15px">
			생년월일 &nbsp; : &nbsp;<input type="date" value="1990-01-01" min="1900-01-01" max="2020-12-31"
			style="font-size: 16px; font-family: Consolas, sans-serif;" name="m_birth">
			</div>
					  
			<div id="emailConfirm">
			<div class="input-group" style="margin-top: 15px">
				<input type="text" class="form-control" id="m_email_1"
					placeholder="E-mail" name="m_email_1" required>
				<button type="submit" class="btn btn-secondary" id="mailChk" onclick='mailCheck()'>
					Email인증
				</button>
			</div>
			<div id="mailChk2" class="input-group" style="margin-top: 5px"></div>
			<div class="alert alert-success" id="email-success" style="display:none">
				Email 인증완료 
			</div> 
			<div class="alert alert-danger" id="email-danger" style="display:none">
				Email 인증번호가 일치하지 않습니다.
			</div>
			</div>

			<div class="input-group" style="margin-top: 15px">
				<input type="text" class="form-control" id="m_tel"
					placeholder="Phone number" name="m_tel" required>
			</div>
			
			<div class="input-group" style="margin-top: 15px">
				<input type="text" class="form-control" id="m_address"
					placeholder="Address" name="m_address" required>
			</div>
			
			<label style="margin-top: 10px">Picture</label>

			<!-- 파일업로드. 안됨.
			<div class="custom-file">&nbsp;
          		<input type="file" class="form-control-file" 
            		id="exampleFormControlFile1" name="m_picture">
      		</div>
      		 -->

			<hr> 
			<button class="btn btn-primary btn-block text-uppercase" 
			id="submit" type="submit">Register</button>
			
		</form>
		<form>
		 <hr class="my-4">
	           <button class="btn  btn-google btn-block text-uppercase" 
	           	type="submit"><i class="fab fa-google mr-2"></i> Sign up with Google
	           </button>
	           <button class="btn  btn-facebook btn-block text-uppercase" 
	          	 type="submit"><i class="fab fa-facebook-f mr-2"></i> Sign up with Facebook
	          	 </button>
		</form>
	</div>
</div>
</div>
</div>
</div>
</body>

<script>
	$("#submit").attr("disabled", "disabled");
	
	function idNickCheck(){
		var e = window.event;
        btn = e.target || e.srcElement;
		var area = btn.id;
		var name = "";
		if(area == 'idSearch'){
			name = $('input[name=m_id]').val();
		}else name = $('input[name=m_nickName]').val();
        console.log("area : "+area);
        console.log("name : "+name);
		$.ajax({
			type : "get",
			url : '/ms/regist/idCheck',
			data : {"data" : name, "area" : area},
			dataType : "json",
			success : function(data){
				var ch = JSON.stringify(data);
				console.log("id check success :"+ch);
				if(area=='idSearch') {
					if(ch<1) {
						$('#idChk').html('<b>사용가능</b>');
						$("#submit").removeAttr("disabled"); 
					}else {
						$('#idChk').html('<b>사용불가</b>');
					}
				}else if(area=='nickSearch'){
					if(ch<1) {
						$('#nickChk').html('<b>사용가능</b>');
						$("#submit").removeAttr("disabled"); 
					}else {
						$('#nickChk').html('<b>사용불가</b>');
					}
				}
			},
			error : function(data) {
				console.log("error : "+ (JSON.stringify(data)));
			}
		});
	};
	

	function passwordCheck(){
		$("#alert-success").hide();
		$("#alert-danger").hide();
		$("#password").keyup(function(){
			var m_pw1 = $("#m_pw1").val();
			var m_pw2 = $("#m_pw2").val();
			console.log(m_pw1+","+m_pw2);
			if(m_pw1 != "" || m_pw2 != ""){
				if(m_pw1 == m_pw2){
					$("#alert-success").show();
					$("#alert-danger").hide();
					$("#submit").removeAttr("disabled"); 
				}else{
					$("#alert-success").hide();
					$("#alert-danger").show();
				} 
			} 
		}); 
	}
	
	function emailCheck(key){
		$("#email-success").hide();
		$("#email-danger").hide();
		$("#emailConfirm").keyup(function(){
			var m_email_1 = key;
			var m_email_2 = $("#m_email_2").val();
			console.log(m_pw1+","+m_pw2);
			if(m_email_1 != "" || m_email_2 != ""){
				if(m_email_1 == m_email_2){
					$("#email-success").show();
					$("#email-danger").hide();
					$("#submit").removeAttr("disabled"); 
				}else{
					$("#email-success").hide();
					$("#email-danger").show();
				}
			}
		});
	}
	
	function mailCheck(){
		$.ajax({
			type : "POST",
			url : '/ms/regist/mailCheck',
			data : {"m_email_1" : $('#m_email_1').val(), "m_id" : $('#m_id').val()},
			dataType : "json",
			success : function(data){
				var key = JSON.stringify(data);
				console.log("email check success! key :"+key);
				var mailChk = "";
				mailChk += '<div class="input-group" style="margin-top: 5px">'
							+ '<input type="text" class="form-control" id="m_email_2"'
							+ 'placeholder="인증번호를 입력해주세요."'
							+ 'onkeyup="emailCheck('+key+', this.value)"></div>';
				$('#mailChk2').html(mailChk);
			},
			error : function(data) {
				console.log("error : "+ (JSON.stringify(data)));
			}
		});
	}
	
</script>


<%@ include file="../includes/footer.jsp"%>