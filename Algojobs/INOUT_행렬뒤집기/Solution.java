#include <stdio.h>

int main() {

    //Please Enter Your Code Here
    int N;
    scanf("%d",&N);
    
    int array[10][10];
    
    for(int i = 0; i < 10 ; i++){
      for(int j = 0; j < 10; j++){
        array[i][j] = 0;
      }
    }
    
    for(int i = 0; i < N; i++){
      for(int b = 0; b < 10; b++){
        if(i == b){
          array[i][b] = 1;
        }
        if(array[i][b] == 1){
        array[i][b] = 0;  
        }else{
          array[i][b] = 1;
        }
        
        if(array[b][i] == 1){
        array[b][i] = 0;  
        }else{
          array[b][i] = 1;
        }
        
        
      }
      
    }
    
     for(int i = 0; i < 10 ; i++){
      for(int j = 0; j < 10; j++){
        printf("%d ",array[i][j]);
      }
      printf("\n");
    }
    
    

    return 0;
}