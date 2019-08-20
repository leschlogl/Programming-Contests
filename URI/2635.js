var input = require('fs').readFileSync('/dev/stdin', 'utf8');
var lines = input.split('\n');

var n = 0, q = 0;
var text = "";

while( (x = lines.shift()) !== undefined ) {
  var n = parseInt(x);
  var data = []
  for (var i = 0; i < n; i++) {
    text = lines.shift()
    data.push(text);
  }
  q = parseInt(lines.shift());
  while(q-- > 0) {
    text = lines.shift();
    var ans = 0, len = 0;
    for(var i = 0; i < n; i++) {
      if(data[i].indexOf(text) === 0) {
        ans++;
        len = Math.max(len, data[i].length);
      }
    }
    if (ans === 0) {
      console.log("-1");
    } else {
      console.log(`${ans} ${len}`);
    }
  }
}
