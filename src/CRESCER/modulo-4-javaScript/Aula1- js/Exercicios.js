function gerarPiramide(niveis){
  for ( let i = 1; i <= niveis; ++i )  {
    console.log(Array(i+1).join('R$'));
  }
}

function diglettDig(){
  let diglett = 'Diglett dig';
  let trio = 'trio trio trio';
  for (var i = 1; i <= 100; i++) {
    if(i % 3 === 0 && i % 5 === 0)
      console.log(diglett +', ' + trio);
      else if(i % 3 === 0)
        console.log(diglett);
        else if(i % 5 === 0)
          console.log(trio);
          else{
            console.log(i);
          }
      }
    }

function find(array, funcao){
  if(typeof funcao === "function"){
    let retorno = [];
    for (let i = 0, len = array.length; i < len; i++) {
      if(funcao(array[i])){
        retorno.push(array[i]);
      }
    }
    return retorno;
  }
  return [];
}

function subtrair(num1){
  return function(num2){
    return num1 - num2;
  }
}

function iguais(obj1, obj2){

  if(Object.keys(obj1).length !== Object.keys(obj2).length)
    return false;

  function ehObjeto(obj){
    return typeof obj === 'object';
  }

  if(ehObjeto(obj1) && ehObjeto(obj2)){
    for(let prop  in obj1){
      let saoIguais = iguais(obj1[prop], obj2[prop]);
      if(!saoIguais)
        return false;
    }
      return true;
  }
  return obj1 === obj2;
}
