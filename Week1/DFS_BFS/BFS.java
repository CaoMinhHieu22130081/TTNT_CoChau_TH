package DFS_BFS;

import java.util.*;

public class BFS {
	public void bfsUsingQueue(Node initial, int goal) {
		Node s = initial;
		if (s.state == goal) {
			System.out.println("Path: "+s.state);
		} else {
			Queue<Node> queue = new LinkedList<Node>();
			queue.add(s);
			while (queue != null) {
				Node p = queue.remove();
				System.out.println(p.state);
				p.visited = true;
				if(p.state==goal){
					System.out.println("Ve dich roi");
					printPath(p, initial);
					break;
				}
					else {
						List<Node> l = p.getNeighbour();
						System.out.println("size l "+ l.size());
						for (int j = 0; j < l.size(); j++) {
							if (l.get(j).visited == false){
								l.get(j).parent=p;
								queue.add(l.get(j));
							System.out.println("node con "+l.get(j).state);
							}
						}
					}
				}
			}
		}
	

	private void printPath(Node node, Node initial) {
		String s = "";
		while (node != initial) {
//			System.out.println("tets "+ node.state);
			s = node.state + " " + s;
			node = node.parent;
		}
		System.out.println("Path: " + initial.state + " " + s);
	}
}