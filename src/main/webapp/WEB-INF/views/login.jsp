<%@ page pageEncoding="UTF-8"%>

<%@include file="_includes/header.jsp"%>


<main class="page login-page">
    <section class="clean-block clean-form dark">
        <div class="container">
            <div class="block-heading">
                <h3 class="text-info">Se connecter</h3>
            </div>
            <form:form method="post" action="loginProcess" modelAttribute="user" >
                <div class="form-group">
                    <form:label path="pseudo" for="exampleInputUsername">Pseudo</form:label>
                    <form:input path="pseudo" type="username" class="form-control" id="exampleInputUsername" aria-describedby="usernameHelp" placeholder="pseudo" required="true"/>
                    <small id="emailHelp" class="form-text text-muted">We'll never share your login with anyone else.</small>
                    <form:errors path="pseudo" cssClass="error"/>
                </div>
                <div class="form-group">
                    <form:label path="password" for="exampleInputPassword1">Mot de passe</form:label>
                    <form:input path="password" type="password" class="form-control" id="exampleInputPassword1" placeholder="mot de passe"
                                minlenght="6" pattern="^(?=.{6,}$)(?=.*?[a-z])(?=.*?[A-Z])(?=.*?[0-9]).*$"
                                title ="Le mot de passe doit contenir au moins 6 caractères avec au moins une majuscule et un chiffre" required="true"/>
                    <form:errors path="password" cssClass="error"/>
                </div>
                <form:button type="submit" class="btn btn-primary">Se connecter</form:button>
                <div class="text-center">
                    <p>
                        Pas encore de compte ?
                        <a  href="<c:url value="/account-creation"/>">
                            <button class="btn btn-link btn-block" type="button">S'inscrire</button>
                        </a>
                    </p>
                </div>
            </form:form>
        </div>
    </section>
</main>

<%@include file="_includes/footer.jsp"%>