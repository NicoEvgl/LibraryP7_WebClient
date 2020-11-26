<%@ page pageEncoding="UTF-8"%>

<%@include file="_includes/header.jsp"%>


<main class="page home-page">
    <section class="clean-block clean-info dark">
        <div class="container">
            <header class="jumbotron my-4">
                <h1 class="display-3">Bienvenue sur le site de la bibliothèque OC !</h1>
                <p class="lead">Notre site vous permet de rechercher tous les ouvrages qu'il est possible d'emprunter dans notre
                    bibliothèque et vous offre également la possibilité de gérer vos emprunts depuis votre espace personnel.</p>
                <a class="btn btn-primary btn-lg" href="<c:url value="/search-book"/>">Rechercher un ouvrage</a>
            </header>
            <div class="row align-items-center">
                <div class="getting-started-info">
                    <p>
                        Bienvenue sur le site officiel de la  bibliothèque d'OC.
                        Vous trouverez dans notre catalogue tous les livres qu'il est possible
                        d'emprunter dans notre bibliothèque et la possibilité de gérer vos
                        emprunts depuis votre espace personnel.
                    </p>
                </div>
            </div>
        </div>
    </section>
</main>

<%@include file="_includes/footer.jsp"%>



