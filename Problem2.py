# 690. Employee Importance
"""
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""

class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        Map = {}
        result = 0

        for emp in employees:
            Map[emp.id] = emp

        def helper(id):
            nonlocal result
            emp_obj = Map[id]
            imp = emp_obj.importance
            result += imp

            for sub_id in emp_obj.subordinates:
                helper(sub_id)

        helper(id)
        return result


        