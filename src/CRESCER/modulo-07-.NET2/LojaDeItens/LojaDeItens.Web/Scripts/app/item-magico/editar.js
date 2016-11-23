var itemMagicoEditar = {};


itemMagicoEditar.sucessoNoCadastro = function (resposta) {
  // alert(resposta.Mensagem)
  $.ajax({
    url: 'ItemMagico/Salvar',
    type: 'POST',
    data: {
      model: resposta
    }
  })
    .done(function(resultado){
      itemMagicoIndex.iniciar();
    })
}