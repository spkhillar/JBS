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


/* ==================== Form style sheet ==================== */

form { margin: 25px 0 0 29px; width: 450px; padding-bottom: 30px; }

fieldset { margin: 0 0 22px 0; border: 1px solid #095D92; padding: 12px 17px; background-color: #DFF3FF; }
legend { font-size: 1.1em; background-color: #095D92; color: #FFFFFF; font-weight: bold; padding: 4px 8px; }

label.float { float: left; display: block; width: 100px; margin: 4px 0 0 0; clear: left; }
label { display: block; width: auto; margin: 0 0 10px 0; }
label.spam-protection { display: inline; width: auto; margin: 0; }

input.inp-text, textarea, input.choose, input.answer { border: 1px solid #909090; padding: 3px; }
input.inp-text { width: 300px; margin: 0 0 8px 0; }
textarea { width: 400px; height: 150px; margin: 0 0 12px 0; display: block; }

input.choose { margin: 0 2px 0 0; }
input.answer { width: 40px; margin: 0 0 0 10px; }
input.submit-button { font: 1.4em Georgia, "Times New Roman", Times, serif; letter-spacing: 1px; display: block; margin: 23px 0 0 0; }

form br { display: none; }

/* ==================== Form style sheet END ==================== */

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
<table height="134" border="0" id="indextb">
  <tr>
    <td height="30"><img src="../../resources/images/JBS_LOGO.png" id="logo"></img></td>
    <td height="30">&nbsp;</td>
    <td height="30">&nbsp;</td>
    <td height="30">&nbsp;</td>
    <td height="30" class="cationinfo"><a href="#logintb">Login</a> | New User? <a href="../register">Click to Register</a></td>
    <td height="30" class="cationinfo"><a href="#">Privacy Policy</a></td>
  </tr>
  <tr>
    <td height="96" colspan="6" class="menutd"><div class="wrap" align="center">
    
    <nav>
      <ul class="menu">
        <li>
          <a class="fNiv" href="/nitin_swadhin/">Home</a>
          </li>
        
        <li>
          <a class="fNiv" href="../../register/">Register</a>
          </li>
        
        <li>
          <a class="fNiv" href="../login">Login</a>
          </li>
        
        <li>
          <a class="fNiv" id="paymentlink" href="enquiry">Enquiry</a> </li>
        
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
                      <img src="../../resources/images/job5.jpg" title="Newsflash 9" width="" >            
                     </li> 
                     <li>
                      <img src="../../resources/images/job4.jpg" title="Newsflash 10" >            
                     </li> 
                     <li>
                      <img src="../../resources/images/job2.jpg" title="Newsflash 11" >            
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
     <tr bgcolor="#FFFFFF">
       <td width="52%" height="154" class="joblist"><form action="" method="post">
		<!-- ============================== Fieldset 1 ============================== -->
		<fieldset>
			<legend>Contact Information</legend>
				<label for="input-one" class="float"><strong>Name:</strong></label>
				<br />
				<input class="inp-text" name="input-one-name" id="input-one" type="text" size="30" /><br />

				<label for="input-two" class="float"><strong>Email Id</strong></label>
				<br />
				<input class="inp-text" name="input-two-name"  id="input-two" type="text" size="30" />
		</fieldset>
		<!-- ============================== Fieldset 1 end ============================== -->


		

		<!-- ============================== Fieldset 3 ============================== -->
		<fieldset>
			<legend>Message:</legend>
			<textarea name="textarea-name" id="message" cols="30" rows="5" title="Note or message"></textarea><br />
		</fieldset>
		<!-- ============================== Fieldset 3 end ============================== -->

		<p><input class="submit-button" type="submit" alt="SUBMIT" name="Submit" value="SUBMIT" /></p>
	</form>

</td>
       <td width="41%" class="joblist">&nbsp;</td>
       <td width="7%"  class="joblist">&nbsp;</td>
       </tr>
      </table>
</table>
    
  
     <br/>
     <div id="pvtjobs"></div>
    
</body>
</html>
