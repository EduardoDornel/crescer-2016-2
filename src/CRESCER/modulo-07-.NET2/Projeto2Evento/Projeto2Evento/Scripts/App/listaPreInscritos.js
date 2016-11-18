$(function () {
    $.ajax({
        url: "ListarPreInscritos",
        dataType: 'json',
        type: "GET",
        success: function (preInscritos) {
            var tBodyHTML = '';
            $.each(preInscritos, function (i, inscrito) {
                tBodyHTML += '<tr>' + '<td>' + inscrito.Nome
                          + '</td><td>' + inscrito.Email
                          + '</td><td>' + inscrito.Telefone
                          + '</td><td>' + new Date(parseInt(inscrito.DataNascimento))
                          + '</td><td>' + inscrito.Documento
                          + '</td><td>' + '<button onclick="aprovar(inscrito.Id)" class="btn-aprovar">Aprovar</button>'
                          + '<button onclick="reprovar(inscrito.Id)" Id="btn-reprovar">Reprovar</button></td>' + '</tr>'
            });
            $('#pendentes').html(tBodyHTML);
        }
    });
});

this.$btnExcluirPre = $('#btn-reprovar');
this.$btnExcluirPre.on('click', this.reprovar.bind(this));

/*reprovar(usuario){
    return $.post('/api/herois', usuario)
}*/