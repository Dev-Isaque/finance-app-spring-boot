$(document).ready(function () {
    let userId = sessionStorage.getItem("userId");

    if (!userId) {
        alert("Você precisa estar logado para acessar essa página.");
        window.location.href = "/auth/login"; // Redireciona para login caso o usuário não esteja logado
    }

    $.ajax({
        url: `/users/obter-usuario?userId=${userId}`,  
        type: "GET",
        dataType: "json",
        success: function (data) {
            console.log(data);
            $(".nomeUsuario").text(data.firstName + " " + data.lastName);
            $(".emailUsuario").text(data.email);
            $(".telefoneUsuario").text(data.telefone);

            // Mostrar elementos após o carregamento dos dados
            $(".usuarioDados").removeClass("d-none");
        },
        error: function (xhr) {
            console.error("Erro ao buscar dados do usuário:", xhr.responseText);
            alert("Erro ao carregar dados do usuário.");
        }
    });
});
