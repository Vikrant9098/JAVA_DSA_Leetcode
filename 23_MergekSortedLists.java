# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

import heapq

class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[Optional[ListNode]]
        :rtype: Optional[ListNode]
        """
        # if the list of lists is empty, return None
        if not lists:
            return None
        
        # heap to store (node value, index, node) for comparison
        heap = []
        
        # add the first node of each non-empty list to the heap
        for i, node in enumerate(lists):
            if node:
                heapq.heappush(heap, (node.val, i, node))
        
        # dummy node to start the merged list
        dummy = ListNode(0)
        tail = dummy  # tail points to last node in merged list
        
        # while heap is not empty
        while heap:
            # get the smallest node from heap
            val, i, node = heapq.heappop(heap)
            
            # attach it to the merged list
            tail.next = node
            tail = tail.next  # move tail forward
            
            # if node has next, push it into heap
            if node.next:
                heapq.heappush(heap, (node.next.val, i, node.next))
        
        # return merged list starting from dummy.next
        return dummy.next
