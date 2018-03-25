<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu Principal</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" 
              integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" 
              crossorigin="anonymous">
    </head>
    <body>
        <div class="jumbotron">
            <div class="container">
                <h1>Menu Principal</h1>
            </div>
        </div>
        
        <div class="row">
            <div class="col-12 col-lg-2">
                <ul class="list-group">
                    <li class="list-group-item active">Menu Opções</li>                    
                    <a href="${pageContext.request.contextPath}/cadastrar_produtos" class="list-group-item list-group-item-action">Cadastrar novo produto</a>
                    <a href="${pageContext.request.contextPath}/listar_produtos" class="list-group-item list-group-item-action">Listar produtos cadastrados</a>
                </ul>
            </div>
            <div class="col-12 col-lg-8">
                <div class="row">
                    <c:if test="${not empty msgErro}">
                        <h2><c:out value="${msgErro}" /></h2>
                    </c:if>

                    <c:if test="${not empty produtos}">
                        <c:forEach items="${produtos}" var="produto">
                            <div class="col-12 col-sm-3">
                                <div class="card border-primary mb-3">
                                    <div class="card-header bg-transparent border-primary mb-3"><c:out value="${produto.nome}" /></div>
                                    <div class="card-body">
                                        <p class="card-text">Categoria: <c:out value="${produto.categoria}" /></p>
                                        <p class="card-text">Descrição: <c:out value="${produto.descricao}" /></p>
                                        <p class="card-text h4"><fmt:formatNumber type="currency" value = "${produto.preco_venda}" /></p>
                                    </div>
                                    <div class="card-footer bg-transparent border-primary mb-3">
                                        <form action="${pageContext.request.contextPath}/produto_exibir" method="post">
                                            <input type="hidden" name="id" value="<c:out value="${produto.id}" />">

                                            <button type="submit" class="btn btn-primary mb-2">Detalhes</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </c:if>
                </div>
            </div>
            <div class="col-12 col-lg-2">

            </div>
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
