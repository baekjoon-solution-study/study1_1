#include<stdio.h>
/* 아이디어
가로세로 각각 따로보고 
H,N 이 주어졌다면 H를 N+1 크기의 묶음으로 묶고 
H가 남으면 +1 해서 가로세로에 각각 들어갈 사람의 수를 구하고 곱함     
*/
int main(){
    int H,W,N,M,a,b;
    scanf("%d %d %d %d",&H,&W,&N,&M);
    N++;M++;
    a=H/N + ((H%N!=0)? 1:0);
    b=W/M + ((W%M!=0)? 1:0);
    printf("%d",a*b);
}