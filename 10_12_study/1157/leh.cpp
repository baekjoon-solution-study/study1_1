#include<stdio.h>
#include<string.h>
#include<iostream>
#include<algorithm>
using namespace std;
/* 아이디어
주어진 배열에서 24개의 알파벳(대소문자 각각 셈)을 count
max값 찾으면 ans 업데이트
max값이랑 같으면 ans=?
but count함수 비용이 높으므로 효율 x
*/
int main(){
    ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
    string arr;
    cin >> arr;
    int cnt=0,max=0,ans=0;
    for(int i='a';i<='z';i++){
        cnt=count(arr.begin(),arr.end(),i);
        cnt+=count(arr.begin(),arr.end(),i-('a'-'A'));
        if(max<cnt){
            ans=i-('a'-'A');
            max=cnt;
        }
        else if(max==cnt){
            ans='?';
        }
    }
    printf("%c",ans);
    return 0;
}