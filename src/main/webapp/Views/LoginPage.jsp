<%-- 
    Document   : LoginPage
    Created on : 21 nov. 2018, 16:27:05
    Author     : Taffoureau
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="Css/LoginPage.css">
        <link rel="stylesheet" type="text/css" href="Css/bootstrap.css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Connexion</title>
    </head>
    <body>


<div class="container login-container">
            <div class="row">
                <div class="col-md-6 login-form-1">
                    <h3>Administrateur</h3>
                    
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="Nom d'utilisateur *" value="" />
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control" placeholder="Mot de passe *" value="" />
                        </div>
                        <div class="form-group">
                            <input type="submit" class="btnSubmitAdmin" value="Connexion" />
                        </div>
                        <div class="form-group">
                            <a href="#" class="btnForgetPwd">Mot de passe oublié ?</a>
                        </div>
                    
                </div>
                <div class="col-md-6 login-form-2">
                    <h3>Client</h3>
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="Nom d'utilisateur *" value="" />
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control" placeholder="Mot de passe*" value="" />
                        </div>
                        <div class="form-group">
                            <input type="submit" class="btnSubmitClient" value="Connexion" />
                        </div>
                        <div class="form-group">

                            <a href="#" class="btnForgetPwd" value="Login">Mot de passe oublié ?</a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
