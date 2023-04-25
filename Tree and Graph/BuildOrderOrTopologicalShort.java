import java.util.ArrayList;
import java.util.HashMap;

class Node {
    char data;
    ArrayList<Node> nodeAdj = new ArrayList<Node>(0);

    public Node(char data) {
        this.data = data;
    }
}

class TopologicalSort {
    boolean[] visited;

    void sorting(ArrayList<Node> nodes) {
        this.visited = new boolean[26];
        for(int i = 0; i < this.visited.length; i++) {
            visited[i] = false;
        }
        char order[] = new char[nodes.size()];
        int pointer = order.length - 1;
        for(int i = 0;  i < nodes.size(); i++) {
            Node curNode = nodes.get(i);
            int curChar = curNode.data;
            int index = curChar % 26; 
            if (!this.visited[index]) {
                ArrayList<Character> justVisited = new ArrayList<Character>(0);
                justVisited = this.dfs(curNode);

                for(int j = 0; j < justVisited.size(); j++) {
                    order[pointer] = justVisited.get(j);
                    pointer--;
                }
            }
        }
        this.printSort(order);
    }

    ArrayList<Character> dfs(Node curNode) {
        int visitingIndex = curNode.data;
        this.visited[visitingIndex % 26] = true;
        ArrayList<Character> visiting = new ArrayList<Character>(0);
        for(int i = 0; i < curNode.nodeAdj.size(); i++) {
            Node curAdjNode = curNode.nodeAdj.get(i);
            int curAdjNodeIndex = curAdjNode.data;
            if (!this.visited[curAdjNodeIndex % 26]) {
                ArrayList<Character> temp = this.dfs(curAdjNode);
                for(int j = 0; j < temp.size(); j++) {
                    visiting.add(temp.get(j));
                }
            }
        }
        visiting.add(curNode.data);
        return visiting;
    }

    void printSort(char[] order) {
        for(int i = 0; i < order.length; i++) {
            System.out.print(order[i] + "->");
        }
        System.out.println("");
    }

}



class BuildTheGraph {

    ArrayList<Node> nodes;

    void seeding() {
        nodes = new ArrayList<Node>(0);
        String s = "ABCDEFGHIJKLM";
        for(int i = 0; i < s.length(); i++) {
            nodes.add(i, new Node(s.charAt(i)));
        }
        
        char ch[][] = {{'D'}, {'D'}, {'A', 'B'}, {'H', 'G'}, {'A', 'D', 'F'}, {'K', 'J'}, {'I'}, {'I', 'J'}, {'L'}, {'L', 'M'}, {'J'}, {}, {}};
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        hm.put('A', 0);
        hm.put('B', 1);
        hm.put('C', 2);
        hm.put('D',3);
        hm.put('E', 4);
        hm.put('F', 5);
        hm.put('G', 6);
        hm.put('H', 7);
        hm.put('I', 8);
        hm.put('J', 9);
        hm.put('K', 10);
        hm.put('L', 11);
        hm.put('M', 12);

        for(int i = 0; i < nodes.size(); i++) {
            Node currNode = nodes.get(i);
            
            for(int j = 0; j < ch[i].length; j++) {
                currNode.nodeAdj.add(nodes.get(hm.get(ch[i][j])));
            }
        }
        this.printNode();
        TopologicalSort topoObj = new TopologicalSort();
        topoObj.sorting(nodes);
    }

    void printNode() {
        System.out.println("The Graph: ");
        for(int i = 0; i < nodes.size(); i++) {
            System.out.print(nodes.get(i).data + " -> ");
                for(int j = 0; j < nodes.get(i).nodeAdj.size(); j++) {
                    System.out.print(nodes.get(i).nodeAdj.get(j).data + ", ");
                }
                System.out.println("");
        }
    }
}

public class BuildOrderOrTopologicalShort {
    public static void main(String[] args) {
        BuildTheGraph obj = new BuildTheGraph();
        obj.seeding();
    }
    
}
