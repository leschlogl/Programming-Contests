import Foundation

func matchesForRegexInText(regex: String, text: String) -> [String] {
    
    do {
        let regex = try NSRegularExpression(pattern: regex, options: [])
        let nsString = text as NSString
        let results = regex.matches(in: text,
                                    options: [], range: NSMakeRange(0, nsString.length))
        return results.map { nsString.substring(with: $0.range)}
    } catch let _ as NSError {
        return []
    }
}



guard let N = Int((readLine()?.trimmingCharacters(in: .whitespacesAndNewlines))!)
    else { fatalError("Bad input") }

var arr:[String] = []

for NItr in 1...N {
    guard let firstNameEmailIDTemp = readLine() else { fatalError("Bad input") }
    let firstNameEmailID = firstNameEmailIDTemp.split(separator: " ").map{ String($0) }
    
    let firstName = firstNameEmailID[0]
    let emailID = firstNameEmailID[1]
    if firstName.count <= 20 &&
        matchesForRegexInText(regex: "[a-z0-9.]*@gmail.com{1,50}", text: emailID).count > 0 {
        arr.append(firstName)
    }
}

arr.sort()

for name in arr {
    print(name)
}
