#User function Template for python3
class Solution:
    def shortestDistance(self, s, word1, word2):
        min_dist = float('inf')
        index1, index2 = -1, -1

        for i in range(len(s)):
            if s[i] == word1:
                index1 = i
            if s[i] == word2:
                index2 = i

            if index1 != -1 and index2 != -1:
                min_dist = min(min_dist, abs(index1 - index2))

        return min_dist
#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__':
    T=int(input())
    for i in range(T):
        n = int(input())
        s = list(map(str,input().split()))
        word1 = input()
        word2 = input()
        ob = Solution()
        ans = ob.shortestDistance(s, word1, word2)
        print(ans)

# } Driver Code Ends
