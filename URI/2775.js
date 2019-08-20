var input = require('fs').readFileSync('/dev/stdin', 'utf8');
var lines = input.split('\n');

var N = 0;
var cost = 0;

while (N = parseInt(lines.shift())) {
  var v = [];
  var line1 = lines.shift().split(' ');
  var line2 = lines.shift().split(' ');
  
  for (var i = 0; i < N; i++) {
    var number = parseInt(line1[i]);
    var array = [];
    array.push(number);
    v[i] = array;
  }
  for (var i = 0; i < N; i++) {
    var number = parseInt(line2[i]);
    var arr = v[i]
    arr.push(number);
    v[i] = arr;
  }
  cost = 0;
  for(i = 0; i < N; i++){
  	for(j = 1; j < N; j++){
      if(v[j-1][0] > v[j][0]){
        var temp = v[j-1];
        v[j-1] = v[j];
        v[j] = temp;
        cost += v[j-1][1] + v[j][1];
      }
    }
  }
  console.log(cost);
}
