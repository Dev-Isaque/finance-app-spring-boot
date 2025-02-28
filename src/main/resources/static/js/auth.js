function login() {
    var userData = {
        email: $("#email").val(),
        password: $("#password").val()
    };

    $.ajax({
        url: "http://localhost:8080/users/login",
        type: "POST",
        contentType: "application/json",
        dataType: "json",
        data: JSON.stringify(userData),
        success: function(response) {
            console.log("Resposta do backend:", response);
            alert(response.message);

            if (response.userId) {
                sessionStorage.setItem("userId", response.userId); 
                window.location.replace("/index");
            } else {
                alert("Erro ao login: ID do usuário não encontrado na resposta.");
            }
        },
        error: function(xhr) {
            console.error("Erro ao login:", xhr.responseText);
            try {
                let errorMessage = JSON.parse(xhr.responseText).message;
                alert("Erro ao login: " + errorMessage);
            } catch (e) {
                alert("Erro ao login: Resposta inválida do servidor.");
            }
        }
    });
}


function register() {
    var userData = {
        name: $("#name").val(),
        cpf: $("#cpf").val(),
        dataNasc: $("#data_nasc").val(),
        sexo: $("#sexo").val(),
        telefone: $("#telefone").val(),
        cep: $("#cep").val(),
        endereco: $("#endereco").val(),
        bairro: $("#bairro").val(),
        cidade: $("#cidade").val(),
        email: $("#email").val(),
        password: $("#senha").val()
    };
    

    $.ajax({
        url: "http://localhost:8080/users/register",
        type: "POST",
        contentType: "application/json",
        dataType: "json",
        data: JSON.stringify(userData),
        success: function(response) {
            console.log("Resposta do backend:", response);
            alert(response.message);
            window.location.replace("/login");
        },
        error: function(xhr) {
            console.error("Erro ao registrar:", xhr.responseText);
            try {
                let errorMessage = JSON.parse(xhr.responseText).message;
                alert("Erro ao registrar: " + errorMessage);
            } catch (e) {
                alert("Erro ao registrar: Resposta inválida do servidor.");
            }
        }
    });
}