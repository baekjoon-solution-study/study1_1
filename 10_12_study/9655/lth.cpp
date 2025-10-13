#include<stdio.h>
#include<string.h>
#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
/* 아이디어
홀수 -> 상근승 
짝수 -> 창영승
*/
int main(){
    ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
   
    int n;
    cin>>n;
    if(n%2==0){
        printf("CY");
    }
    else{
        printf("SK");
    }
   
}