<%-- 
    Document   : menuCliente
    Created on : Oct 25, 2020, 10:55:27 AM
    Author     : Kaua.Morateli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="recol">
    <ul class="side-menu">
        <center><br>
            <a href="listarCompras" class="link-menu">Pedidos</a><br>
            <center>_______________</center><br>
            <a href="listarAssinatura">Minha Assinatura</a><br>
            <center>_______________</center><br>
            <a class="link-menu">Minha Conta</a><br>
            <center>_______________</center><br>
            <a class="link-menu">Atendimento</a><br>
            <center>_______________</center><br>
            <a href="#" data-toggle="modal" data-target="#modal-logout" class="link-menu">Sair</a><br><br>
        </center>
    </ul>
</div>


        <div class="modal fade" id="modal-logout" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h3 class="modal-title">Sair</h3>
                </div>
                <form method="post" action="#">
                    <div class="modal-body">
                        <div class="checkbox">
                            <label>
                                Tem certeza que deseja Sair? :(
                            </label>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <a href="ControleAcessoCliente?acao=Sair" type="submit" class="btn btn-primary"><i class="fa fa-sign-out" aria-hidden="true"></i> Sim</a><button type="button" class="btn btn-primary" data-dismiss="modal">Cancelar</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
