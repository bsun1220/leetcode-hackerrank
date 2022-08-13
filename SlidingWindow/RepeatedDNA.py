class RepeatedDna:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        ret_list = set()
        prev_tracker = set()
        if len(s) < 10:
            return list(ret_list)
        
        for i in range(len(s) - 9):
            sub = s[i:i+10]
            if sub in prev_tracker:
                ret_list.add(sub)
            else:
                prev_tracker.add(sub)
            
        
        
        return list(ret_list)