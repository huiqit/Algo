Q1.1 a^b
/*
      a<0 a=0 a>0
b<0   
b=0
b>0

*/
public double power(int x, int n) {
  if(x == 0) {
    return 0;
  }
  
  if(n >= 0) {
    return powerHelper(x, n);
  } else {
    return 1/(double)powerHelper(x, -n); //此处虽然传入b结果一样，但意义不同，且违背了我们定义helper func的语意
  }
}

public int powerHelper(int a, int b) {
  if(b == 0) {
    return 1;
  } 
  int half = powerHelper(a, b/2);
  if(b % 2 == 0) {
    return half * half;
  } else {
    return half * half * a;
  }
}


    
    

