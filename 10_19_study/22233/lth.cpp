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
using namespace std;
/* 아이디어
? 브론즈?
-> 시간초과 
-> 이분탐색
*/
struct titlest {
    string title;
    int power;
};

vector<titlest> t;





int main(){
    ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
   
    int n,m;
    map<string,int> keword;
    string temp;
    cin>>n>>m;
    for(int i=0;i<n;i++){
        cin>>temp;
        keword[temp]=1;
    }
    for(int i=0;i<m;i++){
        cin>>temp;
        stringstream ss(temp);
        string token;
        while (getline(ss, token, ',')) {
            if(keword.find(token)!=keword.end()){
                keword.erase(token);
            }
        }
        cout<<keword.size()<<'\n';
    }


    
    
}