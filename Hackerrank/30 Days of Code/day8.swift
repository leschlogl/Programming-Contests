import Foundation

var qtyInput = Int(readLine()!)!

var i = 0
var map:[String:String] = [:]
while (i < qtyInput) {
    let line = (readLine()!).components(separatedBy: " ")
    let name = line[0]
    let phone = line[1]
    map[name] = phone
    i+=1
}


while let line = readLine() {
    if let phone = map[line] {
        print("\(line)=\(phone)")
    } else {
        print("Not found")
    }
}
