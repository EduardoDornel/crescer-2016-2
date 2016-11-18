class Listagem {

    constructor(seletor) {
        this.$elem = $(seletor);
        this.renderizarEstadoInicial();
    }

    registrarBindsEventos() {
        this.$btnAdicionar = $('#btn-adicionar');
        this.$btnAdicionar.on('click', this.adicionar.bind(this));

        this.$btnExcluirPre = $('#btn-excluirPre');
        this.$btnExcluirPre.on('click', this.excluirPre.bind(this));

        this.$btnExcluirInscrito = $('#btn-excluirInscrito');
        this.$btnExcluirInscrito.on('click', this.excluirInscrito.bind(this));
    }

    adicionar() {

    }

    excluirPre() {

    }

    excluirInscrito() {
        let id = this.$btnExcluirInscrito.val();
    }

    renderizarListaPreInscritos() {
    }

    renderizarListaInscritos() {

    }

    renderizarEstadoInicial() {
        this.$elem.show();
        this.registrarBindsEventos();
    }
}