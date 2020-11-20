<%@ page pageEncoding="UTF-8"%>

<%@include file="_includes/header.jsp"%>

<main class="page personalSpace-page">
    <section class="clean-block clean-services dark">
        <div class="container">
            <div class="container">
                <div class="block-heading">
                    <h2 class="text-info">Profil</h2>
                </div>
                <div class="row">
                    <div class="col">
                        <div class="card shadow mb-3">
                            <div class="card-body">
                                <table class="table text-center my-0">
                                    <thead>
                                    <tr>
                                        <th>Genre</th>
                                        <th>Prénom</th>
                                        <th>Nom</th>
                                        <th>Pseudo</th>
                                        <th>Email</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td>${userInSession.gender}</td>
                                        <td>${userInSession.firstName}</td>
                                        <td>${userInSession.lastName}</td>
                                        <td>${userInSession.username}</td>
                                        <td>${userInSession.email}</td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</main>

<%@include file="_includes/footer.jsp"%>