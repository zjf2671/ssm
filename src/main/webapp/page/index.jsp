<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="/page/common/base.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <title>小型婚礼</title>
        <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
        <script type="text/javascript" src="<%=basePath%>js/index.js"></script>
    </head>
    <body>
        <!--[if ie 6]>
        <style type="text/css">
            .mask {position: absolute; height: 800px;}
            .pop-box {_position: absolute;}
        </style>
        <![endif]-->
		
		<audio autoplay="autoplay"  loop="loop">
			<source src="mp3/ghyjn.mp3" type="audio/mpeg">
		      你的浏览器不支持audio标签
		</audio>
        <div class="box">
            <!-- 场景一 -->
            <div class="first-box">
                <div class="first-horn">
                    <img src="images/first_horn.jpg"/>
                </div>
                <div class="first-txt">
                    <div class="txt1"><img src="images/first_txt1.jpg"/></div>
                    <div class="txt2"><img src="images/first_txt2.jpg"/></div>
                </div>
            </div>

            <!-- 场景二 -->
            <div class="second-box">
                <div class="second-people">
                    <img src="images/second_people.jpg"/>
                </div>
                <div class="second-txt">
                    <img src="images/second_txt.jpg"/>
                </div>
            </div>

            <!-- 场景三 -->
            <div class="three-box">
                <div class="three-img">
                    <img src="images/three_img.jpg"/>
                </div>
            </div>

            <!-- 场景四 -->
            <div class="fore-box">
                <div class="fore-img">
                    <img src="images/fore_img.jpg"/>
                </div>
            </div>

            <!-- 场景五 -->
            <div class="five-box">
                <div class="five-img">
                    <img src="images/five_img.jpg"/>
                    <div class="u-enter">进入婚礼</div>
                </div>
            </div>

            <!-- 场景六 -->
            <div class="six-box">
                <div></div>
                <div></div>
                <div></div>
                <div></div>
                <div></div>
                <div></div>
                <div></div>
                <div></div>
                <div></div>
                <div></div>
                <div></div>
                <div></div>
                <div></div>
                <div></div>
                <div></div>
                <div></div>
            </div>

            <!-- 场景七 -->
            <div class="seven-box2">
                <!-- <div class="clickMe">点我送祝福</div> -->
                <div id="greetlist" class="seven-content">
                 <%-- <c:forEach items="${greetings }" var="greet" varStatus="status">
                    <div id="${greet.id}" class="${greet.classes}" style="${greet.style}">${greet.text}</div>
                    </c:forEach> --%>
                </div>
            </div>
        </div>

        <!-- 遮罩层 -->
        <!-- <div class="mask"></div>
        <div class="pop-box">
            <h1>送上祝福语</h1>
            <textarea id="write">写上您的祝福吧~</textarea>
            <div class="u-sure" id="uSure">确定</div>
        </div> -->

    </body>
</html>