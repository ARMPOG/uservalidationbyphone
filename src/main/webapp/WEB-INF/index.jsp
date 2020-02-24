<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %><html>
<head>
    <title>Login</title>
    <link href="css/index.css" rel="stylesheet">
<%--    <spring:url value="/resources/index.css" var="css"/>--%>
<%--    <link href="${css}" rel="stylesheet"/>--%>

</head>
<body>

<div class="login-wrap">
    <%--    <%=pageContext.getRequest().getServletContext().getContextPath()%>--%>
    <div class="login-html">
        <input id="tab-1" type="radio" name="tab" class="sign-in" checked><label for="tab-1" class="tab">Sign In</label>
        <input id="tab-2" type="radio" name="tab" class="sign-up"><label for="tab-2" class="tab">Sign Up</label>
        <div class="login-form">
            <div class="sign-in-htm">
                <form action="/login" method="post">
                    <div class="group">

                        <label for="phone" class="label">Phone</label>
                        <input id="phonee" type="text" name="phone" class="input">
                    </div>
                    <div class="group">
                        <label for="pass" class="label">Password</label>
                        <input id="passs" type="password" name="password" class="input" data-type="password">
                    </div>
                    <div class="group">
                        <input id="check" type="checkbox" class="check" checked>
                        <label for="check"><span class="icon"></span> Keep me Signed in</label>
                    </div>
                    <div class="group">
                        <input type="submit" class="button" value="Sign In">
                    </div>

                    <c:if test="${login_errorMessage!=null}">
                    <div class="group">
                        <% String message = (String) request.getAttribute("login_errorMessage"); %>
                        <p style="color: red"><%=message%>
                        </p>
                    </div>
                    </c:if>
                    <div class="hr"></div>
                    <div class="foot-lnk">
                        <a href="#forgot">Forgot Password?</a>
                    </div>
            </div>
            </form>


            <div class="sign-up-htm">
                <spring:form action="register" modelAttribute="registeredUser" method="post">
                    <div class="group">
                        <label for="name" class="label">Name</label>
                        <spring:input path="name" id="name" type="text" name="name" class="input"/>
                    </div>
                    <div class="group">
                        <label for="surn" class="label">Surname</label>
                        <spring:input path="surname" id="surn" type="text" name="surname" class="input"
                                       data-type="input"/>
                    </div>
                    <div class="group">
                        <label for="phone" class="label">Phone</label>
                        <spring:input path="phone" id="phone" type="text" name="phone" class="input"/>
                    </div>
                    <div class="group">
                        <label for="pass" class="label">Password</label>
                        <spring:input path="password" id="pass" type="password" name="password" class="input"
                                       data-type="password"/>
                    </div>
                    <div class="group">
                        <input type="submit" class="button" value="Sign Up">
                    </div>
                </spring:form>
                <div class="hr"></div>
                <div class="foot-lnk">
                    <label for="tab-1">Already Member?</label>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
