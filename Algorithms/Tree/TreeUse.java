import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList; 

public class TreeUse{

	public static int countLeafNodes(TreeNode<Integer> root){
		if(root == null)
			return 0;
		if(root.children.size()==0)
			return 1;
		int count = 0;
		for(int i=0;i<root.children.size();i++){
			count += countLeafNodes(root.children.get(i));
		}
		return count;
	}

	public static void printAtK(TreeNode<Integer> root, int k){
		if(k<0)
			return;
		if(k==0){
			System.out.println(root.data);
			return;
		}
		for(int i=0;i<root.children.size();i++){
			printAtK(root.children.get(i),k-1);
		}
	}

	public static int findHeight(TreeNode root){
        if(root == null)
            return 0;
        
        int height = 1;
        height = 1+ Math.max(findHeight(root.left) , findHeight(root.right) );
        return height;
    }

	public static int heightOfTree(TreeNode<Integer> root){
		if(root == null)
		  return 0;

		int height = 1;
		for(int i=0;i<root.children.size();i++){
			height = 1+Math.max(height,heightOfTree(root.children.get(i)));

		}
		return height;
	}

	public static int numNodes(TreeNode<Integer> root){
		if(root == null)
			return 0;
		int count = 1;
		for(int i=0; i<root.children.size();i++){
			count += numNodes(root.children.get(i));
		}
		return count;
	}

	public static int largest(TreeNode<Integer> root){
		if(root == null)
			return Integer.MIN_VALUE;

		int ans = root.data;

		for(int i=0; i<root.children.size();i++){

			int childLargest = largest(root.children.get(i));
			if(childLargest>ans)
				ans = childLargest;
		}
		return ans;
	}

	public static TreeNode<Integer> takeInput(Scanner input){
		
		System.out.println("Enter Next Node Data");
		int n = input.nextInt();
		TreeNode<Integer> root = new TreeNode<Integer>(n);
		System.out.println("Enter no. of children for "+n);
		int childCount = input.nextInt();
		for(int i=0; i<childCount; i++){
			TreeNode<Integer> child = takeInput(input);
			root.children.add(child);
		}

		return root;
	}

	public static TreeNode<Integer> takeInputLevelWise(){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter root data");
		int rootData = input.nextInt();
		Queue<TreeNode<Integer>> pendingNodes  = new LinkedList<TreeNode<Integer>>();
		TreeNode<Integer> root = new TreeNode<Integer>(rootData);
		pendingNodes.add(root);
		while(!pendingNodes.isEmpty()){
			TreeNode<Integer> frontNode = pendingNodes.remove();
			System.out.println("Enter no. of children of "+frontNode.data);
			int numChildren = input.nextInt();
			for(int i=0;i<numChildren;i++){
				System.out.println("Enter "+ (i+1)+"th child of "+frontNode.data);
				int child = input.nextInt();
				TreeNode<Integer> childNode = new TreeNode<Integer>(child);
				frontNode.children.add(childNode);
				pendingNodes.add(childNode);
			}
		}
		return root;
	}

	public static void print(TreeNode<Integer> root){
		String s = root.data +" : ";

		for(int i=0;i<root.children.size();i++){
			s = s + root.children.get(i).data + " , ";
		}
		System.out.println(s);
		for(int i=0;i<root.children.size();i++){
			print(root.children.get(i));
		}
	}

	public static void main(String[] args) {
		// Scanner input = new Scanner(System.in);
		
		// TreeNode<Integer> root = takeInput(input);
		TreeNode<Integer> root = takeInputLevelWise();
		print(root);
		// System.out.println(numNodes(root));
		// System.out.println(largest(root));
		System.out.println("height = " +findHeight(root));
		printAtK(root,2);
		System.out.println("No. of leaf nodes = "+countLeafNodes(root));
	}
}