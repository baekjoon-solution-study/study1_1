#include<stdio.h>
#include<string.h>
#include<iostream>
#include<algorithm>
#include<vector>
#include<set>
using namespace std;
/* 아이디어
각 팀의 수가 6명 이상인지 탐색 O(1000^2)
200개 팀중 6명 이상인 애들만 등수매겨서 저장
*/

int main(){
    ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
   
    int t,n,temp;
    

    cin>>t;
    for(int i=0;i<t;i++){
        vector<int> arr;
        vector<vector<int>> score(201);
        int rank=1;
        int win[3]={99999,99999,0},sum=0;

        cin>>n;

        for(int j=0;j<n;j++){
            cin>>temp;
            arr.push_back(temp);
        }

        for(int j=0;j<n;j++){
            if(count(arr.begin(),arr.end(),arr[j])<6){
                continue;
            }
            else{
                score[arr[j]].push_back(rank);
                rank++;
            }
        }
        for(int j=0;j<201;j++){
            if(score[j].size()>0){
                sum=score[j][0]+score[j][1]+score[j][2]+score[j][3];
                if(win[0]>sum || (win[0]==sum && win[1]>score[j][4])){
                    win[0]=sum;
                    win[1]=score[j][4];
                    win[2]=j;
                }
            }
        }
        cout<<win[2]<<'\n';
    }
    
}