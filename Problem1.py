'''
1. Use drop duplicates to eliminate duplicates, keep as False to not store any value that has duplicate.
2. Use max to get the maximum out of the list. 
'''

import pandas as pd

def biggest_single_number(my_numbers: pd.DataFrame) -> pd.DataFrame:
    return pd.DataFrame((my_numbers.drop_duplicates(keep=False).max()),columns=['num'])