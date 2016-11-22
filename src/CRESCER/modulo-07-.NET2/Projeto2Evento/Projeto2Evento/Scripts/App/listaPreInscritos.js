
function aprovar(id) {
    $('#btn-aprovar').click(() => {
    $.post('AprovarUsuario', id)
      .done(() => {
          window.listarInscrito;
      })
    })
}

$(function () {
    $.ajax({
        url: "ListarPreInscritos",
        dataType: 'json',
        Type: "GET",
        success: function (preInscritos) {
            var listaPre = '';
            $.each(preInscritos, function (i, preInscrito) {
                var date = new Date(parseInt(preInscrito.DataNascimento.substr(6)));
                listaPre += '<tr>' + '<td>' + preInscrito.Nome
                 + '</td><td>' + preInscrito.Email
                 + '</td><td>' + preInscrito.Telefone
                 + '</td><td>' + date.getDay() + '/' + date.getMonth() + '/' + date.getYear()
                 + '</td><td>' + preInscrito.Documento
                 + '</td><td>' + '<button onclick="aprovar('+preInscrito.Id+')" id="btn-aprovar">Aprovar</button>'
                 + '<button onclick="reprovar('+preInscrito.Id+')" id="btn-reprovar">Reprovar</button></td>' + '</tr>'
            });
            $('#pre-inscritos').html(listaPre);
        }
    });
});

/*$(function () {
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
                        + '</td><td>' + date.getDay()+'/'+date.getMonth()+'/'+date.getYear()
                          + '</td><td>' + inscrito.Documento
                          + '</td><td>' + '<button onclick="aprovar(inscrito.Id)" class="btn-aprovar">Aprovar</button>'
                          + '<button onclick="reprovar(inscrito.Id)" Id="btn-reprovar">Reprovar</button></td>' + '</tr>'
            });
            $('#pendentes').html(tBodyHTML);
        }
    });
});*/

/*$(function () {
  let $botoes = $('#botoes');
  ['aprovar', 'desaprovar'].forEach(item => {
    let $novoBotao = $('<button>');
    $novoBotao.click(() => {
      alert('clicou em ' + item);
    });
    $novoBotao.text(item);
    $botoes.append($novoBotao);
  })
});*/


//FUNCAO BERNARDO
/*$(() => {
  $('#btn-aprovar').click(() => {
    let idAprovado = usuario.Id;
    $.post('/usuario/listarinscritos', idAprovado)
      .done(() => {
        $.get('/usuario/listarinscritos', { id: usuario.Id })
        .done(htmlAprovado => {
          let $td = $('<td>').html(htmlAprovado);
          $tr.append($td);
        })
      }
     );
  });
  let $tr = $('#lista-pre-inscritos');
  $.get('/usuario/ListarPreInscritos')
    .then(response => {
      response.usuario.forEach(usuario => {
        $.get('/usuario/ListarPreInscritos', { id: usuario.id })
          .done(htmlUsuario => {
            let $td = $('<td>').html(htmlUsuario);
            $tr.append($td);
          })
      });
    })
});*/