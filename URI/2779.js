var input = require('fs').readFileSync('/dev/stdin', 'utf8');
var lines = input.split('\n');
  var N = parseInt(lines.shift());
  var M = parseInt(lines.shift());
  var qtdeVez = 0;
  var suaVez = 0;
  var x = new Array(M);
  
  for (var i = 0; i < M; i++) {
    x[i] = parseInt(lines.shift());
  }

  for (var i = 0; i < M; i++) {
    suaVez = x[i];
    qtdeVez = 0;

    for (var j = 0; j < M; j++) {
      if(x[j] == suaVez) {
        qtdeVez++;
      }
    }
    if (qtdeVez >= 2) {
      for (var j = 0; j < M; j++) {
        if (suaVez == x[j]) {
          x[j] = -1;
          break;
        }
      }
    }

  }
  var figuras = 0;
  for (var i = 0; i < M; i++) {
    if (x[i] != -1){
      figuras++;
    }
  }

console.log(N-figuras);
