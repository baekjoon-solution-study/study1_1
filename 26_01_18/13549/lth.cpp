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
bfs?
*/

int n,k;
int visited[100005];

int bfs(int cur){
    queue<vector<int>> q;
    q.push({cur,0});
    visited[cur]=1;
    vector<int> temp;
    while(!q.empty()){
        temp=q.front();
        q.pop();
        for(int i=temp[0];i<=100000 ;i*=2){
            
            if(i==k){
                return temp[1];
            }
            if(visited[i] ==0){
                q.push({i,temp[1]});
                visited[i]=1;
            }
            if(i==0){
                break;
            }
        }
        
        if(temp[0]!=0 && visited[temp[0]-1] ==0){
            q.push({temp[0]-1,temp[1]+1});
            visited[temp[0]-1]=1;
        }
        if(temp[0]<100000 && visited[temp[0]+1] ==0){           
            q.push({temp[0]+1,temp[1]+1});
            visited[temp[0]+1]=1;
        }
        
    }
    return -1;
}

int main(){
    ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

    
    cin>>n>>k;

    cout<<bfs(n);
}