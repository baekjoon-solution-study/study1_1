#include<stdio.h>
#include<string>
#include <cstring>
#include<iostream>
#include<algorithm>
#include<vector>
#include<set>
#include<map>
#include <numeric>
#include<bit>
#include <sstream>
#include <queue>
#include <functional>

using namespace std;
/* 아이디어
탐욕 같은디
특정 지점에서부터 작거나 같아지는 지점 전까지의 max값 
-> 문제 이해 잘못함
-> 규칙 빡센디 각 그룹의 차이를 역순으로 배열 + 부분합의 합
-> 틀림
-> 뒤에서부터 현재까지 max값 찾고 정방향 순회로 max-현재값

*/




int main(){
    ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
   
    int t,n;
    int temp;
    long long mx=0,ans=0;
    
    cin>>t;
  
    
    for(int i=0;i<t;i++){
        cin>>n;
        mx=0;
        ans=0;
        vector<long long> arr;
        vector<long long> mx_arr;
        for(int j=0;j<n;j++){
            cin>>temp;
            arr.push_back(temp);
            mx_arr.push_back(0);
        }
        for(int j=n-1;j>=0;j--){
            mx=max(mx,arr[j]);
            mx_arr[j]=mx;
        }
        for(int j=0;j<n;j++){
            ans+=mx_arr[j]-arr[j];
        }
        cout<<ans<<'\n';
    }
    
 
    
    
}