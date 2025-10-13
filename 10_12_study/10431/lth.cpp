#include<stdio.h>
#include<string.h>
#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
/* 아이디어
삽입정렬?
*/
int main(){
    ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
   
    int n,cnt,temp,t;
    int arr[20]={0};
    cin>>n;
    for(int i=0;i<n;i++){
        cnt=0;
        cin>>t;
        for(int x=0;x<20;x++){
            cin>>temp;
            arr[x]=temp;
        }
        
        for(int a=0;a<20;a++){
            for(int b=a;b>0;b--){
                if(arr[b]<arr[b-1]){
                    int temp=arr[b];
                    arr[b]=arr[b-1];
                    arr[b-1]=temp;
                    cnt++;
                }
            }
            
        }
        
        printf("%d %d\n",t,cnt);
    }
   
}