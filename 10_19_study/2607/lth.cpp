#include<stdio.h>
#include<string>
#include<iostream>
#include<algorithm>
#include<vector>
#include<set>
#include<map>
#include <numeric>
#include<bit>
using namespace std;
/* 아이디어
단어 갯수 100, 단어길이 10
완전탐색으로 가능
10*26*100

*/



int main(){
    ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
   
    int n;
    string first,temp;
    int first_arr[26]={0};
    int ans=0,diff=0;
    cin>>n;
    cin>>first;
    for(int i=0;i<first.length();i++){
        first_arr[first[i]-'A']++;
    }
    for(int j=1;j<n;j++){
        diff=0;
        cin>>temp;
        for(int i=0;i<26;i++){
            diff+=abs(first_arr[i]-count(temp.begin(),temp.end(),'A'+i));
            if(diff>2){
                break;
            }
            
        }
        if(diff<=2 && 2>abs((int)first.length()-(int)temp.length())){
            ans++;
        }
        
    }
    
    cout<<ans;
    
}