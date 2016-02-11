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
                <p>Ships remaining:</p>
            </div>


        </div>
    </div>

    <div class="main container">
        <div id="board" class="ui seven column padded grid">

            <c:forEach items="${game.cells}" var="cell">
	          <a href="?playcol=${cell}" class="blue column"> ${cell}
	          	
	          </a>
          </c:forEach>
        </div>


        <!--<a href="?reset" class="ui red button" id="reset">Reset game</a>-->

    </div>




</body>
</html>