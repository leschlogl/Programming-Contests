var input = require('fs').readFileSync('/dev/stdin', 'utf8');
var lines = input.split('\n');

Number.prototype.pad = function(size) {
    var s = String(this);
    while (s.length < (size || 2)) {s = "0" + s;}
    return s;
}


var lines = input.split('\n');
var x,y;
for (var idx in lines) {
    y = lines[idx];
  	x = y >> 0;
		var horas = (((y * 240) / 3600) >> 0) % 60;
		var minutos = (((y * 240) / 60)>>0) % 60;
		var segundos = ((y * 240)>>0) % 60;

    var horasStr = `${horas<10? "0":""}${horas+6}`
		if (x >= 0 && x < 90 || x == 360) {
        console.log("Bom Dia!!");
        console.log(`${((horas+6)%24).pad()}:${minutos.pad()}:${segundos.pad()}`);
    } else if (x >= 90 && x < 180) {
        console.log("Boa Tarde!!");
        console.log(`${((horas+6)%24).pad()}:${minutos.pad()}:${segundos.pad()}`);
    } else if (x >= 180 && x < 270) {
        console.log("Boa Noite!!");
        console.log(`${((horas+6)%24).pad()}:${minutos.pad()}:${segundos.pad()}`);
    } else if (x >= 270 && x < 360) {
        console.log("De Madrugada!!");
        console.log(`${((horas+6)%24).pad()}:${minutos.pad()}:${segundos.pad()}`);
    }
			
}
