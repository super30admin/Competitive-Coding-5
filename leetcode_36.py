#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sun Mar 15 00:00:00 2026

@author: rishigoswamy

    LeetCode 36: Valid Sudoku
    Link: https://leetcode.com/problems/valid-sudoku/

    Problem:
    Determine if a 9x9 Sudoku board is valid. Only filled cells need to be validated
    according to the following rules:
    - Each row must contain digits 1-9 without repetition.
    - Each column must contain digits 1-9 without repetition.
    - Each of the nine 3x3 sub-boxes must contain digits 1-9 without repetition.

    Approach:
    Two passes. First pass checks rows and columns simultaneously using two sets
    per index i. Second pass checks each 3x3 box by computing start/end indices
    from the box's row/column position.

    1️⃣ For each i in 0-8: scan row i and column i with separate sets; return False on duplicate.
    2️⃣ For each 3x3 box (i, j in 0-2): compute startI/endI/startJ/endJ, scan with a set.
    3️⃣ Skip '.' cells in all checks.

    // Time Complexity : O(1)
        Board is always 9x9 = 81 cells — constant work.
    // Space Complexity : O(1)
        Sets hold at most 9 elements each — constant space.

"""

from typing import List


class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        for i in range(9):
            rowCheck = set()
            colCheck = set()
            for j in range(9):
                if board[i][j] != ".":
                    if board[i][j] in rowCheck:
                        return False
                    rowCheck.add(board[i][j])
                if board[j][i] != ".":
                    if board[j][i] in colCheck:
                        return False
                    colCheck.add(board[j][i])

        # Check all 3x3 sub-boxes
        for i in range(3):
            for j in range(3):
                startI = i * 3
                endI = i * 3 + 3
                startJ = j * 3
                endJ = j * 3 + 3

                hSet = set()
                for r in range(startI, endI):
                    for c in range(startJ, endJ):
                        if board[r][c] != "." and board[r][c] in hSet:
                            return False
                        hSet.add(board[r][c])

        return True
