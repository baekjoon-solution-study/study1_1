#include<stdio.h>


/*
아이디어
일반항 num 이 1+6*i(i= 1,3,6,10 ...)
이므로 변수 j=0에 i-(0,1,2,3...)을 더하면
j=0,1,3,6,10.... 이다
*/
int main(){
    int num,j=0;
    scanf("%d",&num);
    for(int i=0;i<100000000;i++){
        j+=i;
        if(num<=1+6*j){
            printf("%d",i+1);
            break;
        }
    }
}