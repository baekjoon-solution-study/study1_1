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
using namespace std;
/* 아이디어
탐..욕?
1은 맨앞에서 0은 맨뒤에서

*/



int main(){
    ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
   
    string input;
    string ans="";
    int cntz=0,cnto=0;
    cin>>input;
    cntz=count(input.begin(),input.end(),'0');
    cnto=input.length()-cntz;
    cntz/=2;cnto/=2;
    for(int i=0;i<input.length();i++){
        if(input[i]=='0' && cntz!=0){
            ans.push_back('0');
            cntz--;
        }
        else if(input[i]=='1' && cnto==0){
            ans.push_back('1');
        }
        else if(input[i]=='1' && cnto!=0){
            cnto--;
        }
    }
    cout<<ans;
    
    
}