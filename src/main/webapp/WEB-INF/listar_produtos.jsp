<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Produtos</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" 
              integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" 
              crossorigin="anonymous">
    </head>
    <body>
        <div class="jumbotron">
            <div class="container">
                <h1>Listar Produtos</h1>
            </div>
        </div>

        <div class="container">
            <c:if test="${not empty msgErro}">
                <h2><c:out value="${msgErro}" /></h2>
            </c:if>

            <c:if test="${not empty produtos}">
                <div class="table-responsive">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>#</th>
                                <th>Nome</th>
                                <th>Categoria</th>
                                <th>Preço de Compra</th>
                                <th>Preço de Venda</th>
                                <th>Quantidade</th>
                                <th>Cadastrado</th>
                            </tr>
                        </thead>

                        <tbody>                                
                            <c:forEach items="${produtos}" var="produto">                                
                                <tr>
                                    <td><c:out value="${produto.id}" /></td>
                                    <td><c:out value="${produto.nome}" /></td>
                                    <td><c:out value="${produto.categoria}" /></td>
                                    <td><fmt:formatNumber type="currency" value = "${produto.preco_compra}" /></td>
                                    <td><fmt:formatNumber type="currency" value = "${produto.preco_venda}" /></td>
                                    <td><c:out value="${produto.quantidade}" /></td>
                                    <td><fmt:formatDate pattern = "dd/MM/yyyy HH:mm:ss" value = "${produto.dt_cadastro}" /></td>
                                    <td>
                                        <form action="${pageContext.request.contextPath}/produto_exibir" method="post">
                                            <input type="hidden" name="id" value="<c:out value="${produto.id}" />">

                                            <button class="btn btn-xs btn-primary" type="submit"></button>
                                        </form>                                                                                               
                                    </td>
                                    <td>
                                        <form action="${pageContext.request.contextPath}/produto_alterar" method="post">
                                            <input type="hidden" name="id" value="<c:out value="${produto.id}" />">

                                            <button class="btn btn-xs btn-warning" type="submit"></button>
                                        </form>                                                                                               
                                    </td>
                                    <td>
                                        <form action="${pageContext.request.contextPath}/produto_excluir" method="post">                                            
                                            <input type="hidden" name="id" value="<c:out value="${produto.id}" />">                                                    

                                            <button class="btn btn-xs btn-danger" type="submit"></button>
                                        </form>
                                    </td> 
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </c:if>            
        </div>
        
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" 
                integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" 
                crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" 
                integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" 
                crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" 
                integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" 
                crossorigin="anonymous"></script>
    </body>
</html>
