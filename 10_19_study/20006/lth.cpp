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
방 갯수 300, 플레이어 수 300
300명이 최대 300개의 방을 순회 90000
단순구현으로 가능
*/

struct ply{
    int level;
    string name;
};



int main(){
    ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
   
    int p,m;
    ply temp;
    int cnt=0;
    vector<vector<ply>> mat;
    cin>>p>>m;
  
    
    for(int i=0;i<p;i++){
    
        cin>>temp.level>>temp.name;
  
        int j;
        for(j=0;j<cnt;j++){
            if(mat[j].size()==m){
                continue;
            }
            if(mat[j][0].level-10<=temp.level && mat[j][0].level+10>=temp.level){
                mat[j].push_back(temp);
                break;
            }
            
        }
        if(j==cnt){
            vector<ply> temp_vec;
            temp_vec.push_back(temp);
            mat.push_back(temp_vec);
            cnt++;
        }
    }
    
    for(int i=0;i<cnt;i++){
        sort(mat[i].begin(),mat[i].end(),[](const ply& p1, const ply& p2) {
            return p1.name < p2.name; 
        });
        if(mat[i].size()==m){
            cout<<"Started!"<<'\n';
        }
        else{
            cout<<"Waiting!"<<'\n';
        }
        for(int j=0;j<mat[i].size();j++){
            cout<<mat[i][j].level<<" "<<mat[i][j].name<<'\n';
        }
    }
    
    
    
}