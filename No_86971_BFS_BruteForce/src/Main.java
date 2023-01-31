import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        Solution k = new Solution();
        System.out.println(k.solution(9,new int[][]{
                {1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}
        }));
    }
}
class Solution {
    static int[][]matrix;
    public int solution(int n, int[][] wires) {
        int answer = n ;
        matrix = new int[n+1][n+1];
        for(int i = 0 ; i<wires.length;i++)
        {
            int x = wires[i][0];
            int y = wires[i][1];
            matrix[x][y]=1;
            matrix[y][x]=1;
        }

        for(int i = 0 ; i < wires.length;i++){
            boolean[] visited=new boolean[n+1];
            int x = wires[i][0];
            int y = wires[i][1];
            matrix[x][y]=0;
            matrix[y][x]=0;
            answer = Math.min(answer,bfs(i+1,visited,n));
            matrix[x][y]=1;
            matrix[y][x]=1;
        }


        return answer;
    }
    static int bfs(int yVal,boolean[]visited,int n){
        Queue<Integer>queue = new LinkedList<>();
        int cnt =1;
        queue.add(yVal);
        visited[yVal]=true;
        while(!queue.isEmpty())
        {
            int cur = queue.poll();
            for(int i= 0;i<=n;i++)
            {
                if(matrix[cur][i]==1&&!visited[i])
                {
                    queue.add(i);
                    cnt++;
                    visited[i]=true;
                }
            }
        }
        return (int)Math.abs(n-2*cnt);
    }
}