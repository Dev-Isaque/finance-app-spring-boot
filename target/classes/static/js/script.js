document.addEventListener("DOMContentLoaded", function () {
    let userId = sessionStorage.getItem("userId");

    if (!userId) {
        alert("Você precisa estar logado para acessar essa página.");
        window.location.href = "/login"; // Use href em vez de replace para histórico correto
    }
});
