

func insert(head: Node?, data: Int!) -> Node? {
    if head == nil {
        return Node(data: data)
    } else if head!.next == nil {
        head!.next = Node(data: data)
    } else {
        insert(head: head!.next, data: data)
    }
    
    return head
}


