	  public int reverse(int x) {
		 boolean sign = (x<0)?true:false;
		 x = Math.abs(x);
		 long n = 0;
		 while(x>0) {
			 n = n*10 + (x%10);
			 x = Math.floorDiv(x, 10);
		 }
		 
		return (int) ((n > 0x7FFFFFFF) ? 0 : sign? -n:n);  
	    }	