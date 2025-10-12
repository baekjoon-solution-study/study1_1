#include<stdio.h>
#include<string.h>
#include<iostream>
#include<algorithm>
#include<vector>
#include<set>
using namespace std;
/* 아이디어
기존배열 정렬 후 1회 탐색하며 my_rank 조절
뭐야 왜 0<=n<=p 로 되어있지 이럼 -1 나오는 경우가 n==p 이고 꼴찌랑 점수 같을 때 밖에 없는데
*/
int main(){
    ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
   
    int n,my_score,p;
    int my_rank=1;

    vector<int> arr;
    int temp;

    cin>>n>>my_score>>p;
    for(int i=0;i<n;i++){
        cin>>temp;
        arr.push_back(temp);
    }
    sort(arr.rbegin(),arr.rend());
    if(n==p && arr[n-1]>=my_score){
        cout<<"-1";
    }
    else{
        for(int i=0;i<n;i++){
            if(arr[i]>my_score){
                my_rank++;
            }
        }
        cout<<my_rank;
    }

}