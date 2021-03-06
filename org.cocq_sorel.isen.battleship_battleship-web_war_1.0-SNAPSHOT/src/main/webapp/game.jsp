<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
   <link rel="stylesheet" href="${pageContext.request.contextPath}/css/semantic.min.css" />
   <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
</head>

<body id="example" class="site">
    <div class="ui fixed inverted main menu">
        <div class="container">
            <a class="launch item"><i class="content icon"></i></a>
            <div class="title item">
                <b>Battleship</b>
            </div>
        </div>
    </div>


   <div id="header" class="header segment">
        <div class="container">
            <h2 class="ui dividing header">Battleship</h2>
            <div class="introduction">
                <p>By Aurelien Cocq & Martin Sorel</p>
                <p>Turns remaining: ${game.nbTurnLeft}</p>
                <c:if test="${game.hasWon() == 0}">
                    <div id="winner" class="ui label">YOU WIN !</div>
                </c:if>
                <c:if test="${game.hasWon() == 1}">
                    <div id="winner" class="ui label">YOU LOSE !</div>
                </c:if>   
            </div>


        </div>
    </div>

    <div class="main container">
        <div id="board" class="ui ten column grid">

            <c:forEach var="i" begin="0" end="${game.rowsNumber - 1}">
                <div class="column">
                    <c:forEach var="j" begin="0" end="${game.collumnsNumber - 1}">                        
                        <a href="?row=${i}&col=${j}" class="battleRow massive ${game.getStateColor(game.getCellStatus(i, j))} square ui icon button"></a>                        
                    </c:forEach>
                </div>
          </c:forEach>
        </div>


        <a href="?reset" class="ui red button" id="reset">Reset game</a>

    </div>




</body>
</html>