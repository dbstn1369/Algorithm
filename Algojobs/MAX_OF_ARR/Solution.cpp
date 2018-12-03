#include <stdio.h>

int main() {

    //Please Enter Your Code Here
    int array[10][10];
    int max = 0;
    int temp_x;
    int temp_y;
    for(int i = 1; i <10; i++){
      for(int j = 1; j < 10; j++){
        scanf("%d", &array[i][j]);
        if(max < array[i][j]){
          max = array[i][j];
          temp_x = i;
          temp_y = j;
        }
      }
    }
    
    printf("%d",max);
    printf("\n%d %d",temp_x, temp_y);
    
    
    
    return 0;
}