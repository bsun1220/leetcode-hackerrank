class WordLadder:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        if endWord not in wordList:
            return 0
        
        graph = {}
        
        #set graph structure 
        graph[beginWord] = set()
        graph[endWord] = set()
        for word in wordList:
            graph[word] = set()
            if self.findDiff(beginWord, word):
                graph[word].add(beginWord)
                graph[beginWord].add(word)
            if self.findDiff(endWord, word):
                graph[word].add(endWord)
                graph[endWord].add(word)
        
        for i in range(len(wordList)):
            for k in range(i, len(wordList)):
                if self.findDiff(wordList[i], wordList[k]):
                    graph[wordList[i]].add(wordList[k])
                    graph[wordList[k]].add(wordList[i])
            
        queue = deque()
        visited = set()
        queue.append(beginWord)
        visited.add(beginWord)
        
        index = 1
        while len(queue) != 0:
            size = len(queue)
            for __ in range(size):
                word = queue.popleft()
                if word == endWord:
                    return index
                
                for neighbor in graph[word]:
                    if neighbor not in visited:
                        visited.add(neighbor)
                        queue.append(neighbor)
            index += 1
        
        return 0
            
    
    def findDiff(self, word1, word2):
        total = 0
        for i in range(len(word1)):
            charA = word1[i]
            charB = word2[i]
            if charA != charB:
                total += 1
            if total > 1:
                return False
        return True