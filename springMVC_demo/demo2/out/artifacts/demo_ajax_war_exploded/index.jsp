<%--
  Created by IntelliJ IDEA.
  User: xzh
  Date: 2021/6/26
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script src="${pageContext.request.contextPath}/statics/js/jquery-3.6.0.js"></script>
    <script>
      function a(){
        $.post({
          url:"${pageContext.request.contextPath}/a1",
          data:{"name":$("#username").val()},
          success:function (data) {
            alert(data);
          }
        })
      }
      function a1(){
        $.post({
          url:"${pageContext.request.contextPath}/a3",
          data: {"name":$("#username").val()},
          success:function (data) {
            if(data.toString()=="ok"){
              $("#userInfo").css("color","green")
            } else {
              $("#userInfo").css("color","red")
            }

            $("#userInfo").html(data)
          }

        })
      }
      function a2(){
        $.post({
          url:"${pageContext.request.contextPath}/a3",
          data: {"pwd":$("#pwd").val()},
          success:function (data) {

          }
        })
      }
    </script>
  </head>
  <body>
<%--  失去焦点的时候，发送一个请求到后台--%>
  <p>
    用户名：<input type="text" id="username" onblur="a1()" value="">
    <span id="userInfo"></span>
  </p>

  <p>
    密码：<input type="text" id="pwd" onblur="a2()" value="">
    <span id="pwdInfo"></span>
  </p>
  </body>
</html>
<%--JQuery语法
$(this).hide()
演示 jQuery hide() 函数，隐藏当前的 HTML 元素。
$("#test").hide()
演示 jQuery hide() 函数，隐藏 id="test" 的元素。
$("p").hide()
演示 jQuery hide() 函数，隐藏所有 <p> 元素。
$(".test").hide()
演示 jQuery hide() 函数，隐藏所有 class="test" 的元素。
--%>