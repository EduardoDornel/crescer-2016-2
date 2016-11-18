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
    }

    adicionar() {

    }

    excluirPre() {
        let id = this.$btnExcluirPre.val();
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