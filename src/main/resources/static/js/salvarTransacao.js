$(document).ready(function () {
    $("#transacaoForm").submit(function (event) {
        event.preventDefault(); 
        salvarTransacao();
    });
});

function salvarTransacao() {
    $("#botaoSalvar").prop("disabled", true).text("Salvando...");

    let formData = {
        tipo: $("select[name='tipo']").val().trim(),
        valor: formatarValorParaBigDecimal($("input[name='valor']").val().trim()),
        data: $("input[name='data']").val().trim(),
        categoria: $("select[name='categoria']").val().trim(),
        descricao: $("textarea[name='descricao']").val().trim(),
        formaPagamento: $("select[name='formaPagamento']").val().trim(),
        userId: obterUsuarioId()
    };

    if (!formData.userId) {
        mostrarMensagem("Usuário não autenticado!", "danger");
        $("#botaoSalvar").prop("disabled", false).text("Salvar");
        return;
    }

    $.ajax({
        type: "POST",
        url: "/transacoes/salvar", 
        contentType: "application/json",
        data: JSON.stringify(formData),
        success: function () {
            $("#transacaoForm")[0].reset();  
            mostrarMensagem("Transação salva com sucesso!", "success");
            $("#transacaoForm input:first").focus(); 
        },
        error: function (xhr) {
            let errorMsg = "Erro ao salvar a transação!";
            if (xhr.status === 400) {
                errorMsg = "Dados inválidos! Verifique os campos.";
            } else if (xhr.status === 401) {
                errorMsg = "Usuário não autenticado!";
            } else if (xhr.status === 500) {
                errorMsg = "Erro no servidor! Tente novamente.";
            }
            mostrarMensagem(errorMsg, "danger");
        },
        complete: function () {
            $("#botaoSalvar").prop("disabled", false).text("Salvar");
        }
    });
}

// 🟢 Converte "R$ 1.234,56" para "1234.56" (BigDecimal válido)
function formatarValorParaBigDecimal(valor) {
    if (!valor) return 0.00;

    let valorFormatado = valor.replace(/\./g, "").replace(",", ".").replace("R$", "").trim();

    let numero = parseFloat(valorFormatado);
    return isNaN(numero) ? 0.00 : numero; // Evita NaN caso o valor seja inválido
}

// 🟢 Obtém o ID do usuário armazenado no sessionStorage
function obterUsuarioId() {
    let usuario = sessionStorage.getItem("userId");

    if (!usuario) {
        console.error("Usuário não autenticado!");
        return null;
    }

    try {
        let usuarioObj = JSON.parse(usuario);
        return Number(usuarioObj.id || usuarioObj);
    } catch (e) {
        return Number(usuario); 
    }
}

// 🟢 Função para exibir mensagens sem redirecionar
function mostrarMensagem(mensagem, tipo) {
    $("#mensagem")
        .stop(true, true)
        .hide()
        .removeClass("alert-success alert-danger")
        .addClass(`alert-${tipo}`)
        .text(mensagem)
        .fadeIn()
        .delay(3000)
        .fadeOut();
}
