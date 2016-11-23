var listagemUsuario = {};

listagemUsuario.listarPreInscritos = function () {
    $.ajax({
        url: '/Usuario/ListarPreInscritos',
        type: 'GET'
    })
        .done(function (resultado) {
            $('#lista-pre').html(resultado);
        })
        .fail(function (erro) {
            console.error(erro);
        });
}

listagemUsuario.listarAprovados = function () {
    $.ajax({
        url: '/Usuario/ListarInscritos',
        type: 'GET'
    })
    .done(function (resultado) {
        $('#lista-aprovados').html(resultado);
    });
}

listagemUsuario.aprovar = function (id) {
    $.ajax({
        url: '/Usuario/Aprovar',
        type: 'POST',
        data: {
            id: id
        }
    })
        .then(function (resultado) {
            $('#lista-aprovados').html(resultado);
        })
}

listagemUsuario.configurarBotoes = function (id) {
    if (id !== 0) {
      listagemUsuario.$btnAprovar.click(listagemUsuario.aprovar(id));
    }
}

listagemUsuario.iniciar = function () {
    listagemUsuario.$btnAprovar = $("#btn-aprovar");
  //  listagemUsuario.$btnReprovar = $("#btn-reprovar");

    listagemUsuario.listarPreInscritos();
    listagemUsuario.listarAprovados();
}