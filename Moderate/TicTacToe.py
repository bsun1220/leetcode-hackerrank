class TicTacToe:

    def __init__(self, n: int):
        
        self.Xrows = {}
        self.Xcols = {}
        self.Xdiag = {0:0, 1:0}
        self.Yrows = {}
        self.Ycols = {}
        self.Ydiag = {0:0, 1:0}
        
        self.n = n
        
        for i in range(n):
            self.Xrows[i] = 0
            self.Xcols[i] = 0
            self.Yrows[i] = 0
            self.Ycols[i] = 0

    def move(self, row: int, col: int, player: int) -> int:
        if(player == 1):
            self.Xrows[row] += 1
            self.Xcols[col] += 1
            if(row == col):
                self.Xdiag[0] += 1
            if(row + col == self.n - 1):
                self.Xdiag[1] += 1
            if(self.Xrows[row] == self.n or self.Xcols[col] == self.n):
                return 1
            if (self.Xdiag[0] == self.n or self.Xdiag[1] == self.n):
                return 1
        else:
            self.Yrows[row] += 1
            self.Ycols[col] += 1
            if(row == col):
                self.Ydiag[0] += 1
            if(row + col == self.n - 1):
                self.Ydiag[1] += 1
            if(self.Yrows[row] == self.n or self.Ycols[col] == self.n):
                return 2
            if (self.Ydiag[0] == self.n or self.Ydiag[1] == self.n):
                return 2
        return 0