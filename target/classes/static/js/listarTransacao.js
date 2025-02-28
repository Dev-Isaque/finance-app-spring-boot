document.addEventListener("DOMContentLoaded", function () {
    let userId = sessionStorage.getItem("userId");

    $.ajax({
        url: `/transacoes/listar-transacoes?userId=${userId}`, // Ajustado para query string
        type: "GET",
        dataType: "json",
        success: function (data) {
            let tabela = $("#transacoesTable");
            tabela.empty();

            if (data.length === 0) {
                tabela.append("<tr><td colspan='6' class='text-center'>Nenhuma transação encontrada.</td></tr>");
            } else {
                data.forEach(transacao => {
                    let dataFormatada = new Date(transacao.data).toLocaleDateString("pt-BR");
                    
                    let row = `<tr>
                        <td>${dataFormatada}</td>
                        <td>${transacao.tipo}</td>
                        <td>${transacao.categoria}</td>
                        <td>R$ ${parseFloat(transacao.valor).toFixed(2)}</td>
                        <td>${transacao.formaPagamento}</td>
                        <td>${transacao.descricao || 'Sem descrição'}</td>
                        <td><button class="btn-primary"><i class="bi bi-trash"></button></i></td>
                    </tr>`;
                    tabela.append(row);
                });
            }
        },
        error: function (xhr) {
            console.error("Erro ao buscar transações:", xhr.responseText);
            alert("Erro ao carregar transações.");
        }
    });
});