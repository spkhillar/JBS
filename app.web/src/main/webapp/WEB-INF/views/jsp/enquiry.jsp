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
<style>    
* { margin: 0; padding: 0; }

html { height: 100%; font-size: 62.5% }

body { height: 100%; background-color: #FFFFFF; font: 1.2em Verdana, Arial, Helvetica, sans-serif; }


/* ==================== Form style sheet ==================== */

form.enq { margin: 25px 0 0 29px; width: 450px; padding-bottom: 30px; }

fieldset { margin: 0 0 22px 0; border: 1px solid #095D92; padding: 12px 17px; background-color: #DFF3FF; }
legend { font-size: 1.1em; background-color: #095D92; color: #FFFFFF; font-weight: bold; padding: 4px 8px; }

label.float { float: left; display: block; width: 100px; margin: 4px 0 0 0; clear: left; }

label.spam-protection { display: inline; width: auto; margin: 0; }

input.inp-text, textarea, input.choose, input.answer { border: 1px solid #909090; padding: 3px; }
input.inp-text { width: 300px; margin: 0 0 8px 0; }
textarea { width: 400px; height: 150px; margin: 0 0 12px 0; display: block; }

input.choose { margin: 0 2px 0 0; }
input.answer { width: 40px; margin: 0 0 0 10px; }
input.submit-button { font: 1.4em Georgia, "Times New Roman", Times, serif; letter-spacing: 1px; display: block; margin: 23px 0 0 0; }



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

label.spam-protection { display: inline; width: auto; position: relative; top: -3px; }
input.choose { border: 0; margin: 0; }
input.submit-button { margin: -10px 0 0 0; }

/* ==================== Form style sheet for IE end ==================== */

</style>


</head>

<body>
<table border="0" id="enquirytable">
  <tr>
   <td colspan="6"> 
   <table width="98%" id="jobtb">
     <tr bgcolor="#FFFFFF">
       <td width="52%" height="154" class="joblist"><form class="enq"action="" method="post">
         <!-- ============================== Fieldset 1 ============================== -->
         <fieldset>
           <legend>Contact Information</legend>
           <label for="input-one" class="float"><strong>Name:</strong></label>
           <br />
           <input class="inp-text" name="input-one-name" id="input-one" type="text" size="30" /><br />
           
           <label for="input-two" class="float"><strong>Email Id</strong></label>
           <br />
           <input class="inp-text" name="input-two-name"  id="input-two" type="text" size="30" />
           
           <label for="input-two" class="float"><strong>Subject</strong></label>
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
       </tr>
      </table>
    </td>
    </tr>
  </table>  
</body>
</html>
