class Herois{
  constructor(array = []) {
       this.arrayDeHerois = new Array();
       for (let prop in array) {
           this.arrayDeHerois.push(array[prop]);
       }
   }
}

function foraDaGuerraCivil(){
 // return this.arrayDeHerois.filter(heroi => heroi.events.items.filter(e => e.name.indexOf('Civil War')).length === 0)
}

function maisPublicado(array) {
  var maiorQtd;
  maiorQtd = array[0];

  for (let prop in array) {
    if(array[prop].comics.available > maiorQtd.comics.available)
      maiorQtd = array[prop];
  }
  return maiorQtd;
}

function mediaPaginas(array){
 //var total = array.comics.items.reduce(pagecount);
 //return total / array.comics.items.length;
}

function seriesPorLongevidade(array){
    //
}

function comicMaisCara(array){
  var maisCaro = 0;
  var objMaisCaro;
  function precoTotal(arrayDePreco){
    var total = 0;
    for(var i = 0, len = arrayDePreco.comics.items.length; i < len; i++)
      total += arrayDePreco.comics.items[i].prices[0];
    return total;
  }

  maisCaro = precoTotal(array[0]);
  objMaisCaro = array[0].comics;
  for (var i = 1, leng = array.length; i < leng; i++) {
    var precoDestaPosicao = precoTotal(array[i]);
    if(precoDestaPosicao > maisCaro){
      maisCaro = precoDestaPosicao;
      objMaisCaro = array[i].comics;
    }
  }
  return objMaisCaro;
}
