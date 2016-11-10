using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using Loja.Dominio;
using Loja.Web.Servicos;
using Loja.Web.Models;

namespace Loja.Web.Controllers
{
    public class ProdutoController : Controller
    {
        public ActionResult ListarProdutos(string filtro = null)
        {
            ProdutoServico produtoServico = ServicoDeDependencias.MontarProdutoServico();

            List<Produto> produto = produtoServico.ListarProdutos(filtro);

            ProdutoModel produtoModel = new ProdutoModel(produto);

            return View(produtoModel);
        }

        public ActionResult Editar(int id)
        {
            ProdutoServico produtoServico = ServicoDeDependencias.MontarProdutoServico();
            var produto = produtoServico.BuscarId(id);

            var model = new ProdutoModel(produto.Id, produto.Nome, produto.Valor);

            return View("Cadastrar", model);
        }

        public ActionResult Excluir(int id)
        {
            ProdutoServico produtoServico = ServicoDeDependencias.MontarProdutoServico();

            produtoServico.Excluir(id);

            return RedirectToAction("ListarProdutos");
        }

        public ActionResult Cadastrar()
        {
            return View();
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Salvar(ProdutoModel model)
        {
            ProdutoServico produtoServico = ServicoDeDependencias.MontarProdutoServico();

            Produto produto = new Produto(model.Nome, model.Valor, model.Id);

            if (produto.Id != 0)
                produtoServico.Editar(produto);
            else
                produtoServico.Salvar(produto);

            return RedirectToAction("ListarProdutos");
        }
    }
}