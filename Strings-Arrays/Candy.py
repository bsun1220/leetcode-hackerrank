class Candy:
    def candy(self, ratings: List[int]) -> int:
        total = 0
        candy_dist = [1 for _ in range(len(ratings))]
        
        for i in range(1, len(ratings)):
            if ratings[i] > ratings[i - 1]:
                candy_dist[i] = max(candy_dist[i], candy_dist[i - 1] + 1)
        
        for i in range(len(ratings) - 2, -1, -1):
            if ratings[i] > ratings[i + 1]:
                candy_dist[i] = max(candy_dist[i], candy_dist[i + 1] + 1)
        
        for val in candy_dist:
            total += val
        
        return total