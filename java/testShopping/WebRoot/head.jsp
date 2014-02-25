<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!--只把table引入即可 -->
<table width="100%" border="0" class="comm">
  <tr>
    <td  height="10" colspan="5" bgcolor="#FF9966"></td>
  </tr>
  <tr>
    <td width="22%" height="90"><img src="imgs/paperman.jpg" width="220" height="110" /></td>
    <td width="23%"><img src="imgs/profilo.jpg" width="220" height="110" /></td>
    <td width="22%"><img src="imgs/dongzhenge.jpg" width="220" height="110" /></td>
    <td width="21%"><img src="imgs/aimozhen.jpg" width="220" height="110" /></td>
    <td width="12%" align="left" valign="middle"><p align="left"><img src="imgs/sina.gif" width="28" height="24" /><span class="comm">【我的账号</span>】</p>
    <p><img src="imgs/qqmail.gif" width="28" height="31" />【我的购物车】</p></td>
  </tr>
  <tr>
    <td height="10" colspan="5" bgcolor="#FF9966"></td>
  </tr>
  <tr>
    <td  colspan="5" bgcolor="#FFFFFF"><table width="100%" border="0">
      <tr>
        <td width="11%">&nbsp;</td>
        <td width="11%" class="navi">首页</td>
        <td width="11%">&nbsp;</td>
        <td width="11%" class="navi">香港电影</td>
        <td width="11%">&nbsp;</td>
        <td width="11%" class="navi">大陆电影</td>
        <td width="11%">&nbsp;</td>
        <td width="11%" class="navi">关于我们</td>
        <td width="11%">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
</table>