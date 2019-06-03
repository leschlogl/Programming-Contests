

class Solution {
    var arr:[Character] = []
    var queue:[Character] = []
    
    func pushCharacter(ch: Character) {
        arr.append(ch)
    }
    
    func enqueueCharacter(ch: Character) {
        queue.insert(ch, at: 0)
    }
    
    func popCharacter() -> Character{
        return arr.popLast()!
    }
    
    func dequeueCharacter() -> Character {
        return queue.popLast()!
    }
}


