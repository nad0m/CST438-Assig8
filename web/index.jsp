<%-- 
    Author     : huy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hangman Game</title>
    </head>
    <body>
        <h2 style="font-family:Lucida Console, monospace">Welcome</h2>
        <img src= h1.gif>
        <form action="WordsServlet" method="get"> 
            <h2 style="font-family:Lucida Console, monospace">Try to guess a random word!</h2>
            <br><input type="submit" value = "Play!">
        </form>
    </body>
</html>
