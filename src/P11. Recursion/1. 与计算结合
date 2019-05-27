Q1.1 a^b
/*
模块化你的逻辑
helper function就做helper function的事，error msg在主程序里处理
6种情况，合并，分类
注意强制转化应发生在分母上（运算之前），而非之后
*/
public double power(int a, int b) {
  if(a == 0) {
    return 0;
  }
  
  if(b >= 0) {
    return powerHelper(a, b);
  } else {
    return 1/(double)powerHelper(a, -b); //此处虽然传入b结果一样，但意义不同，且违背了我们定义helper func的语意
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


    
    

