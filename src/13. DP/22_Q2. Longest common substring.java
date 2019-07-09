/*
draw the matrix picture!!!!!!!

             j
source:    s t u d e n t
         0 1 2 3 4 5 6 7
       0 0 0 0 0 ...
     e 1 0
     f 2 0     
     d 3 .      m[i][j]
     e 4 .
     n 5 .
m[i][j]: i = how many rows, and row index
         j = how many cols, and column index
*/

public String longestCommon(String source, String target) {
  int[][] m = new int[target.length()+1][source.length()+1];
	for(int i = 0; i < m.length; i++) {
	  m[i][0] = 0;
  }
	for(int j = 1; j < m[0].length; j++) {
	  m[0][j] = 0;
	}
	
	int start = 0;
	int longest = 0;
	for(int i = 1; i < m.length; i++) {
	  for(int j = 1; j < m[0].length; j++) {
		  if(target.charAt(i-1) == source.charAt(j-1)) {
			  m[i][j] = m[i-1][j-1] + 1;
				if(m[i][j] > longest) {
				  longest = m[i][j];
					start = i - longest;
				}
			} else {
			  m[i][j] = 0;
			}
		}
	}
	return target.substring(start, start+longest);
}

