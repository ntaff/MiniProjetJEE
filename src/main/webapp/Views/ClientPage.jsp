<%-- 
    Document   : ClientPage
    Created on : 21 nov. 2018, 16:26:53
    Author     : Taffoureau
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Panel du client</title>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <link rel="stylesheet" type="text/css" href="../Css/ClientPage.css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <h4>Coordonnées | <button class="btn btn-primary btn-xs" data-title="Modifier" data-toggle="modal" data-target="#modifierInfos" ><span class="glyphicon glyphicon-pencil"></span></button></h4>
                    <div class="table-responsive">
                        <table id="coord" class="table table-striped">
                            <thead>
                                <th>Nom</th>
                                <th>Adresse</th>
                                <th>Téléphone</th>
                                <th>E-mail</th>
                                <th>Zone Géographique</th>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>Georges II</td>
                                    <td>42 rue de Paris</td>
                                    <td>0770458574</td>
                                    <td>georges2@gmail.com</td>
                                    <td>CO</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <h4>Bons de commande | <button class="btn btn-primary btn-xs" data-title="Ajout" data-toggle="modal" data-target="#ajoutBon" ><span class="glyphicon glyphicon-plus"></span></button> | <button class="btn btn-primary btn-xs" data-title="Modifier" data-toggle="modal" data-target="#modifier" ><span class="glyphicon glyphicon-pencil"></span></button> | <button class="btn btn-danger btn-xs" data-title="Supprimer" data-toggle="modal" data-target="#supprimer" ><span class="glyphicon glyphicon-trash"></span></button>    </h4>
                    <div class="table-responsive">
                        <table id="bons" class="table table-bordred table-striped">
                            <thead>
                                <th>Nom du produit</th>
                                <th>Quantité</th>
                                <th>Prix unitaire</th>
                                <th>Fournisseur</th>

                            </thead>
                            <tbody>
                            <c:forEach var="prod" items="${produitsclient}">
                                <tr>
                                    <td>Trombones</td>
                                    <td>12</td>
                                    <td>45£</td>
                                    <td>La Poste</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        
        <!-- Modal de modification d'un bon -->
        <div class="modal fade" id="modifier" tabindex="-1" role="dialog" aria-labelledby="modifier" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button>
                        <h4 class="modal-title custom_align" id="Heading">Modifier votre bon</h4>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                          <label for="bon">Bon</label>
                          <select id="selectbon"class="form-control" name="bon">
                           <c:forEach var="bon" items="${bon}">
                            <option value="0" >${bon.id}</option>
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

        <!-- Modal de modification des informations du client -->
        <div class="modal fade" id="modifierInfos" tabindex="-1" role="dialog" aria-labelledby="modifierInfos" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button>
                        <h4 class="modal-title custom_align" id="Heading">Modifier vos coordonnées</h4>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <input class="form-control " type="text" placeholder="Zone Géographique">
                        </div>
                        <div class="form-group">
                            <input class="form-control " type="text" placeholder="Adresse">
                        </div>
                        <div class="form-group">
                            <input class="form-control" placeholder="Numéro de téléphone">
                        </div>
                        <div class="form-group">
                            <input class="form-control" placeholder="Mail">
                        </div>
                    </div>
                        <div class="modal-footer ">
                            <button type="button" class="btn btn-warning btn-lg" style="width: 100%;"><span class="glyphicon glyphicon-ok-sign"></span> Modifier</button>
                        </div>
                </div>
            </div>
        </div>
        
        <!-- Modal de suppression d'un bon -->
        <div class="modal fade" id="supprimer" tabindex="-1" role="dialog" aria-labelledby="supprimer" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button>
                        <h4 class="modal-title custom_align" id="Heading">Supprimer un bon</h4>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label for="nomproduit">Nom du bon</label>
                            <select id="nomproduit"class="form-control" name="nomproduit">
                            <c:forEach var="bon" items="${bon}">
                            <option value="0" >${bon.id}</option>
                            </c:forEach>
                            </select>
                        </div>
                        <div class="alert alert-danger"><span class="glyphicon glyphicon-warning-sign"></span> Etes vous sûr de vouloir supprimer ce bon, définitivement, pour toujours et à jamais ?</div>
                    </div>
                    <div class="modal-footer ">
                        <button type="button" class="btn btn-success" ><span class="glyphicon glyphicon-ok-sign"></span> Oui</button>
                        <button type="button" class="btn btn-warning" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Non</button>
                    </div>
                </div>
            </div>
        </div>
        
        <!-- Modal d'ajout d'un bon -->
        <div class="modal fade" id="ajoutBon" tabindex="-1" role="dialog" aria-labelledby="ajoutBon" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button>
                        <h4 class="modal-title custom_align" id="Heading">Ajouter un bon</h4>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label for="nomproduit">Nom du produit</label>
                            <select id="selectnomproduit"class="form-control" name="nomproduit">
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
