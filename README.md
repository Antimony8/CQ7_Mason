# Time Complexity
The time complexity is O(n^2) where n is the size of the input array. This is due to the nested loops, where the outer loop iterates over each element of the array, and the inner loop, in the worst case, traverses the entire sorted portion of the array for each element.
# Space Complexity
The space complexity of the Insertion Sort implementation is O(1).The space needed is determined by the input, and the space required for variables such as key, j, and shift. As the input size increases, the amount of additional space remains constant.
# Dynmaic Programming Recursive Definition
Let f(i,m) represent the number of to spend money "m" using the first "i" flavors. The base case is f(0,m) = 0 for m > 0, f(i,0) = 1 for all i, and f(0,0) = 2
The recursive forumal is:
**f(i,m) = f(i-1, m) + f(i-1, m-cost[i])**
