function gerarPiramide(niveis){
  var cifrao = "R$";
  for ( var i = 1; i <= niveis; ++i )  {
    var naTela = "";
    for ( var coluna = 1; coluna <= i; ++coluna ){
      naTela += cifrao;
    }
    console.log(naTela);
  }
}
gerarPiramide(9);

function diglettDig(){
  var diglett = 'Diglett dig';
  var trio = 'trio trio trio';
  for (var i = 1; i <= 100; i++) {
    if(i % 3 === 0 && i % 5 === 0)
      console.log(diglett +', ' + trio);
      else if(i % 3 === 0)
        console.log(diglett);
        else if(i % 5 === 0)
          console.log(trio);
          else {
            console.log(i);
        }
      }
    }
diglettDig();
