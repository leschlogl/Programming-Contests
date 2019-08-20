var input = require('fs').readFileSync('/dev/stdin', 'utf8');
var lines = input.split(' ');

var p1 = lines.shift();
var p2 = lines.shift();

var d1 = parseInt(p2.charCodeAt(0)) - parseInt(p1.charCodeAt(0));
var d2 = parseInt(p2.charAt(1)) - parseInt(p1.charAt(1));

if (Math.abs(d1*d2) == 2) {
  console.log("VALIDO");
} else {
  console.log("INVALIDO");
}
