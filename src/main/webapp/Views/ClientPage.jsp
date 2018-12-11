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
        <link rel="stylesheet" type="text/css" href="Css/ClientPage.css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <h4>Coordonnées</h4>
                    <div class="table-responsive">
                        <table id="coord" class="table table-striped">
                            <thead>
                                <th>Prénom</th>
                                <th>Nom</th>
                                <th>Date de naissance</th>
                                <th>Adresse</th>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>Jean</td>
                                    <td>Bon</td>
                                    <td>17/02/1998</td>
                                    <td>74 rue de Paris, 91120, Palaiseau</td>
                                    <td><p data-placement="top" data-toggle="tooltip" title="Modifier"><button class="btn btn-primary btn-xs" data-title="Modifier" data-toggle="modal" data-target="#modifierInfos" ><span class="glyphicon glyphicon-pencil"></span></button></p></td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <h4>Bons de commande | <button class="btn btn-primary btn-xs" data-title="Ajout" data-toggle="modal" data-target="#ajoutBon" ><span class="glyphicon glyphicon-plus"></span></button>      </h4>
                    <div class="table-responsive">
                        <table id="bons" class="table table-bordred table-striped">
                            <thead>
                                <th>Nom du produit</th>
                                <th>Quantité</th>
                                <th>Prix unitaire</th>
                                <th>Fournisseur</th>
                                <th>Modifier</th>
                                <th>Supprimer</th>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>Exemple</td>
                                    <td>5</td>
                                    <td>10€</td>
                                    <td>Colissimo</td>
                                    <td><p data-placement="top" data-toggle="tooltip" title="Modifier"><button class="btn btn-primary btn-xs" data-title="Modifier" data-toggle="modal" data-target="#modifier" ><span class="glyphicon glyphicon-pencil"></span></button></p></td>
                                    <td><p data-placement="top" data-toggle="tooltip" title="Supprimer"><button class="btn btn-danger btn-xs" data-title="Supprimer" data-toggle="modal" data-target="#supprimer" ><span class="glyphicon glyphicon-trash"></span></button></p></td>
                                </tr>
                                <tr>
                                    <td>Exemple</td>
                                    <td>47</td>
                                    <td>17€</td>
                                    <td>La Poste</td>
                                    <td><p data-placement="top" data-toggle="tooltip" title="Modifier"><button class="btn btn-primary btn-xs" data-title="Modifier" data-toggle="modal" data-target="#modifier" ><span class="glyphicon glyphicon-pencil"></span></button></p></td>
                                    <td><p data-placement="top" data-toggle="tooltip" title="Supprimer"><button class="btn btn-danger btn-xs" data-title="Supprimer" data-toggle="modal" data-target="#supprimer" ><span class="glyphicon glyphicon-trash"></span></button></p></td>
                                </tr>
                                <tr>
                                    <td>Exemple</td>
                                    <td>2</td>
                                    <td>58€</td>
                                    <td>Colissimo</td>
                                    <td><p data-placement="top" data-toggle="tooltip" title="Modifier"><button class="btn btn-primary btn-xs" data-title="Modifier" data-toggle="modal" data-target="#modifier" ><span class="glyphicon glyphicon-pencil"></span></button></p></td>
                                    <td><p data-placement="top" data-toggle="tooltip" title="Supprimer"><button class="btn btn-danger btn-xs" data-title="Supprimer" data-toggle="modal" data-target="#supprimer" ><span class="glyphicon glyphicon-trash"></span></button></p></td>
                                </tr>
                                <tr>
                                    <td>Exemple</td>
                                    <td>8</td>
                                    <td>15€</td>
                                    <td>Poney Express</td>
                                    <td><p data-placement="top" data-toggle="tooltip" title="Modifier"><button class="btn btn-primary btn-xs" data-title="Modifier" data-toggle="modal" data-target="#modifier" ><span class="glyphicon glyphicon-pencil"></span></button></p></td>
                                    <td><p data-placement="top" data-toggle="tooltip" title="Supprimer"><button class="btn btn-danger btn-xs" data-title="Supprimer" data-toggle="modal" data-target="#supprimer" ><span class="glyphicon glyphicon-trash"></span></button></p></td>
                                </tr>
                                <tr>
                                    <td>Exemple</td>
                                    <td>1</td>
                                    <td>85€</td>
                                    <td>DHL</td>
                                    <td><p data-placement="top" data-toggle="tooltip" title="Modifier"><button class="btn btn-primary btn-xs" data-title="Modifier" data-toggle="modal" data-target="#modifier" ><span class="glyphicon glyphicon-pencil"></span></button></p></td>
                                    <td><p data-placement="top" data-toggle="tooltip" title="Supprimer"><button class="btn btn-danger btn-xs" data-title="Supprimer" data-toggle="modal" data-target="#supprimer" ><span class="glyphicon glyphicon-trash"></span></button></p></td>
                                </tr>
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
                            <input class="form-control " type="text" placeholder="Nom du produit">
                        </div>
                        <div class="form-group">
                            <input class="form-control " type="text" placeholder="Quantité">
                        </div>
                        <div class="control-group">
                          <label for="fournisseur">Fournisseur</label>
                          <select id="selectfournisseur"class="form-control" name="fournisseur">
                            <option value="0" >Colissimo</option>
                            <option value="1" >DHL</option>
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
                            <input class="form-control " type="text" placeholder="Prénom">
                        </div>
                        <div class="form-group">
                            <input class="form-control " type="text" placeholder="Nom">
                        </div>
                        <div class="form-group">
                            <input class="form-control" placeholder="Date de naissance">
                        </div>
                        <div class="form-group">
                            <input class="form-control" placeholder="Adresse">
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
                        <h4 class="modal-title custom_align" id="Heading">Supprimer ce bon</h4>
                    </div>
                    <div class="modal-body">
                        <div class="alert alert-danger"><span class="glyphicon glyphicon-warning-sign"></span> Etes vous sûr de vouloir supprimer ce bon de commande, définitivement, pour toujours et à jamais ?</div>
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
                            <select id="nomproduit"class="form-control" name="nomproduit">
                                <option value="0" >Câble</option>
                                <option value="1" >Yahourt</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <input class="form-control " type="text" placeholder="Quantité">
                        </div>
                        <div class="control-group">
                          <label for="fournisseur">Fournisseur</label>
                          <select id="selectfournisseur"class="form-control" name="fournisseur">
                            <option value="0" >Colissimo</option>
                            <option value="1" >DHL</option>
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
