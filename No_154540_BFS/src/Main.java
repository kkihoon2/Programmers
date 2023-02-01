import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution k = new Solution();
        String[] input = new String[]{"X591X","X1X5X","X231X", "1XXX1"};
        System.out.println(Arrays.toString(k.solution(input)));

    }
}
class Solution {
    public int[] solution(String[] maps) {

        int[]xMove ={-1,1,0,0};//상하좌우
        int[]yMove ={0,0,-1,1};
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        ArrayList<Integer>result = new ArrayList<>();
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                if(maps[i].charAt(j)!='X'&&!visited[i][j])
                {
                    result.add(bfs(i,j,visited,maps,xMove,yMove));
                }
            }
        }

        Collections.sort(result);
        int[] answer = new int[result.size()];
        for (int i = 0 ; i < result.size() ; i++) {
            answer[i] = result.get(i).intValue();}
        if(answer.length==0)
            return new int[]{-1};
        else return answer;
    }
    static int bfs(int x,int y,boolean[][]visited,String[] maps,int[] xMove,int[] yMove){
        Queue<int[]>queue = new LinkedList<>();
        visited[x][y]=true;
        int answer = Character.getNumericValue(maps[x].charAt(y)) ;
        queue.add(new int[]{x,y});
        while(!queue.isEmpty()){
            int[]now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int tempX = now[0]+xMove[i];
                int tempY = now[1]+yMove[i];
                if(tempX>=0&&tempY>=0&&tempX<visited.length&&tempY<visited[0].length&&!visited[tempX][tempY]&&maps[tempX].charAt(tempY)!='X')
                {
                    queue.add(new int[]{tempX,tempY});
                    visited[tempX][tempY]=true;
                    answer = answer + Character.getNumericValue(maps[tempX].charAt(tempY));
                }
            }
        }
        return answer;
    }
}