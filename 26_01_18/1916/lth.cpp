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
우선순위큐, 다익스트라
*/

int n,m;
int st,ed;
int maap[1005][1005];
int dist[1005];
int visit[1005];

void diks(){
    priority_queue<vector<int>, vector<vector<int>>, greater<vector<int>>> pq;
    pq.push({0,st});
    dist[st]=0;
    int new_cost;
    int new_node;
    while(!pq.empty()){
        new_cost=pq.top()[0];
        new_node=pq.top()[1];
        pq.pop();
        if (dist[new_node] < new_cost) continue;
        for(int i=0;i<=n;i++){
            if(maap[new_node][i]!=987654321){
                if(new_cost+maap[new_node][i]<dist[i]){
                    dist[i]=new_cost+maap[new_node][i];
                    pq.push({dist[i],i});
                }
            }
        }
    }

}

int main(){
    ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

    
    for(int i=0; i<1005; i++){
        for(int j=0; j<1005; j++){
            if(i == j) maap[i][j] = 0;
            else maap[i][j] = 987654321;
        }
        dist[i]=987654321;
    }
    cin>>n>>m;
    int i,j,v;
    for(int a=0;a<m;a++){
        cin>>i>>j>>v;
        if (maap[i][j] > v) {
            maap[i][j] = v;
        }
    }
    
    cin>>st>>ed;
    diks();
    cout<<dist[ed];
    

}