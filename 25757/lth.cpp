#include<stdio.h>
#include<string.h>
#include<iostream>
#include<algorithm>
#include<vector>
#include<set>
using namespace std;
/* 아이디어
걍 중복제거하고 문자열 다 검색 한 다음에
게임인원수 -1 로 나눠주면 될듯
-> vector 쓰니까 시간초과 
-> set으로 변경
*/
int main(){
    ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
   
    int n;
    char game;
    string str;
    set<string> arr;
    cin>>n>>game;
    if(game=='Y'){
        game=1;
    }
    else if(game=='F'){
        game=2;
    }
    else if(game=='O'){
        game=3;
    }
    for(int i=0;i<n;i++){
        cin>>str;
        arr.insert(str);
    }
    cout<<arr.size()/game;
}