class RandomListCopy:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        if head is None:
            return None
        
        ptr = head
        
        while ptr is not None:
            temp = ptr.next
            ptr.next = Node(ptr.val)
            ptr.next.next = temp
            ptr = ptr.next
            if ptr is not None:
                ptr = ptr.next
        
        ptr = head
        while ptr is not None and ptr.next is not None:
            ptr.next.random = ptr.random.next if ptr.random is not None else None
            ptr = ptr.next
            if ptr is not None:
                ptr = ptr.next
        
        head_ptr = head.next
        ptr = head_ptr
        while ptr.next is not None:
            ptr.next = ptr.next.next
            ptr = ptr.next
        
        return head_ptr