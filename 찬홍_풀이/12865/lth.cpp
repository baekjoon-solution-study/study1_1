#include<stdio.h>
#include<string.h>
#define max(x, y) (x) > (y) ? (x) : (y)

long long N,K;
long long weight[100],value[100];
long long cache[105][100010];
long long cache2[105][100010];
long long cache3[105][100010];
long long dp(long long itemnum,long long restweight){
	
	if(itemnum==N ){
		cache[itemnum][restweight]=0;
		cache2[itemnum][restweight]=restweight;
		cache3[itemnum][restweight]=itemnum;
		return 0;
	}
	if(cache[itemnum][restweight]!=-1){
		return cache[itemnum][restweight];
	}
	long long *res=&cache[itemnum][restweight];
	if(restweight>=weight[itemnum]){
		*res=max(dp(itemnum+1,restweight),dp(itemnum+1,restweight-weight[itemnum])+value[itemnum]);
	}
	else{
		*res=dp(itemnum+1,restweight);
	}
	cache2[itemnum][restweight]=restweight;
	cache3[itemnum][restweight]=itemnum;
	return *res;
}
int main() {
	memset(cache,-1,105*100010*sizeof(long long));
	memset(cache2,-1,105*100010*sizeof(long long));
	memset(cache3,-1,105*100010*sizeof(long long));
	
	
	
	scanf("%lld %lld",&N,&K);
	for(long long i=0;i<N;i++){
		scanf("%lld %lld",&weight[i],&value[i]);
		
	}
	
	printf("%lld",dp(0,K));

	
	return 0;
}