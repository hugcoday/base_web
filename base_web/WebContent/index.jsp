<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<link rel="shortcut icon" type="image/ico" href="/img/favicon.ico" />	
		<title>My Company Name</title>		
		<link href="css/styles.css" type="text/css" media="screen" rel="stylesheet" />		
	</head>
	<body id="login">

		<div id="wrappertop"></div>
			<div id="wrapper">
					<div id="content">
						<div id="header">
							<h1><a href=""><img src="img/logo1.png" alt="Groupcotton"></a></h1>
						</div>
						<div id="darkbanner" class="banner320">
							<h2>登录</h2>

						</div>
						<div id="darkbannerwrap">
						</div>
						<form name="welcome" method="post" action="welcome">
						<fieldset class="form">
                        	                                                                                       <p>
								<label for="user_name">用户：</label>
								<input name="accountCode" id="accountCode" type="text" value="" />

							</p>
							<p>
								<label for="password">密码：</label>
								<input name="password" id="password" type="password" />
							</p>
							<button type="submit" class="positive" name="Submit">
								<img src="img/key.png" alt="Announcement"/>登录</button>
								<ul id="forgottenpassword">

								<li class="boldtext">|</li>
								<li><a href="#">忘记密码?</a></li>
							</ul>
                            						</fieldset>
						
						
					</div>
				</div>   

<div id="wrapperbottom_branding"><div id="wrapperbottom_branding_text">By <a href="#" style='text-decoration:none'>Groupcotton</a>. <a href="#" style='text-decoration:none'>Project, Client & Billing management</a></div></div>