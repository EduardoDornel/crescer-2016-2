function botoes() {
    let $botoes = $('#botoes');
    ['aprovar', 'desaprovar'].forEach(item => {
        let $novoBotao = $('<button id="botoes">');
        $novoBotao.click(() => {
            alert('clicou em ' + item);
        });
        $novoBotao.text(item);
        $botoes.append($novoBotao);
    })
}

$(function () {
    $.ajax({
        url: "ListarPreInscritos",
        dataType: 'json',
        type: "GET",
        success: function (preInscritos) {
            var tBodyHTML = '';
            $.each(preInscritos, function (i, inscrito) {
              var date = new Date(parseInt(inscrito.DataNascimento.substr(6)));
              tBodyHTML += '<tr>' + '<td>' + inscrito.Nome
                        + '</td><td>' + inscrito.Email
                        + '</td><td>' + inscrito.Telefone
                        + '</td><td>' + date.getDay() + '/' + (date.getMonth() + 1) + '/' + date.getYear()
                          + '</td><td>' + inscrito.Documento
                          + '</td><td>' + '<button id="botoes">'+botoes+'</button>' + '</td>' + '</tr>'
            });
            $('#pendentes').html(tBodyHTML);
        }
    });
});

