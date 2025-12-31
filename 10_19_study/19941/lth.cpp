#include<stdio.h>
#include<string>
#include<iostream>
#include<algorithm>
#include<vector>
#include<set>
#include<map>
#include <numeric>
using namespace std;
/* 아이디어
n기준으로 k범위안에 있는 햄버거중 가장 앞에 것 부터 먹기
-> n보다 뒤에있는 사람들은 가장 n기준으로 가장 앞에있는 햄버거 못먹음
*/



int main(){
    ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
   
    string input;
    int n,k;
    int cnt=0;
    cin>>n>>k;
    cin>>input;
    for(int i=0;i<input.length();i++){
        if(input[i]=='P'){
            for(int j=max(i-k,0);j<input.length() && j<=i+k;j++){
                if(input[j]=='H'){
                    input[j]='E';
                    cnt++;
                    break;
                }
            }
        }
    }
    cout<<cnt;
    
}