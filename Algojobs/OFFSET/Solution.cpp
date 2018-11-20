#include <stdlib.h>
#include <stdio.h>

int main() {

	//Please Enter Your Code Here
	int dx[4] = { -1,0,1,0 };
	int dy[4] = { 0,1,0,-1 };
	int index = 0;

	int array[5][5];


	for (int i = 0; i < 5; i++) {
		for (int j = 0; j < 5; j++) {
			scanf("%d",&array[i][j]);
		}
	}

	for (int i = 0; i < 5; i++) {
		for (int j = 0; j < 5; j++) {
			for (int k = 0; k < 4; k++) {
			 
				int nx = i + dx[k];
				int ny = j + dy[k];
			  
			
				if (nx < 0 || ny < 0 || nx > 4 || ny > 4) {
				  if(index ==3){
				       printf("* ");
			  	}
				  
				  index++;
				   
					continue;
				}

				if (array[i][j] < array[nx][ny]) {
				  if(index ==3){
				       printf("* ");
			  	}
  				index++;
					continue;
				}
				else{
	         printf("%d ",array[i][j]);
					break;
				}
			
			}
			index =0;
		}
		printf("\n");
	}

	




	return 0;
}