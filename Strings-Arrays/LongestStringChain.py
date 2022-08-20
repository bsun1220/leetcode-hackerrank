class StringChain:
    def longestStrChain(self, words: List[str]) -> int:
        maxLength = 1
        self.set = set()
        
        self.list = []
        for key, val in enumerate(words):
            self.list.append((len(val), val))
        
        self.list.sort()
        
        for key,val in enumerate(self.list):
            words[key] = val[1]
        
        for i in range(len(words) -1, -1, -1):
            maxLength = max(self.recurse(words[i], i, words, 1), maxLength)
        
        return maxLength
    
    def recurse(self, current_word, index, words, current_sum):
        if current_word in self.set:
            return 0
        self.set.add(current_word)
        
        maxLength = current_sum
        for i in range(len(current_word)):
            new_word = current_word[0:i] + current_word[i + 1:]
            found = self.search(new_word, index, words)
            if found == -1:
                continue
            newValue = self.recurse(new_word, found, words, current_sum + 1)
            maxLength = max(newValue, maxLength)
            
        return maxLength
    
    def search(self, findingWord, index, words):
        if index < 0:
            return -1
        
        for i in range(index - 1, -1, -1):
            if words[i] == findingWord:
                return i
        
        return -1