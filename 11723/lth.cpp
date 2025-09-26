#include<stdio.h>
#include<string.h>
#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
/* 아이디어
걍 벡터 그대로 쓰면 될듯
-> 찬홍이형이 비트마스킹 쓴다던 문제 같아서 해봄
*/
int main(){
    ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
    string order;
    int n,num;
    int arr=0;
    cin>>n;
    for(int i=0;i<n;i++){
        cin>>order;
        if(order.compare("all")==0){
            arr=(1<<21)-1;
            continue;
        }
        else if(order.compare("empty")==0){
            arr=0;
            continue;
        }
        cin>>num;
        if(order.compare("add")==0){
            arr=arr|(1<<num);
        }
        else if(order.compare("remove")==0){
            arr=arr&(~(1<<num));
        }
        else if(order.compare("check")==0){
            if(arr&(1<<num)){
                printf("1\n");
            }
            else{
                printf("0\n");
            }
        }
        else if(order.compare("toggle")==0){
            arr=arr^(1<<num);
        }
        
    }
}