class Herois{

  constructor(array) {
       this.arrayDeHerois = array;
   }

foraDaGuerraCivil(){
  return this.arrayDeHerois.filter(heroi =>
        heroi.events.items.filter(e => e.name.contem('CiVIl war', true)).length === 0
      )
}

maisPublicado() {
  return this.arrayDeHerois
    .sort((heroi1, heroi2) =>
      heroi2.comics.available - heroi1.comics.available
    )[0];
}

mediaPaginas(){
  return this.arrayDeHerois.reduce(
      (acumulador, heroi) =>
          acumulador +
          heroi.comics.items.reduce(
            (acumuladorComic, comic) =>
              acumuladorComic + comic.pageCount
          , 0)
      , 0) / this.arrayDeHerois.length;
}

seriesPorLongevidade(){
  let todasSeries =
    this.arrayDeHerois.map(heroi => heroi.series.items)
    .reduce(
      (acumulador, series) => acumulador.concat(series)
      , []);

      return todasSeries
        .sort(
          (serie1, serie2) =>{
            let diff = (serie2.endYear - serie2.startYear) - (serie1.endYear - serie1.startYear);
            return diff;
          });


}

comicMaisCara(array){
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
}
