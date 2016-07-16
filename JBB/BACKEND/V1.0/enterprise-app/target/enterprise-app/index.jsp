<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	body{
       background: url('<%=request.getContextPath()%>/static/image/bg.png') no-repeat;
       background-size:100% 100%;
	}
    .mobile{
       float: right;
       margin-top: 5%;
       margin-right: 20%;
    }
    .introduction{
       float: right;
       margin-top: 10%;
    }
    .logo{
       float: right;
       margin-top: 2%;
       margin-right: 40%;
    }
    .slogan{
       margin-top: 60%;
       margin-left: -34%;
    }
    .android-download{
       float: right;
       margin-top: 30%;
       margin-right: 48%;
    }
</style>
</head>
<body>
	<div class="bgd">
		<div class="mobile">
			<img src= "<%=request.getContextPath()%>/static/image/iphone-white.png" >
		</div>
		<div class="introduction">
            <div class="logo">
                <img src="<%=request.getContextPath()%>/static/image/logo.png">
            </div>

            <div class="slogan">
                <img src="<%=request.getContextPath()%>/static/image/slogan.png">
            </div>

            <div class="android-download">
                <a href="<%=request.getContextPath()%>/static/file/jbbClient.apk"><img src="<%=request.getContextPath()%>/static/image/android.png">
            </div>
		</div>
	</div>
</body>
</html>