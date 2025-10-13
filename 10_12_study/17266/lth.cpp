#include<stdio.h>
#include<string.h>
#include<iostream>
#include<algorithm>
#include<vector>
#include<set>
using namespace std;
/* 아이디어
탐욕법
제일 앞의 전등부터 시작해서 그 전등으로 왼쪽 제일 끝의 어둠을 밝히는 길이를 저장, 이 길이 최댓값
-> 틀림
처음 끝 제외 두 전등사이의 거리 /2 한 값중 최댓값 찾기
-> 틀림
m=1 일때 예외처리
*/

int main(){
    ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
   
    int n,m,temp=0;
    int mx=0,before=0;
    cin>>n;
    cin>>m;
    for(int i=0;i<m;i++){
        before=temp;
        cin>>temp;
        if(m==1){
            mx=max(n-temp,temp);
        }
        else if(i==m-1){
            mx=max(mx,(temp-before+1)/2);
            mx=max(mx,n-temp);
        }
        else if(i==0){
            mx=temp;
        }
        else{
            mx=max(mx,(temp-before+1)/2);
        }
    }
    cout<<mx;
    
}