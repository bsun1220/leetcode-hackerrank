class Solution:

    def __init__(self, w: List[int]):
        sumList = sum(w)
        
        weighted = [0 for x in range(len(w))]
        for index, value in enumerate(w):
            weighted[index] = w[index]/sumList + weighted[index - 1] if index != 0 else w[0]/sumList
        
        self.weighted = weighted
        print(weighted)
                

    def pickIndex(self) -> int:
        randomIndex = random.random()
        print(randomIndex)
        left, right = 0, len(self.weighted)
        while(left < right):
            mid = (left + right) // 2
            if self.weighted[mid] < randomIndex:
                left = mid + 1
            else:
                right = mid
        return left