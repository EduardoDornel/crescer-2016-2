using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using Loja.Dominio;
using Loja.Web.Servicos;

namespace Loja.Web.Controllers
{
    public class ProdutoController : Controller
    {
        public ActionResult ListarProdutos()
        {
            ProdutoServico produtoServico = ServicoDeDependencias.MontarProdutoServico();

            List<Produto> produto = produtoServico.ListarProdutos("");

            return View(produto);
        }

        public ActionResult Cadastrar()
        {
            return View();
        }
    }
}