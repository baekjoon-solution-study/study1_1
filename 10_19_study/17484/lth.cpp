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
재귀인듯, dp도 적용가능 근데 굳이 안할듯
*/
int arr[6][6];
int n,m;
int find(int before,int x, int y){
    if(x<0 || x>=m || y>=n){
        return 999999;
    }
    if(y==n-1){
        return arr[y][x];
    }
    int mi=999999;
    for(int i=0;i<3;i++){
        if(before==i){
            continue;
        }
        else if(i==0){
            mi=min(find(0,x-1,y+1),mi);
        }
        else if(i==1){
            mi=min(find(1,x,y+1),mi);
        }
        else if(i==2){
            mi=min(find(2,x+1,y+1),mi);
        }
    }
    return mi+arr[y][x];
    

}


int main(){
    ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
   
    string input;
    cin>>n>>m;
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            cin>>arr[i][j];
        }
    }
    int mi=999999;
    for(int i=0;i<m;i++){
        mi=min(mi,find(-1,i,0));
    }
    cout<<mi;
    
}