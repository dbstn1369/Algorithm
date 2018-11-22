#include <stdio.h>

int main() {
    
    
    int color[1001];
    
    int sum =0;
    int N;
    
    scanf("%d" , &N);
    int array[N];
    for(int i = 0; i < N; i++){
      scanf("%d", &array[i]);
    }
    
    for(int i = 0; i< 1001; i++){
      color[i] = 0;
    }
    
    for(int i = 1 ; i < 1001; i++){
      for(int j = 0; j < N; j++){
        if(array[j] == i && color[i] <2){
          color[i]++; 
        }
      }
    }
    
    for(int i = 0 ; i < 1001; i++){
      sum = sum + color[i];
    }
    
    if(sum >= 6 ){
      printf("YES");
    }else{
      printf("NO");
    }
    
    
    
   
    return 0;
}