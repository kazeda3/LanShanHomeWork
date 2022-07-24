package 蓝山作业.第二周作业.算法;

import java.util.*;

public class LuoGu1443 {
    static int[][] map;
    static boolean[][] visit;
    static int[][] move = {{1,2},{2,1},{-1,-2},{-2,-1},{1,-2},{-2,1},{-1,2},{2,-1}};
    static int n,m;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();
        map = new int[n][m];
        visit = new boolean[n][m];
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                map[i][j]=-1;
            }
        }
        BFS(x-1,y-1);
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static void BFS(int x,int y) {
        Queue<Node> queue = new LinkedList<Node>();
        Node start = new Node(x,y,0);
        queue.offer(start);
        map[x][y]=start.step;
        visit[x][y]=true;
        while(!queue.isEmpty()) {
            Node next = queue.poll();
            for(int i=0;i<8;i++) {
                x=next.x+move[i][0];
                y=next.y+move[i][1];
                if(x>=0 && x<n && y>=0 && y<m && !visit[x][y]) {
                    queue.offer(new Node(x,y,next.step+1));
                    map[x][y]=next.step+1;
                    visit[x][y]=true;
                }
            }
        }
    }
}

class Node{
    int x;
    int y;
    int step;
    Node(int x,int y,int step){
        this.x=x;
        this.y=y;
        this.step=step;
    }
}

