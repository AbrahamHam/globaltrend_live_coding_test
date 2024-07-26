class Knapsack01
{
    public int knapsack(int[] weights,int[] values, int capacity)
    {
        int dp[][] = new int[weights.length +1][capacity+1];
        for(int i=1;i<=weights.length;i++)
        {
            for(int w=1;w<=capacity;w++)
            {
                if(weights[i-1]>w)
                {
                    dp[i][w]=dp[i-1][w];
                }
                else
                {
                    dp[i][w]=Math.max(dp[i-1][w],values[i-1]+dp[i-1][w-weights[i-1]]);
                }
            }
        }
        return dp[weights.length][capacity];
    }
}