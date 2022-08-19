class GameOfLife:
    def gameOfLife(self, board: List[List[int]]) -> None:
        new_b = [[0 for __ in range(len(board[0]))] for __ in range(len(board))]
        
        for row in range(len(board)):
            for col in range(len(board[0])):
                freq_ones = self.findNeighbor(board, row, col)
                if board[row][col] == 1 and freq_ones < 4 and freq_ones > 1:
                    new_b[row][col] = 1
                elif board[row][col] == 0 and freq_ones == 3:
                    new_b[row][col] = 1
                    
        for row in range(len(board)):
            for col in range(len(board[0])):
                board[row][col] = new_b[row][col]
    
    def findNeighbor(self, board, row, col):
        freq_ones = 0
        DIR = [(0, 1), (0, -1), (-1, 0), (1, 0), (-1, -1), (1, -1), (-1, 1), (1, 1)]
        for directions in DIR:
            newRow = row + directions[0]
            newCol = col + directions[1]
            value = self.findValue(board, newRow, newCol)
            if value == 1:
                freq_ones += 1
        
        return freq_ones
        
    
    def findValue(self, board, row, col):
        if row < 0 or row >= len(board) or col < 0 or col >= len(board[0]):
            return -1
        return board[row][col]