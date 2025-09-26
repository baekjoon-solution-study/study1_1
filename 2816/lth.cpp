#include<stdio.h>
#include<string.h>
#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
/* 아이디어
방법 수 500 넘으면 안됨
채널 최대 길이는 100임
최악의 경우로 kbs1 찾아 1로 올리는 방범 -> 100+100
최악의 경우로 kbs2 찾아 2로 올리는 방법 -> 99+99
최단의 방법을 찾는게 아니니 이 방법으로도 ㅇㅋ
*/
int main(){
    ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
    int n,a=0,b=0;
    string temp;
    cin>>n;
    for(int i=0;i<n;i++){
        cin>>temp;
        if(temp.compare("KBS1")==0){
            a=i;
        }
        if(temp.compare("KBS2")==0){
            b=i;
        }
    }
    if(a<b){
        for(int i=0;i<a;i++){
            printf("1");
        }
        for(int i=0;i<a;i++){
            printf("4");
        }
        for(int i=0;i<b;i++){
            printf("1");
        }
        for(int i=0;i<b-1;i++){
            printf("4");
        }
    }
    else{
        for(int i=0;i<a;i++){
            printf("1");
        }
        for(int i=0;i<a;i++){
            printf("4");
        }
        for(int i=0;i<b+1;i++){
            printf("1");
        }
        for(int i=0;i<b;i++){
            printf("4");
        }
    }
}