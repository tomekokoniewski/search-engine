<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>search engine [aadd-user-step-2.jsp]</title>
</head>
<body>

<%@ include file="go-back.jsp" %>

<h1>Add new user via few-steps formula</h1>

<c:if test="${errorMessage != null}">
    <div style="color: red;">${errorMessage}</div>
</c:if>
<c:if test="${okMessage != null}">
    <div style="color: green;">${okMessage}</div>
</c:if>


<form method="post" action="/add-user-steps">
    <input type="hidden" name="step" value="3"/>

    <label>Gender:</label>
    <select name="gender">
        <option value="">&lt;select&gt;</option>
        <option value="MAN">MAN</option>
        <option value="WOMAN">WOMAN</option>
    </select>

    <input type="submit" name="add-user" value="next"/>
</form>

</body>
</html>
