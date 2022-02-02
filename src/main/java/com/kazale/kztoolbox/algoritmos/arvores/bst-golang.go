type Node struct {
	value int
	left  *Node
	right *Node
}

type BinarySearchTree struct {
	root *Node
}

// https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
func Search(root *Node, value int) *Node {
	if root == nil || root.value == value {
		return root
	}

	if root.value < value {
		return Search(root.right, value)
	}

	return Search(root.left, value)
}

// https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
func Insert(root *Node, value int) *Node {
	// if tree is empty return a new node
	if root == nil {
		node := Node{value: value}
		root = &node
		return root
	}

	// recur down the tree until find the place to add the new node
	if value < root.value {
		root.left = Insert(root.left, value)
	} else if value > root.value {
		root.right = Insert(root.right, value)
	}

	return root
}

// https://www.geeksforgeeks.org/binary-search-tree-set-2-delete/
func Delete(root *Node, value int) *Node {
	if root == nil {
		return root
	}

	// recur down the tree
	if value < root.value {
		root.left = Delete(root.left, value)
	} else if value > root.value {
		root.right = Delete(root.right, value)
	} else {
		// node with only one child or no child
		if root.left == nil {
			return root.right
		} else if root.right == nil {
			return root.left
		}

		// node with two children, get the smallest in the right subtree
		root.value = minValue(root.right)

		// delete the inorder successor
		root.right = Delete(root.right, root.value)
	}

	return root
}

func minValue(root *Node) int {
	minValue := root.value
	for root.left != nil {
		minValue = root.left.value
		root = root.left
	}
	return minValue
}

///////////// Tests 

import (
	"testing"
)

func TestSearchNonExistingValue(t *testing.T) {
	bst := getSampleBST()
	node := Search(bst.root, 25)
	if node != nil {
		t.Fatalf("expected node to be nil, but got: %d", node.value)
	}
}

func TestSearchRootValue(t *testing.T) {
	bst := getSampleBST()
	node := Search(bst.root, 50)
	if node == nil {
		t.Fatalf("expected node to be 50, but got: nil")
	}
	if node.value != 50 {
		t.Fatalf("expected node to be 50, but got: %d", node.value)
	}
}

func TestSearchExistingValues(t *testing.T) {
	tests := []struct {
		name      string
		value     int
		expected  int
	}{
		{
			name:     "should find value 30",
			value:    30,
			expected: 30,
		},
		{
			name:     "should find value 70",
			value:    70,
			expected: 70,
		},
		{
			name:     "should find value 20",
			value:    20,
			expected: 20,
		},
		{
			name:     "should find value 40",
			value:    40,
			expected: 40,
		},
		{
			name:     "should find value 60",
			value:    60,
			expected: 60,
		},
		{
			name:     "should find value 80",
			value:    80,
			expected: 80,
		},
	}

	bst := getSampleBST()
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			node := Search(bst.root, tt.value)
			if node == nil {
				t.Fatalf("expected node to be %d, but got: nil", tt.value)
			}
			if node.value != tt.expected {
				t.Fatalf("expected node to be %d, but got: %d", tt.value, node.value)
			}
		})
	}
}

func TestInsertRootElement(t *testing.T) {
	bst := BinarySearchTree{}
	root := Insert(bst.root, 25)
	if root == nil {
		t.Fatalf("expected root not to be nil")
	}
	if root.value != 25 {
		t.Fatalf("expected root to be 25, but got: %d", root.value)
	}
}

func TestInsertBuildTwoLevelsBST(t *testing.T) {
	bst := BinarySearchTree{}
	bst.root = Insert(bst.root, 50)
	bst.root = Insert(bst.root, 30)
	bst.root = Insert(bst.root, 70)

	if bst.root == nil {
		t.Fatalf("expected root not to be nil")
	}
	if bst.root.left.value != 30 {
		t.Fatalf("expected node value to be 30, but got: %d", bst.root.left.value)
	}
	if bst.root.right.value != 70 {
		t.Fatalf("expected node value to be 70, but got: %d", bst.root.right.value)
	}
}

func TestInsertBuildThreeLevelsBST(t *testing.T) {
	bst := BinarySearchTree{}
	bst.root = Insert(bst.root, 50)
	bst.root = Insert(bst.root, 30)
	bst.root = Insert(bst.root, 20)
	bst.root = Insert(bst.root, 40)

	if bst.root == nil {
		t.Fatalf("expected root not to be nil")
	}
	if bst.root.left.left.value != 20 {
		t.Fatalf("expected node value to be 20, but got: %d", bst.root.left.left.value)
	}
	if bst.root.left.right.value != 40 {
		t.Fatalf("expected node value to be 40, but got: %d", bst.root.left.right.value)
	}
}

func TestDeleteWhenNodeIsTheLeaf(t *testing.T) {
	bst := getSampleBST()
	bst.root = Delete(bst.root, 20)

	if bst.root == nil {
		t.Fatalf("expected root not to be nil")
	}
	if bst.root.left.left != nil {
		t.Fatalf("expected node value 30 to be nil")
	}
}

func TestDeleteWhenNodeHasOnlyOneChild(t *testing.T) {
	bst := getSampleBST()
	bst.root = Delete(bst.root, 20)
	bst.root = Delete(bst.root, 30)

	if bst.root == nil {
		t.Fatalf("expected root not to be nil")
	}
	if bst.root.left.value != 40 && bst.root.left.left != nil && bst.root.left.right != nil {
		t.Fatalf("expected node with value 40 and no children")
	}
}

func TestDeleteWhenNodeHasTwoChildren(t *testing.T) {
	bst := getSampleBST()
	bst.root = Delete(bst.root, 20)
	bst.root = Delete(bst.root, 30)
	bst.root = Delete(bst.root, 50)

	if bst.root == nil {
		t.Fatalf("expected root not to be nil")
	}
	if bst.root.value != 60 || bst.root.left.value != 40 || bst.root.right.value != 70 || bst.root.right.right.value != 80 {
		t.Fatalf("expected treewith values 40 60 70 80")
	}
}

func getSampleBST() BinarySearchTree {
	node80 := Node{value: 80}
	node60 := Node{value: 60}
	node70 := Node{value: 70, left: &node60, right: &node80}
	node40 := Node{value: 40}
	node20 := Node{value: 20}
	node30 := Node{value: 30, left: &node20, right: &node40}
	root := Node{value: 50, left: &node30, right: &node70}
	return BinarySearchTree{root: &root}
}
