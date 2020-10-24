<%@ page pageEncoding="UTF-8" %>

<%@include file="_includes/header.jsp"%>


<div class="view" style="background-image: url('https://cdn.crunchify.com/bg.png'); background-repeat: no-repeat; background-size: cover; background-position: center ;"/>
<main class="page register-page">
    <section class="clean-block clean-form dark">
        <div class="container">
            <div class="block-heading">
                <h3 class="text-info">S'inscrire</h3>
            </div>
            <div>
                <form:form cssClass="form-group" method="post" action="registerProcess" modelAttribute="user">
                    <div class="form-group">
                        <form:select path="gender" type="text" cssClass="form-control" placeholder="Genre" required="true" autofocus="">
                            <form:option value="M" label="Monsieur"/>
                            <form:option value="F" label="Madame"/>
                        </form:select>
                    </div>
                    <div class="form-row">
                        <div class="col">
                            <form:label path="firstName" for="firstname">Prénom</form:label>
                            <form:input path="firstName" type="text" cssClass="form-control" placeholder="Prénom" required="true" autofocus=""/>
                            <form:errors path="firstName" cssClass="error"/>
                        </div>
                        <div class="col">
                            <form:label path="lastName" for="lastname">Nom</form:label>
                            <form:input path="lastName" type="text" cssClass="form-control" placeholder="Nom" required="true" autofocus=""/>
                            <form:errors path="lastName" cssClass="error"/>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <form:label path="username" for="inlineFormInputGroupUsername">Nom d'utilisateur</form:label>
                            <form:input path="username" type="text" cssClass="form-control" id="inlineFormInputGroupUsername" placeholder="Nom d'utilisateur" required="true" autofocus=""/>
                            <form:errors path="username" cssClass="error"/>
                        </div>
                        <div class="form-group col-md-6">
                            <form:label path="email" for="inputEmail4">Email</form:label>
                            <form:input path="email" type="email" cssClass="form-control" id="inputEmail4" placeholder="Email" required="true" autofocus=""/>
                            <form:errors path="email" cssClass="error"/>
                        </div>
                        <div class="form-group col-md-6">
                            <form:label path="password" for="inputPassword4">Mot de Passe</form:label>
                            <form:input path="password" type="password" cssClass="form-control" id="inputPassword4" placeholder="Mot de passe"
                                        minlenght="6" pattern="^(?=.{6,}$)(?=.*?[a-z])(?=.*?[A-Z])(?=.*?[0-9]).*$"
                                        title="Le mot de passe doit contenir au moins 6 caractères avec au moins une majuscule et un chiffre" required="true"/>
                            <form:errors path="password" cssClass="error"/>
                        </div>
                    </div>
                    </div>
                    <form:button type="submit" class="btn btn-primary">S'inscrire</form:button>
                </form:form>
            </div>
        </div>
    </section>
</main>

<%@include file="_includes/footer.jsp"%>
