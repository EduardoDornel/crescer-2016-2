using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Loja.Dominio
{
    public interface IProdutoRepositorio
    {
        List<Produto> ListarProdutos(string filtro);
        void Salvar(Produto produto);
        void Editar(Produto produto);
        void Excluir(Produto produto);
        Produto BuscarId(int id);
    }
}
