/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solution;
import java.util.*;
/**
 *
 * @author Welcome
 */
import java.util.*;
import java.io.*;
class Node
{
	public int key;
	public Node left;
	public Node right;
}
public class Solution {
             static Node newNode(int key)
                {
                        Node temp = new Node();
                        temp.key = key;
                        temp.left = temp.right = null;
                        return (temp);
                }


	 static void printPathsUtil(Node curr_node, int sum, int sum_so_far, ArrayList<Integer> path)
	{
		if (curr_node == null)
		{
			return;
		}

		// add the current node's value
		sum_so_far += curr_node.key;

		// add the value to path
		path.add(curr_node.key);

		// print the required path
		if (sum_so_far == sum)
		{
			System.out.print("[");
			for (int i = 0; i < path.size(); i++)
			{
				System.out.print(path.get(i));
				System.out.print(",");
			}
            System.out.print("]");
            System.out.print("\n");
			System.out.print("\n");
		}
		// if left child exists
		if (curr_node.left != null)
		{
			printPathsUtil(curr_node.left, sum, sum_so_far, path);
		}

		// if right child exists
		if (curr_node.right != null)
		{
			printPathsUtil(curr_node.right, sum, sum_so_far, path);
		}
		path.remove(path.size() - 1);
	}
	 static void printPaths(Node root, int sum)
	{
		ArrayList<Integer> path = new ArrayList<Integer>();
		printPathsUtil(root, sum, 0, path);
	}

	// Driver program
	public static void  main(String[] args)
	{

		Node root = newNode(5);
		root.left = newNode(4);
		root.right = newNode(8);

		root.left.left = newNode(11);
		root.left.left.left = newNode(7);
                root.left.left.right = newNode(2);
        
		root.right.left = newNode(13);
		root.right.right = newNode(4);
		root.right.right.left = newNode(5);
		root.right.right.right = newNode(1);

		int sum = 22;

		printPaths(root, sum);

	}
    
}
