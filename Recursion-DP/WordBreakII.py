class WordBreak2:
    def wordBreak(self, s: str, wordDict: List[str]) -> List[str]:
        self.set = set(wordDict)
        self.l = []
        self.backtrack(s, [])
        return self.l
        
    
    def backtrack(self, s, currentList):
        if len(s) == 0:
            self.l.append(" ".join(currentList))
        else:
            for word in self.set:
                if not s.startswith(word):
                    continue
                rest = s[len(word):]
                currentList.append(word)
                self.backtrack(rest, currentList)
                currentList.pop()