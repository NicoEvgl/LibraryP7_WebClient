<%@ page pageEncoding="UTF-8"%>

<%@include file="_includes/header.jsp"%>

<main class="page guideBookList-page">
    <section class="clean-block clean-services dark">
        <div class="container">
            <div class="block-heading">
                <h2 class="text-info">Rechercher un livre</h2>
                <div class="row">
                    <form:form cssClass="form-inline" modelAttribute="book" method="post" action="search-book">
                        <form:input type="text" path="title" class="form-control form-control-sm mb-3" placeholder="Titre"
                                    autofocus="true"/>
                        <form:input type="text" path="author" class="form-control form-control-sm mb-3" placeholder="Auteur"
                                    autofocus="true"/>
                        <div class="form-inline">
                            <form:button class="btn btn-secondary mb-2" type="submit">Rechercher</form:button>
                        </div>
                        <div class="form-group">
                            <a href="<c:out value="javascript:history.go(-1)"/>" class="btn btn-outline-primary btn-block">
                                Annuler
                            </a>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </section>
</main>

<%@include file="_includes/footer.jsp"%>
