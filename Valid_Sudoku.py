# Created by Aashish Adhikari at 7:42 AM 1/29/2021

'''
Time Complexity:
O(9) + O(9) + O(81) ~ O(1)

Space Complexity:
O(1)
'''

class Solution(object):
    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """

        hm_r = {}
        hm_c = {}
        hs = set()

        for idx in range(0,9):
            hm_r[idx] = set()
        for idxx in range(0,9):
            hm_c[idxx] = set()

        for row in range(0, 9, 3):

            for col in range(0, 9, 3):

                # iterate through the elements in the subbox

                for r in range(0,3):
                    for c in range(0,3):

                        elem = board[row+r][col +c]
                        if elem != ".":
                            if elem in hm_r[row+r] or elem in hm_c[col+c] or elem in hs:
                                return False

                            hs.add(elem)

                            hm_r[row+r].add(elem)
                            hm_c[col+c].add(elem)


                hs = set()


        return True





