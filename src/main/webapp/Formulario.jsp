<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <%
        String acao = request.getParameter("acao");

        String id = request.getParameter("id");
        String nome = request.getParameter("nome");
        String produto = request.getParameter("produto");      
        String endereco = request.getParameter("endereco");
        String telefone = request.getParameter("telefone");
        String pesquisa = request.getParameter("pesquisa");


        if (id == null) {
            nome = "";
            produto = "";
            endereco = "";
            telefone = "";
        }
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro de entrega</title>
    </head>
    <style>
        input {
            background-color: darkgray;
            color:black;   
        }
        
        .btn {
            width: 100px;
            height: 30px;
        }
        
        tbody {
            color:black;
            background-color: gainsboro;
        }
        
        table {
            color: black;
            width: 500px;
            height: 300px;   
        }
        
        body {
            background-color: darkgray;
        }
        .telaPrincipal{
            color: black;
        }
    </style>
    <div>
        <body>
            
        <center>
            <br><!-- comment -->
            <br>
            <tr>
            <h3><th>Registrar Entrega</th></h3>
            </tr>
            <br>
            <br>
            <form action="RegistroSrv" method="POST">
                <input type="hidden" name="acao" value="<%=acao%>" />
                <table border="1">
                    <tbody>
                        <tr>
                            <td></td>
                            <td><input type="hidden" name="id" value="<%=id%>" /></td>
                        </tr>
                        <tr>
                            <th>Cliente: </th>
                            <th><input type="text" name="nome" value="<%=nome%>" /></th>
                        </tr>
                        <tr>
                            <th>Produto: </th>
                            <th><input type="text" name="produto" value="<%=produto%>" /></th>
                        </tr>

                        <tr>
                            <th>Endereço: </th>
                            <th><input type="text" name="endereco" value="<%=endereco%>" /></th>
                        </tr>
                        <tr>
                            <th>Telefone: </th>
                            <th><input type="text" name="telefone" value="<%=telefone%>" /></th>
                        </tr>
                        <tr>
                            <td></td>
                            <td></td>
                        </tr>
                    </tbody>
                </table>
                <br>
                <th><input class="btn" type="submit" value="Enviar" /></th>
                <th><input class="btn" type="reset" value="Limpar" /></th>
                <br/>
                <th><a class="telaPrincipal" href="index.html">Tela Principal</a></th>
            </form>

        </center>
    </body>
</div>
</html>
