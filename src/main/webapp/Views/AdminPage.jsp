<%-- 
    Document   : AdminPage
    Created on : 21 nov. 2018, 16:26:43
    Author     : Taffoureau
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
     <title>Panel administrateur</title>
  <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
  <script type="text/javascript" src="Js/bar_chart.js"> </script>
  <script type="text/javascript" src="Js/geo_chart.js"> </script>
  <script type="text/javascript" src="Js/client_chart.js"> </script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <link rel="stylesheet" type="text/css" href="Css/AdminPage.css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
 </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <h4>Articles | <button class="btn btn-primary btn-xs" data-title="Ajout" data-toggle="modal" data-target="#ajoutBon" ><span class="glyphicon glyphicon-plus"></span></button> | <button class="btn btn-primary btn-xs" data-title="Modifier" data-toggle="modal" data-target="#modifier" ><span class="glyphicon glyphicon-pencil"></span></button> | <button class="btn btn-danger btn-xs" data-title="Supprimer" data-toggle="modal" data-target="#supprimer" ><span class="glyphicon glyphicon-trash"></span></button></h4>
                    <div class="table-responsive">
                        <table id="bons" class="table table-bordred table-striped">
                            <thead>
                                <th>Nom du produit</th>
                                <th>Quantité</th>
                                <th>Prix unitaire</th>
                                <th>Fournisseur</th>
                            </thead>
                            <tbody>
                            <c:forEach var="prod" items="${produitsadmin}">
                                <tr>
                                    <td>${prod.id}</td>
                                    <td>${prod.quantite}</td>
                                    <td>${prod.prix}</td>
                                    <td>${prod.fournisseur}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>      
                    <hr>
                    <div id="chart" style="width: 900px; height: 500px;"></div>
                    <hr>
                    <p>Chiffre d'affaire par zone géographique</p>
                    <div id="geochart" style="width: 900px; height: 500px;"></div>
                    <hr>
                    <div id="client_chart" style="width: 900px; height: 500px;"></div>
                    <hr>
                </div>
            </div>
        </div>
        
        
        <!-- Modal de modification d'un article -->
        <div class="modal fade" id="modifier" tabindex="-1" role="dialog" aria-labelledby="modifier" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button>
                        <h4 class="modal-title custom_align" id="Heading">Modifier l'article</h4>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label for="nomproduit">Nom du produit</label>
                            <select id="nomproduit"class="form-control" name="nomproduit">
                            <c:forEach var="prod" items="${produit}">
                            <option value="0" >${prod.id}</option>
                            </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <input class="form-control " type="text" placeholder="Quantité">
                        </div>
                        <div class="control-group">
                          <label for="fournisseur">Fournisseur</label>
                          <select id="selectfournisseur"class="form-control" name="fournisseur">
                           <c:forEach var="four" items="${fournisseur}">
                            <option value="0" >${four.noms}</option>
                            </c:forEach>
                          </select>
                        </div>
                    </div>
                        <div class="modal-footer ">
                            <button type="button" class="btn btn-warning btn-lg" style="width: 100%;"><span class="glyphicon glyphicon-ok-sign"></span> Modifier</button>
                        </div>
                </div>
            </div>
        </div>
        
        <!-- Modal de suppression d'un article -->
        <div class="modal fade" id="supprimer" tabindex="-1" role="dialog" aria-labelledby="supprimer" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button>
                        <h4 class="modal-title custom_align" id="Heading">Supprimer un article</h4>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label for="nomproduit">Nom du produit</label>
                            <select id="nomproduit"class="form-control" name="nomproduit">
                            <c:forEach var="prod" items="${produit}">
                            <option value="0" >${prod.id}</option>
                            </c:forEach>
                            </select>
                        </div>
                        <div class="alert alert-danger"><span class="glyphicon glyphicon-warning-sign"></span> Etes vous sûr de vouloir supprimer cet article, définitivement, pour toujours et à jamais ?</div>
                    </div>
                    <div class="modal-footer ">
                        <button type="button" class="btn btn-success" ><span class="glyphicon glyphicon-ok-sign"></span> Oui</button>
                        <button type="button" class="btn btn-warning" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Non</button>
                    </div>
                </div>
            </div>
        </div>
        
        <!-- Modal d'ajout d'un produit -->
        <div class="modal fade" id="ajoutBon" tabindex="-1" role="dialog" aria-labelledby="ajoutBon" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button>
                        <h4 class="modal-title custom_align" id="Heading">Ajouter un produit</h4>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label for="nomproduit">Nom du produit</label>
                            <select id="nomproduit"class="form-control" name="nomproduit">
                           <c:forEach var="prod" items="${produit}">
                            <option value="0" >${prod.id}</option>
                            </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <input class="form-control " type="text" placeholder="Quantité">
                        </div>
                        <div class="control-group">
                          <label for="fournisseur">Fournisseur</label>
                          <select id="selectfournisseur"class="form-control" name="fournisseur">
                           <c:forEach var="four" items="${fournisseur}">
                            <option value="0" >${four.noms}</option>
                            </c:forEach>
                          </select>
                        </div>
                    </div>
                        <div class="modal-footer ">
                            <button type="button" class="btn btn-warning btn-lg" style="width: 100%;"><span class="glyphicon glyphicon-ok-sign"></span> Ajouter</button>
                        </div>
                </div>
            </div>
        </div>
    </body>
</html>