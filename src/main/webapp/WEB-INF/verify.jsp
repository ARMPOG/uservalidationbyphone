<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="css/verify.css" rel="stylesheet">
</head>
<body>

<spring:form action="verify" modelAttribute="verifiedUser" method="post">
<div id="wrapper">
    <div id="dialog">
<%--        <button class="close">×</button>--%>
        <h3>Please enter the 4-digit verification code we sent via SMS:</h3>
        <span>(we want to make sure it's you before we contact our movers)</span>
        <div id="form">
            <div class="input-container">
                <spring:input path="verifyCode" id="verifyCode" type="number" name="verifyCode"
                              class="input" minlength="5" maxlength="5" required="required"/>
                <spring:input path="phone" cssStyle="visibility: hidden"></spring:input>
            </div>
<%--            <div class="group">--%>
<%--                <input type="submit" class="button" value="Sign Up">--%>
<%--            </div>--%>
<%--            <c:if test="errorMessage">--%>
                <p style="color: red">${errorMessage}</p>
<%--            </c:if>--%>
                <button class="btn btn-primary btn-embossed verify">Verify</button>
        </div>
        </spring:form>

        <div>
            Didn't receive the code?<br/>
            <a href="#">Send code again</a><br/>
            <a href="#">Change phone number</a>
        </div>
        <img src="http://jira.moovooz.com/secure/attachment/10424/VmVyaWZpY2F0aW9uLnN2Zw==" alt="test"/>
    </div>
</div>
</body>
</html>
