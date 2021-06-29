class Solution(object):
    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """
        row_dict_list,col_dict_list, box_dict_list = list(),list(),list()
        for i in xrange(9):
            row_dict_list.append({})
            col_dict_list.append({})
            box_dict_list.append({})
        
        for i,row in enumerate(board):
            for j,el in enumerate(board[i]):
                num = el
                if num != '.':
                    num = int(num)
                    box_index = (i//3)*3+j//3
                    row_dict_list[i][el] = row_dict_list[i].get(el,0)+1
                    col_dict_list[j][el] = col_dict_list[j].get(el,0)+1
                    box_dict_list[box_index][el] = box_dict_list[box_index].get(el,0)+1
                    if row_dict_list[i][el] >1 or col_dict_list[j][el] > 1 or box_dict_list[box_index][el] > 1:
                        return False

        return True
                