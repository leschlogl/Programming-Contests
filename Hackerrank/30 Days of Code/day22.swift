

func getHeight(root: Node?) -> Int {
    if root == nil {
        return -1
    } else {
        let leftDepth = getHeight(root: root?.left)
        let rightDepth = getHeight(root: root?.right)
        if leftDepth > rightDepth {
            return leftDepth + 1
        } else {
            return rightDepth + 1
        }
    }
} // End of getHeight function
