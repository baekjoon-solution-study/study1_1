#include<stdio.h>
#include<string.h>
#include<iostream>
#include<algorithm>
#include<vector>
#include<set>
#include<map>
#include <numeric>
using namespace std;
/* 아이디어
입력 존나큼 - n 안에
전형적인 부분합
*/



int main(){
    ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
   
    int n,x;
    vector<int> arr={0};
    int ma=0;
    int count=1;
    int temp;
    cin>>n>>x;
    
    for(int i=1;i<=n;i++){
        cin>>temp;
        arr.push_back(temp);
        
        arr[i]+=arr[i-1];
        
        if(i>=x){
            int t=arr[i]-arr[i-x];
            if(t>ma){
                ma=t;
                count=1;
            }
            else if(t==ma){
                count++;
            }
            
        }
    }
    if(ma==0){
        cout<<"SAD";
    }
    else{
        cout<<ma<<'\n';
        cout<<count;
    }
    
}