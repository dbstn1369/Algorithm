#include stdio.h

int main() {

    Please Enter Your Code Here
    int result;
    int array[5];
    
    for(int i = 0; i  5; i++){
      scanf(%d, &array[i]);
    }
    
    int sum=0;
    
    for(int i = 0; i  5; i++){
      sum = sum + (array[i]array[i]);
    }
    
    result = sum % 10;
    
    printf(%d, result);
      
    return 0;
}