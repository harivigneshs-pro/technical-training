import java.util.*;

class Node {
    int data;
    ArrayList<Node> children;

    Node(int data) {
        this.data = data;
        children = new ArrayList<>();
    }
}

public class GenericTree {

    public static Node construct(int[] arr) {

        Stack<Node> st = new Stack<>();
        Node root = null;

        for(int i = 0; i < arr.length; i++) {

            if(arr[i] == -1) {
                st.pop();
            }
            else {

                Node node = new Node(arr[i]);

                if(st.size() > 0) {
                    st.peek().children.add(node);
                }
                else {
                    root = node;
                }

                st.push(node);
            }
        }

        return root;
    }

    public static void display(Node node) {

        String str = node.data + " -> ";

        for(Node child : node.children) {
            str += child.data + " ";
        }

        System.out.println(str);

        for(Node child : node.children) {
            display(child);
        }
    }
    public static int size(Node node) {
    int s = 1; 
     for (Node child : node.children) {
        s += size(child);
    }
    return s;
}
 public static int maximum(Node node,int max) {
    if(node.data>max) {
        max = node.data;
    }
     for (Node child :node.children) {
        max =maximum(child,max);
    }
    return max;
   
}
public static int height(Node node){//faith -f(10)-expectation-maxmimum height(f(20),f(30),f(40))
    int h = -1; 
     for (Node child : node.children) {
        int ch=height(child);
        if(ch > h) {
            h=ch;
        }
    }
    h+=1;
    return h;
}
//reverse the linked list using recursion


    public static void main(String[] args) {

        int[] arr = {10,20,50,-1,60,-1,-1,30,70,-1,80,-1,-1,40,-1,-1};

        Node root = construct(arr);
        System.out.println(maximum(root, Integer.MIN_VALUE));

        System.out.println(size(root));
        display(root);
    }
}