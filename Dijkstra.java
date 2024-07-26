import java.util.*;
class Dijkstra
{
    int max = Integer.MAX_VALUE;
    public Map<Integer,Integer> dijkstra(Map<Integer,Map<Integer, Integer>>graph,int source)
    {
        int n=graph.size();
        boolean[] visited = new boolean[n];
        int[] dist = new int[n];
        Arrays.fill(dist,max);
        dist[source]=0;
        
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->dist[a]-dist[b]);
        pq.offer(source);
        while(!pq.isEmpty())
        {
            int u = pq.poll();
            if(visited[u])
            continue;
            visited[u]=true;
            
            for(int v:graph.get(u).keySet())
            {
                int weight=graph.get(u).get(v);
                if(dist[v]>dist[u]+weight)
                {
                    dist[v]=dist[u]+weight;
                    pq.offer(v);
                }
            }
        }
        
        Map<Integer,Integer> result = new HashMap<>();
        for(int i=0;i<n;i++)
        {
            result.put(i,dist[i]);
        }
        return result;
    }
}