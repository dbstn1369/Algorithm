#include <stdio.h>

int main() {

    //Please Enter Your Code Here
    int A;
    int B;
    int GCD =1;
    int LCM = 1;
    int i = 2;
    scanf("%d %d", &A, &B);
    while(i<10){    
          
      while(A%i == 0 && B%i == 0){
        GCD = GCD * i;
        A = A/i;
        B = B/i;
      }
      i++;
    }
     LCM = GCD * A * B;
      
    printf("%d\n",GCD);
    printf("%d",LCM);
    return 0;
}