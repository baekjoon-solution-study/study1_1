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
비트마스킹 인듯
1~10 번호마다 자기 왼쪽에 있는 자기보다 큰 애들 숫자가 주어지고
그러면 각 번호마다 왼쪽에 있는게 가능한 set이 생김
4
2(2,3,4)
1(3,4)
1(4)
0(null)
숫자가 0인것 중 제일 작은거 부터 처리
case 2
7
6(2,3,4,5,6,7)
1(3,4,5,6,7)
1(4,5,6,7)
1(5,6,7)
2(6,7)
0(7)
0(null)
6->2->3->4->7->5->1
5(2,3,4,5,7)
0(3,4,5,7)
0(4,5,7)
0(5,7)
1(7)
0(null)

*/
struct node{
    int cnt;
    int set;
};

int main(){
    ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
   
    int n;
    node temp;
    vector<node> arr;
    
    cin>>n;
  
    
    for(int i=0;i<n;i++){
        cin>>temp.cnt;
        temp.set=((1<<n)-1)-((1<<(i+1))-1);
        arr.push_back(temp);
    }
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            if(arr[j].cnt==0 && ((~arr[j].set)&(1<<13))){
                cout<<j+1<<" ";
                arr[j].set|=(1<<13);//done bit
                for(int a=0;a<n;a++){
                    if((arr[a].set&(1<<j)) && ((~arr[a].set)&(1<<13))){
                        arr[a].set=arr[a].set&(~(1<<j));
                        arr[a].cnt--;
                    }
                }
                break;
            }
        }
    }
 
    
    
}