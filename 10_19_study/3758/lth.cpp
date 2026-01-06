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
걍 깡구현 문제 같은데
개오래걸리네

*/



int main(){
    ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
   
    int T;
    int n,k,t,m;
    int i,j,s;
    
    int score[100][100];
    
    cin>>T;
    for(int a=0;a<T;a++){
        cin>>n>>k>>t>>m;
        memset(score,0,10000*sizeof(int));
        vector<vector<int>> arr;
        for(int b=0;b<n;b++){
            vector<int> temp;
            temp.push_back(0);
            temp.push_back(10000);
            temp.push_back(0);
            temp.push_back(b);
            arr.push_back(temp);
        }

        
        for(int b=0;b<m;b++){
            cin>>i>>j>>s;
            i--;
            j--;
            arr[i][1]--;
            arr[i][2]=m-b;
            if(score[i][j]<s){
                arr[i][0]+=s-score[i][j];
                score[i][j]=s;
            }
        }

        sort(arr.rbegin(),arr.rend());
        for(int b=0;b<n;b++){
            if(arr[b][3]==t-1){
                cout<<b+1<<'\n';
            }
        }
    }
    
    
}