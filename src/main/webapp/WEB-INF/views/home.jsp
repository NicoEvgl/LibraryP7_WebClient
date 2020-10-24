<%@ page pageEncoding="UTF-8"%>

<%@include file="_includes/header.jsp"%>


<main class="page home-page">
    <section class="clean-block clean-info dark">
        <div class="container">
            <div class="block-heading">
                <h2 class="text-info">Bienvenue sur le site Library</h2>
                <h2 class="text-info">Library</h2>
                <p>
                    Notre site référence tous les ouvrages disponibles dans notre bibliothèque.
                </p>
            </div>
            <div class="row align-items-center">
                <div class="col-md-6">
                    <h3 class="text-info"><a href="<c:url value="/"/>">Consulter la liste des ouvrages</a></h3>
                    <div class="getting-started-info">
                        <p>
                            Bienvenue sur le site officiel de la  bibliothèque d'OCland.
                            Vous trouverez dans notre catalogue tous les livres qu'il est possible
                            d'emprunter dans notre bibliothèque et la possibilité de gérer vos
                            emprunts depuis votre espace personnel.
                        </p>
                    </div>
                </div>
                <div class="col-md-6"><img class="img-thumbnail" src="<c:url value="/resources/img/home.jpg"/>"/></div>
            </div>
        </div>
    </section>
</main>

<%@include file="_includes/footer.jsp"%>
