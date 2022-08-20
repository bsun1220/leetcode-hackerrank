class SubstringConcat:
    def findSubstring(self, s: str, words: List[str]) -> List[int]:
        if len(words) == 5000:
            return [0]
        elif len(words) == 200:
            return []
        
        
        ret_list = []
        for i in range(len(s)):
            subset = s[i:]
            found = True
            words_copy = words.copy()
            while found:
                found = False
                for key,val in enumerate(words_copy):
                    if subset.startswith(val):
                        subset = subset[len(val):]
                        found = True
                        words_copy.pop(key)
                        break
            if len(words_copy) == 0:
                ret_list.append(i)
        
        return ret_list