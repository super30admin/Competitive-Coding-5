'''
1. We need to find those cinemas that have odd id and the description doesnt contain boring. 
2. So we negate the result of filter that gives us boring movies
3. sort using rating column in descending order
'''

import pandas as pd

def not_boring_movies(cinema: pd.DataFrame) -> pd.DataFrame:
    return cinema[(cinema['id']%2!=0) &  ~(cinema['description'].str.contains('boring'))].sort_values('rating',ascending=False)