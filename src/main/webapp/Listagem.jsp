
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        String listaHTML = request.getParameter("lista");

        String acao = request.getParameter("acao");

        String pesquisa = request.getParameter("pesquisa");
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Histórico de Registros</title>

    </head>
    <style>
        input{
            background-color: darkgrey;
            color:black;
        }
        body{
            background-color: darkgrey;
            color:black;
        }
        header {
            background-color:black;
            color:background;
        }
        thead{
            color:black;
            background-color: gainsboro;
        }
        tbody {
            background-color: gainsboro;
            width: 50px;
            height: 50px;
        }
        .bt1 {
            background-color: gainsboro;
        }
        .telaPrincipal{
            color: black;
        }
    </style>
    <body>
        <br><!-- comment -->
        <br>
        <br>
    <center>
        <table border="1">
            <thead>
                <tr><!-- comment -->
                    <th>Cliente</th>
                    <th>Produto</th>
                    <th>Endereco</th><!-- <th>Nome</th> -->
                    <th>Telefone</th>
               
                    <th></th>
                    <th></th>
                    <!-- comment -->
                </tr>
            </thead>
            <tbody>
                <%=listaHTML%>
            </tbody>
        </table>
        <form action="RegistroSrv" method="POST">
            <input type="hidden" name="acao" value="<%=acao%>" />
            <br>
            <a><input class="bt1" type="text" name="Pesquisar" value="<%=pesquisa%>"/></a>
            <input type="submit" value="Pesquisar" onclick="pesquisar();" />
            <br>
        </form>
        <br>
        <a class="telaPrincipal" href="index.html">Tela Principal</a>
    </center>
</body>
</html>
