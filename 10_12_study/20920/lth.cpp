#include<stdio.h>
#include<string.h>
#include<iostream>
#include<algorithm>
#include<vector>
#include<set>
#include<map>
using namespace std;
/* 아이디어
탐욕법
vector 에 struct 넣고 sort 쓸 때 람다 비교식 지정해서 세가지요소 한번에 정렬
-> 틀림
아 씨발 입력부터 시간초과뜸 생각좀 하고할껄 (10만*10만)
무조건 딕션, 맵인듯
만든거 아까우니까 맵입력 -> 벡터로 전환해야할듯 개 비효율
*/
struct word_info{
    string word;
    int count;
    int len;
};


int main(){
    ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
   
    int n,m;
    string temp;
    cin>>n>>m;
    vector<word_info> word_list;
    map<string,int> input;
    for(int i=0;i<n;i++){
        cin>>temp;
        if(temp.length()<m){
            continue;
        }
        if(input.find(temp)==input.end()){
            input[temp]=1;
        }
        else{
            input[temp]++;
        }
    }
    for(auto i=input.begin();i!=input.end();i++){
        word_info t;
        t.word=i->first;
        t.len=i->first.length();
        t.count=i->second;
        word_list.push_back(t);
    }

    sort(word_list.rbegin(), word_list.rend(), [](const word_info& a, const word_info& b) {
    
        if (a.count != b.count) {
            return a.count < b.count;
        }

        if (a.len != b.len) {
            return a.len < b.len;
        }

        return a.word > b.word;
    });
    for(int j=0;j<word_list.size();j++){
        cout<<word_list[j].word<<'\n';
    }
}