### Question :
* Given a square matrix of integers m , 
your task is to rearrange its numbers in the following way:

  * **First**, sort its values in ascending order of how frequently the number occurs in m
    * in case of a tie, sort the equally frequent numbers by their values, in ascending order.
  * **Second**, place the sorted numbers diagonally, starting from the bottom right corner.
    * the diagonal should point from left corner to right corner.
* #### input
  * m = [[1,4,-2],[-2,3,4],[3,1,3]]
* #### output
  * [[3,3,4],[3,4,1],[1,-2,-2]]