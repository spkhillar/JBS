<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>JOBSbySMS-Enquiry</title>
<link rel="shortcut icon" href="resources/images/favico.png">

<spring:url value="/resources/css/style1.css" var="resourceStyle1CssUrl"/>
<spring:url value="/resources/css/enquirymenu.css" var="resourceEnquiryCssUrl"/>
<spring:url value="/resources/css/indexpage.css" var="resourceIndexPageCssUrl"/>

<spring:url value="/resources/js/jquery.js" var="resourceJq2Url"/>
<spring:url value="/resources/js/jquery.easing.js" var="resourceEasingUrl"/>
<spring:url value="/resources/js/jquery.touchSwipe.min.js" var="resourceTouchSwipeUrl"/>
<spring:url value="/resources/js/script.js" var="resourceScriptUrl"/>



<script type="text/javascript" src="${resourceJq2Url}"></script>
<script type="text/javascript" src="${resourceEasingUrl}"></script>
<script type="text/javascript" src="${resourceTouchSwipeUrl}"></script>
<script type="text/javascript" src="${resourceScriptUrl}"></script>

<link rel="stylesheet" type="text/css" href="${resourceEnquiryCssUrl}"/>
<link rel="stylesheet" type="text/css" href="${resourceIndexPageCssUrl}"/>
<link rel="stylesheet" type="text/css" href="${resourceStyle1CssUrl}"/>

<script type="text/javascript">
 $(document).ready( function(){	
		// buttons for next and previous item						 
		var buttons = { previous:$('#jslidernews1 .button-previous') ,
						next:$('#jslidernews1 .button-next') };			
		 $('#jslidernews1').lofJSidernews( { interval : 4000,
											direction		: 'opacitys',	
											easing			: 'easeInOutExpo',
											duration		: 1200,
											auto		 	: true,
											maxItemDisplay  : 4,
                      mobile   : true,
											navPosition     : 'horizontal', // horizontal
											navigatorHeight : 32,
											navigatorWidth  : 80,
											mainWidth		: 980,
											buttons			: buttons } );	
	});
</script>


<style>    
* { margin: 0; padding: 0; }

html { height: 100%; font-size: 62.5% }

body { height: 100%; background-color: #FFFFFF; font: 1.2em Verdana, Arial, Helvetica, sans-serif; }


#indextb tr td #jobtb tr .joblist form fieldset label {
	text-align: left;
}
</style>


<style type="text/css">

/* ==================== Form style sheet for IE ==================== */

fieldset { padding: 22px 17px 12px 17px; position: relative; margin: 12px 0 34px 0; }
legend { position: absolute; top: -12px; left: 10px; }
label.float { margin: 5px 0 0 0; }
label { margin: 0 0 5px 0; }
label.spam-protection { display: inline; width: auto; position: relative; top: -3px; }
input.choose { border: 0; margin: 0; }
input.submit-button { margin: -10px 0 0 0; }

/* ==================== Form style sheet for IE end ==================== */

</style>


</head>

<body>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<table height="134" border="0" id="indextb">
  <tr>
    <td height="30"><img src="resources/images/JBS_LOGO.png" id="logo"></img></td>
    <td height="30">&nbsp;</td>
    <td height="30">&nbsp;</td>
    <td height="30">&nbsp;</td>
    <td height="30" class="cationinfo"><a href="#logintb">Login</a> | New User? <a href="register">Click to Register</a></td>
    <td height="30" class="cationinfo"><a href="#">Privacy Policy</a></td>
  </tr>
  <tr>
    <td height="96" colspan="6" class="menutd"><div class="wrap" align="center">
    
    <nav>
      <ul class="menu">
        <li>
          <a class="fNiv" href="${contextPath}/">Home</a>
          </li>
        
        <li>
          <a class="fNiv" href="register/">Register</a>
          </li>
        
        <li>
          <a class="fNiv" href="#">Login</a>
          </li>
        
        <li>
          <a class="fNiv" id="enquiry" href="mypage/enquiry/">Enquiry</a> </li>
        
        <li>
          <a class="fNiv">Contact Us</a>
          </li>
        
        <li><a class="fNiv">About Us</a>
           </li>
      </ul>
      <div class="clearfix"></div>
      </nav>
    </div></td>
  </tr>
  
  <tr>
    <td height="22" colspan="6">
    
    <table  height="44%" id="adbanner">
    <tr>
      <td height="141"> <table align="center" id="scroller" border="2"><div id="container" align="center">
    		<!------------------------------------- THE CONTENT ------------------------------------------------->
<div id="jslidernews1" class="lof-slidecontent" style="width:980px; height:340px; margin:auto;" align="center">
	<div class="preload"><div></div></div>
    		 <!-- MAIN CONTENT --> 
              <div class="main-slider-content" style="width:980px; height:340px; margin:auto; " align="center">
                <ul class="sliders-wrap-inner">
                    <li>
                      <img src="resources/images/job5.jpg" title="Newsflash 9" width="" >            
                     </li> 
                     <li>
                      <img src="resources/images/job4.jpg" title="Newsflash 10" >            
                     </li> 
                     <li>
                      <img src="resources/images/job2.jpg" title="Newsflash 11" >            
                     </li> 
                  </ul>  	
            </div>
 		   	<div class="navigator-content">
                  <div class="button-next">Next</div>
                  <div class="navigator-wrapper">
                   </div>
                  <div  class="button-previous">Previous</div>
             </div> 
          <!-- BUTTON PLAY-STOP -->
          <div class="button-control"><span></span></div>
           <!-- END OF BUTTON PLAY-STOP -->
          
 </div></div></table>
</td></tr>
    </table>
     <table id="jobtb">
     <tr bgcolor="#DCDAFC">
       <td height="260" class="joblist">
     <table width="149" id="govttb">
	 <tr bgcolor="#0099CC"><td bgcolor="#D1E6E7">Latest Government Jobs</td></tr>
      <tr>
        <td height="231" class="pvtinfo">
        <ul>
          <li>Assistant Manager, State Bank of India, New Delhi,Experience: 7-10 yrs.</li><a href="#">View Details</a>
          <li>Station Manager, Railway Recruitment Board, Bhubaneswar,Experience: 5-7 yrs.</li><a href="#">View Details</a>
          <li>Assistant Professor, Indian Institite of Technology, Bhubaneswar,Experience: 6-8 yrs.</li><a href="#">View Details</a>
          <li>Research and Development Engineer, Indian Institute of Technology, Bhubaneswar,Experience: 5-8 yrs.</li><a href="#">View Details</a>
       </ul>
       <a href="governmentjobs.jsp">View More Job</a>
      </td>
      </tr>
      </table>
      </td>
       <td class="joblist"><table id="privatetb">
         <tr bgcolor="#0099CC">
           <td bgcolor="#D1E6E7">Private Sector Jobs</td>
         </tr>
         <tr>
           <td height="216" class="pvtinfo"><ul>
          	<li>Senior Java Developer, Accenture India, New Delhi,Experience: 5-8 yrs.</li><a href="#">View Details</a>
      	  	<li>Sr. Technical Consultant, Adobe Systems, Noida,Experience: 5-7 yrs.</li><a href="#">View Details</a>
          	<li>SEO Consultant,Google India, Hyderabad,Experience: 6-8 yrs.</li><a href="#">View Details</a>
          	<li>Oracle Apps Consultant,Oracle India, Bangalore,Experience: 5-8 yrs</li><a href="#">View Details</a>
       		</ul>
            <a href="privatesectorjobs.jsp">View More Job</a>
       </td>
         </tr>
       </table></td>
       <td  class="joblist"><table  id="abroadtb">
         <tr bgcolor="#0099CC">
           <td bgcolor="#D1E6E7" >International Jobs</td>
         </tr>
         <tr>
           <td height="231" class="pvtinfo"><ul>
          	 <li>Assistant Manager, State Bank of India, New Delhi,Experience: 7-10 yrs </li><a href="#">View Details</a>
      	 	 <li>Station Manager, Railway Recruitment, Bhubaneswar,Experience: 5-7 yrs</li><a href="#">View Details</a>
          	<li>Assistant Professor, Indian Institite of Technology, Bhubaneswar,Experience: 6-8 yrs</li><a href="#">View Details</a>
          	<li>Research and Development Engineer, Indian Institute of TEchnology, Bhubaneswar,Experience: 5-8 yrs</li><a href="#">View Details</a>
       		</ul>
            <a href="Internationaljobs.jsp">View More Job</a>
       </td>
         </tr>
       </table></td>
       </tr>
      </table>
    <table width="82%" height="347" border="0" id="infotb">
  <tr>
    <td width="28%" height="100">
	<form action="j_spring_security_check" method="post">
	<table width="279" border="0" id="logintb">
      <tr>
        <td colspan="2" class="cationinfo">Login to your Profile and view recommended Jobs</td>
      </tr>
      <tr>
        <td>Username</td>
        <td><label for="textfield"></label>
          <input type="text" name="j_username" id="j_username" /></td>
      </tr>
      <tr>
        <td width="27" height="31">Password</td>
        <td width="236"><label for="textfield"></label>
          <input type="password" name="j_password" id="j_password" />
          <br /></td>
      </tr>
      <tr>
        <td height="38"><label for="checkbox2"></label></td>
        <td><input type="submit" name="btn_submit2" id="btn_submit2" value="Login" />
       </td>
      </tr>
    </table></form></td>
    <td width="24%" height="100"><table width="149" id="govtorgtb">
      <tr bgcolor="#0099CC">
        <td colspan="4" bgcolor="#CCCCCC">Government Organisations</td>
      </tr>
      <tr>
        <td width="21%">&nbsp;</td>
        <td width="24%">&nbsp;</td>
        <td width="26%">&nbsp;</td>
        <td width="29%">&nbsp;</td>
      </tr>
    </table></td>
    <td width="23%" height="100"><table width="149" id="privateorgtb">
      <tr bgcolor="#0099CC">
        <td colspan="4" bgcolor="#CCCCCC">Private Sector Organizations</td>
      </tr>
      <tr>
        <td width="18%">&nbsp;</td>
        <td width="25%">&nbsp;</td>
        <td width="28%">&nbsp;</td>
        <td width="29%">&nbsp;</td>
      </tr>
    </table></td>
    <td width="25%" height="100"><table width="279" border="0" id="subscribetb">
      <tr>
        <td colspan="2" class="cationinfo">Get SMS &amp; Email Free Job Alerts</td>
      </tr>
      <tr>
        <td><img name="" src="images/emailicon.jpg" width="32" height="31" alt="" /></td>
        <td><label for="textfield"></label>
          <input type="text" name="txt_email" id="txt_email" /></td>
      </tr>
      <tr>
        <td width="33" height="31"><img name="" src="images/phoneicon.jpg" width="32" height="27" alt="" /></td>
        <td width="203"><label for="textfield"></label>
          <input type="text" name="txt_mobile" id="txt_mobile" />
          <br />
          <input type="checkbox" name="checkbox" id="checkbox" />
          I have read and agree the Terms and Conditions governed by Jobsbysms.com</td>
      </tr>
      <tr>
        <td height="31" colspan="2"><label for="checkbox"></label>          <input type="submit" name="btn_submit" id="btn_submit" value="Subscribe" /></td>
        </tr>
    </table></td>
  </tr>
  <tr>
    <td height="63"><iframe src="http://www.facebook.com/plugins/like.php?href=http%3A%2F%2Fwww.jobsbysms.com&amp;layout=standard&amp;show_faces=true&amp;width=450&amp;action=like&amp;colorscheme=light&amp;height=80" scrolling="no" frameborder="0" style="border:none; overflow:hidden; width:100%; height:80px;" allowtransparency="true"></iframe></td>
    <td height="63">&nbsp;</td>
    <td height="63">&nbsp;</td>
    <td height="63">&nbsp;</td>
  </tr>
  <tr class="footer">
    <td height="75" >&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr class="footer">
    <td >&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
    </table>
</table>
    
  
     <br/>
     <div id="pvtjobs"></div>
    
</body>
</html>
