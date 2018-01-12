<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>search engine [add-user.jsp]</title>
</head>
<body>

<%@ include file="go-back.jsp" %>

<h1>Add new user via one-step formula</h1>

<form method="post" action="/AddUserServlet">
    <table>
        <tr>
            <td><label>ID:</label></td> <td><input name="id" type="text"/> </td>
        </tr>
        <tr>
            <td><label>Name:</label></td> <td><input name="name" type="text"/></td>
        </tr>
        <tr>
            <td><label>Surname:</label></td> <td><input name="surname" type="text"/></td>
        </tr>
        <tr>
            <td><label>Login:</label></td> <td><input name="login" type="text"/></td>
        </tr>
        <tr>
            <td><label>Age:</label></td> <td><input name="age" type="text"/></td>
        </tr>
        <tr>
            <td><label>Gender:</label></td>
            <td><select name="gender">
                <option value="">&lt;select&gt;</option>
                <option value="MAN">MAN</option>
                <option value="WOMAN">WOMAN</option>
            </select></td>
        </tr>
        <tr>
            <td><input type="submit" name="add-user" value="add-user"/></td>
        </tr>
    </table>
</form>

</body>
</html>
