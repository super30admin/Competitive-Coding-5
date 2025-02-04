# tc O(n), sc O(n).
if not root:
    return []

queue = deque([root])

LEFT_TO_RIGHT = True
zigzagLevelOrder = []

while queue:
    curr_level = deque()
    for _ in range(len(queue)):
        node = queue.popleft()
        if LEFT_TO_RIGHT:
            curr_level.append(node.val)
        else:
            curr_level.appendleft(node.val)
        if node.left:
            queue.append(node.left)
        if node.right:
            queue.append(node.right)
    
    zigzagLevelOrder.append(list(curr_level))
    LEFT_TO_RIGHT = not LEFT_TO_RIGHT
    
return zigzagLevelOrder