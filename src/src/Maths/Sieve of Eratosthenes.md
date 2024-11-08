# With Comments
```java
public boolean isPrime(int num,int n){
        //Use a boolean Array
        boolean[] sieve=new boolean[n+1];

        //Now Applying Algorithm
        Arrays.fill(sieve,true);//First Mark all the Indexes as True

        for(int i=2;i<=Math.sqrt(n);i++){//Start Traversing From index 2 to the Square Root of 'n' because after that the value will go beyond 'n'
            if(sieve[i]){//if the Index is true that means it is a Prime Number.
                //Start Marking from Square of the Number 'i' because Prior to that every number multiple is already marked from previous numbers
                for(int idx=i*i;idx<=n;idx+=i){//Then Mark it's all Multiples as false because
                    // later on this Number can factorize them and hence they will not be Prime Numbers
                    //this Idx+=i will make the loop run as Table of 'i'
                    sieve[idx]=false;
                }
            }
        }
        return sieve[num];
    }
```

# Without Comments
```java
public boolean isPrime(int num,int n){       
        boolean[] sieve=new boolean[n+1];

        Arrays.fill(sieve,true);

        for(int i=2;i<=Math.sqrt(n);i++){
            if(sieve[i]){
                for(int idx=i*i;idx<=n;idx+=i){
                    sieve[idx]=false;
                }
            }
        }
        return sieve[num];
    }
```
