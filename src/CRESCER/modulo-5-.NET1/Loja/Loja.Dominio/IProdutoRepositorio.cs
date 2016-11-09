using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Loja.Dominio
{
    public interface IProdutoRepositorio
    {
        void SalvarProduto(Produto produto);

        List<Produto> listarProdutos();

    }
}
