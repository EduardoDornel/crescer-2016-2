var listarInscrito = $(function () {
    $.ajax({
        url: "ListarInscritos",
        dataType: 'json',
        type: "GET",
        success: function (inscritos) {
            var tBodyHTML = '';
            $.each(inscritos, function (i, inscrito) {
                tBodyHTML += '<tr>' + '<td>' + inscrito.Nome
                          + '</td><td>' + inscrito.Email
                          + '</td><td>' + inscrito.Telefone
                          + '</td><td>' + new Date(parseInt(inscrito.DataNascimento))
                          + '</td><td>' + inscrito.Documento
                          + '</td>'
            });
            $('#aprovados').html(tBodyHTML);
        }
    });
});