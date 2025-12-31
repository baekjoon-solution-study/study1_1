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
? 브론즈?
-> 시간초과 
-> 이분탐색
*/
struct titlest {
    string title;
    int power;
};

vector<titlest> t;

string find(int start,int end,int sco){
    int mid=(start+end)/2;
    
    if(mid==0){
        return t[0].title;
    }
    else if(sco>t[mid-1].power && sco<=t[mid].power){
        return t[mid].title;
    }
    else if(sco>t[mid].power){
        return find(mid,end,sco);
    }
    else{
        return find(start,mid,sco);
    }
    
}



int main(){
    ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
   
    int n,m;
    int sco;
    

    cin>>n>>m;
    for(int i=0;i<n;i++){
        titlest temp;
        cin>>temp.title>>temp.power;
        t.push_back(temp);
    }
    for(int i=0;i<m;i++){
        
        cin>>sco;
        cout<<find(0,n,sco)<<'\n';
    }

    
    
}