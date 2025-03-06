let userId = sessionStorage.getItem("userId");

$.ajax({
    url: `/transacoes/listar-transacoes?userId=${userId}`,
    type: "GET",
    dataType: "json",
    success: function (data) {
        let tabela = $("#transacoesTable");
        tabela.empty();

        // Se 'data' for undefined ou não for um array, tratamos como vazio
        if (!Array.isArray(data) || data.length === 0) {
            tabela.append("<tr><td colspan='6' class='text-center'>Nenhuma transação encontrada.</td></tr>");
            return;
        }

        data.forEach(transacao => {
            let dataFormatada = new Date(transacao.data).toLocaleDateString("pt-BR");

            let row = `<tr>
                    <input type="hidden" class="transacao-id" value="${transacao.id}">
                    <td>${dataFormatada}</td>
                    <td>${transacao.tipo}</td>
                    <td>${transacao.categoria}</td>
                    <td>R$ ${parseFloat(transacao.valor).toFixed(2)}</td>
                    <td>${transacao.formaPagamento}</td>
                    <td>${transacao.descricao || 'Sem descrição'}</td>
                <td><button class="btn-primary" onclick="deletaTransacao(this)"><i class="bi bi-trash"></button></i></td>
                </tr>`;
            tabela.append(row);
        });
    },
    error: function (xhr) {
        console.error("Erro ao buscar transações:", xhr.responseText);
        alert("Erro ao carregar transações.");
    }
});

function deletaTransacao(btn) {
    var linha = $(btn).closest("tr");
    var transacaoId = linha.find(".transacao-id").val();

    // Exibe o pop-up de confirmação
    if (!confirm("Tem certeza que deseja excluir esta transação?")) {
        return;
    }

    $.ajax({
        url: `/transacoes/deletar-transacao?transacaoId=${transacaoId}`,
        type: "DELETE",
        success: function () {
            linha.remove(); // Remove a linha da tabela
            alert("Transação excluída com sucesso!");
        },
        error: function (xhr) {
            if (xhr.status === 404) {
                alert("Erro: Transação não encontrada.");
            } else {
                alert("Erro ao excluir a transação.");
            }
        }
    });
}
