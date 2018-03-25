<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Produtos</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" 
              integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" 
              crossorigin="anonymous">
    </head>
    <body>
        <div class="jumbotron">
            <div class="container">
                <h1>Cadastrar Produtos</h1>                
            </div>
        </div>

        <div class="container">
            <form class="form-horizontal" action="${pageContext.request.contextPath}/produto_cadastrar" method="post">

                <div class="form-group">
                    <label for="nome">Nome:</label>
                    <input type="text" name="nome" class="form-control" id="nome" required>                    
                </div>

                <div class="form-group">
                    <label for="descricao">Descrição:</label>
                    <textarea name="descricao" class="form-control" id="descricao" rows="3" required></textarea>
                </div>

                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="preco_compra">Valor de Compra:</label>
                        <input type="text" name="preco_compra" class="form-control" id="preco_compra" required>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="preco_venda">Valor de Venda:</label>
                        <input type="text" name="preco_venda" class="form-control" id="preco_venda" required>
                    </div>
                </div>

                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="quantidade">Quantidade:</label>
                        <input type="text" name="quantidade" class="form-control" id="quantidade" required>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="quantidade">Categorias:</label>
                        <br>
                        <c:forEach items="${categorias}" var="cat">
                            <div class="custom-control custom-radio custom-control-inline">
                                <input type="radio" id="<c:out value="${cat.id}" />" name="categoria" class="custom-control-input">
                                <label class="custom-control-label" for="<c:out value="${cat.id}" />"><c:out value="${cat.nome}" /></label>
                            </div>
                        </c:forEach>
                    </div>
                </div>

                <hr>

                <div class="btn-group" role="group" aria-label="Basic example">
                    <button type="submit" class="btn btn-primary">Salvar</button>
                    <button type="reset" class="btn btn-primary">Limpar</button>
                    <a class="btn btn-primary" href="${pageContext.request.contextPath}/menu_principal">Cancelar</a>
                </div>


            </form>
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
