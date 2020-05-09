<%@ include file="../includes/topbar.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<title>MY Page</title>

<head>

	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="">
	<meta name="author" content="">
	<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>

</head>

<body>

  <div class="container">

    <!-- Page Heading/Breadcrumbs -->
    <h1 class="mt-4 mb-3">My Page
    	<small>&nbsp;환영합니다! ${sessionVO.m_id}님</small>
	</h1>

    <ol class="breadcrumb">
      <li class="breadcrumb-item">
        <a href="#">Home</a>
      </li>
      <li class="breadcrumb-item active">Portfolio 2</li>
    </ol>

    <div class="row">
    <!-- 내 정보 -->
      <div class="col-lg-4 portfolio-item">
        <div class="card h-100">
          <div class="card-body">
			<img alt="" id="thumbnail" src="data:image/jsp;base64, ${sessionVO.m_picture}" height="200"/>

          </div>
        </div>
     </div>
    <div class="col-lg-8 portfolio-item">
        <div class="card h-100">
          <div class="card-body">
			<p>nickName : ${sessionVO.m_nickName}</p>
			<!--  <p>pw : ${sessionVO.m_pw}</p>-->
			<p>name : ${sessionVO.m_name}</p>
			<p>gender : ${sessionVO.m_gender}</p>
			<p>birth : ${sessionVO.m_birth}</p>
			<p>email : ${sessionVO.m_email_1}</p>
			<p>tel : ${sessionVO.m_tel}</p>
			<p>address : ${sessionVO.m_address}</p>
          </div>
        </div>
     </div>
    <!-- 나의 관심코스 -->
      <div class="col-lg-12 portfolio-item">
        <div class="card h-100">
          <div class="card-body" id="importMyCourse" style="background-color: #e9ecef;">
          	<a href="/mp/myCourse">나의 관심코스 보기</a>
          </div>
          <div class="card-body" id="importMyCourse">
          	
          	
            <h6 class="card-title" style="margin-bottom: -10px; float: right;">
              <a href="/mp/myCourse">상세보기</a>
            </h6>
          </div>
        </div>
      </div>
      <div class="col-lg-6 portfolio-item">
        <div class="card h-100">
          <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
          <div class="card-body">
            <h4 class="card-title">
              <a href="#">Project Two</a>
            </h4>
            <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Fugit aliquam aperiam nulla perferendis dolor nobis numquam, rem expedita, aliquid optio, alias illum eaque. Non magni, voluptates quae, necessitatibus unde temporibus.</p>
          </div>
        </div>
      </div>
      <div class="col-lg-6 portfolio-item">
        <div class="card h-100">
          <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
          <div class="card-body">
            <h4 class="card-title">
              <a href="#">Project Three</a>
            </h4>
            <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam viverra euismod odio, gravida pellentesque urna varius vitae.</p>
          </div>
        </div>
      </div>
      <div class="col-lg-6 portfolio-item">
        <div class="card h-100">
          <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
          <div class="card-body">
            <h4 class="card-title">
              <a href="#">Project Four</a>
            </h4>
            <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Fugit aliquam aperiam nulla perferendis dolor nobis numquam, rem expedita, aliquid optio, alias illum eaque. Non magni, voluptates quae, necessitatibus unde temporibus.</p>
          </div>
        </div>
      </div>
      <div class="col-lg-6 portfolio-item">
        <div class="card h-100">
          <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
          <div class="card-body">
            <h4 class="card-title">
              <a href="#">Project Five</a>
            </h4>
            <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam viverra euismod odio, gravida pellentesque urna varius vitae.</p>
          </div>
        </div>
      </div>
      <div class="col-lg-6 portfolio-item">
        <div class="card h-100">
          <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
          <div class="card-body">
            <h4 class="card-title">
              <a href="#">Project Six</a>
            </h4>
            <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Fugit aliquam aperiam nulla perferendis dolor nobis numquam, rem expedita, aliquid optio, alias illum eaque. Non magni, voluptates quae, necessitatibus unde temporibus.</p>
          </div>
        </div>
      </div>
    </div>
    <!-- /.row -->

  </div>
</body>

<script type="text/javascript">




</script>


<%@ include file="../includes/footer.jsp"%>