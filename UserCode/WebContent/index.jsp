<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>  
  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
    <head>  
        <title>��֤��</title>  
        <script language="javascript">  
function myReload() {  
    document.getElementById("CreateCheckCode").src = document  
            .getElementById("CreateCheckCode").src  
            + "?nocache=" + new Date().getTime();  
}  
</script>  
    </head>  
  
    <body>  
        <form action="check.jsp" method="post">  
            <input name="checkCode" type="text" id="checkCode" title="��֤�����ִ�Сд"  
                size="8" ,maxlength="4" />  
            <img src="PictureCheckCode" id="CreateCheckCode" align="middle">  
            <a href="" onclick="myReload()"> ������,��һ��</a>  
            <input type="submit" value="�ύ" />  
        </form>  
    </body>  
</html>  
