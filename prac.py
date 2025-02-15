def inorder_traversal(root):
    if root:
        inorder_traversal(root.left)  # Visit left subtree
        print(root.val)                # Visit root
        inorder_traversal(root.right) # Visit right subtree

inorder_traversal([1,2,3,4,5])