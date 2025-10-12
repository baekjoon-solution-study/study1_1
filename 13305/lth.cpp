#include<iostream>
#include<algorithm>
#include<vector>
#include<set>
using namespace std;
/* 아이디어
탐욕법
현재보다 값 저렴한 곳 까지만 이동할만큼 삼, 끝은 일부러 0으로
->틀림
아니 최대 가능한 숫자가 10억*10억*10만이 말이되나
*/

int main(){
    ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
   
    int n,temp;
    cin>>n;
    vector<int> len;
    vector<int> price;
    for(int i=0;i<n-1;i++){
        cin>>temp;
        len.push_back(temp);
    }
    for(int i=0;i<n-1;i++){
        cin>>temp;
        price.push_back(temp);
    }
    price.push_back(0);
    long long start=0,end=1,ans=0;
    while(1){
        long long dis=0;
        for(;end<n;end++){
            dis+=len[end-1];
            if(price[start]>price[end]){
                break;
            }
            
        }
        ans+=dis*price[start];
        //cout<<ans<<" "<<dis<<'\n';
        if(end==n-1){
            break;
        }
        start=end;
        end=start+1;
    }
    cout<<ans;
}