var input = require('fs').readFileSync('/dev/stdin', 'utf8');
var lines = input.split('\n');
  var n = 0;
  var m = parseInt(lines.shift());
  while (m-- > 0) {
    n =  parseInt(lines.shift());
    var atual = 0;
    var ans = 0;
    while(n) {
      if(n % 2 !== 0) atual++;
      else atual = 0;
      ans = Math.max(ans, atual);
      n = parseInt(n/2);
    }
    console.log(ans);
  }
